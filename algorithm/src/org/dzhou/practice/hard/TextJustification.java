package org.dzhou.practice.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * For example,<br>
 * words: ["This", "is", "an", "example", "of", "text", "justification."]<br>
 * L: 16.
 * 
 * Return the formatted lines as:
 * 
 * [<br>
 * "This    is    an",<br>
 * "example  of text",<br>
 * "justification.  "<br>
 * ]<br>
 * Note: Each word is guaranteed not to exceed L in length.
 * 
 * @author zhoudong
 *
 */
public class TextJustification {

	public class Solution {

		public List<String> fullJustify(String[] words, int maxWidth) {

			List<String> result = new ArrayList<String>();

			int index = 0, count = 0;
			List<String> item = new ArrayList<>();
			while (index < words.length) {
				count += words[index].length() + 1;
				if (index + 1 != words.length) {
					if (count + words[index + 1].length() > maxWidth) {
						addLine(item, maxWidth, result);
						item = new ArrayList<>();
						count = 0;
					}
				} else {
					addLastLine(item, result);
				}
				index++;
			}

			return result;
		}

		private void addLine(List<String> item, int maxWidth, List<String> result) {
			StringBuilder sb = oneSpaceInterval(item);

			int index = 0;
			int count = 0;

			int base = (maxWidth - sb.length()) / item.size() - 1;
			int mod = (maxWidth - sb.length()) % item.size() - 1;

			int[] spaceCount = new int[item.size() - 1];
			Arrays.fill(spaceCount, base);
			for (int i = 0; i < mod; i++) {
				spaceCount[i]++;
			}

			for (int i = 0; i < item.size() - 1; i++) {
				index = nextSpaceIndex(sb, index);
				addSpace(sb, count);
			}
			result.add(sb.toString());
		}

		private StringBuilder addSpace(StringBuilder sb, int count) {
			for (int i = 0; i < count; i++)
				sb.append(" ");
			return sb;
		}

		private int nextSpaceIndex(StringBuilder sb, int index) {
			boolean isValid = false;
			for (int i = index; i < sb.length(); i++) {
				if (sb.charAt(i) != ' ')
					isValid = true;
				else if (isValid)
					return i;
			}
			return -1;
		}

		private void addLastLine(List<String> item, List<String> result) {
			StringBuilder sb = oneSpaceInterval(item);
			result.add(sb.toString());
		}

		private StringBuilder oneSpaceInterval(List<String> item) {
			StringBuilder sb = new StringBuilder();
			for (String word : item)
				sb.append(word).append(" ");
			return sb.deleteCharAt(sb.length() - 1);
		}

	}

}
