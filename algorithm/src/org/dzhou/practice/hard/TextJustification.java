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

	public static void main(String[] args) {
		TextJustification instance = new TextJustification();
		instance.test();

	}

	private void test() {
		Solution s = new Solution();
		System.out.println(s.fullJustify(new String[] { "Listen", "to", "many,", "speak", "to", "a", "few." }, 6));
	}

	public class Solution {

		public List<String> fullJustify(String[] words, int maxWidth) {
			List<String> result = new ArrayList<String>();
			if (words == null || words.length == 0 || words[0].length() == 0) {
				result.add(wholeSpaceLine(maxWidth));
				return result;
			}
			int index = 0, count = 0;
			List<String> item = new ArrayList<>();
			while (index < words.length) {
				count += words[index].length() + 1;
				item.add(words[index]);
				if (index + 1 < words.length) {
					if (count + words[index + 1].length() > maxWidth) {
						addLine(item, maxWidth, result);
						item = new ArrayList<>();
						count = 0;
					}
				} else {
					addLastLine(item, result, maxWidth);
				}
				index++;
			}
			return result;
		}

		private void addLine(List<String> item, int maxWidth, List<String> result) {
			StringBuilder sb = oneSpaceInterval(item);
			if (item.size() == 1) {
				appendSpacesToTail(sb, maxWidth - sb.length());
			} else {
				int[] spaceCount = toBeInsertSpaceCount(sb, item, maxWidth);
				insertSpaces(spaceCount, sb);
			}
			result.add(sb.toString());
		}

		private StringBuilder insertSpaces(int[] spaceCount, StringBuilder sb) {
			int offset = 0;
			for (int i = 0; i < spaceCount.length; i++) {
				offset = nextSpaceIndex(sb, offset);
				insertSpaces(sb, spaceCount[i], offset);
			}
			return sb;
		}

		private StringBuilder insertSpaces(StringBuilder sb, int count, int index) {
			for (int i = 0; i < count; i++)
				sb.insert(index, " ");
			return sb;
		}

		private int[] toBeInsertSpaceCount(StringBuilder sb, List<String> item, int maxWidth) {
			int length = item.size() - 1;
			int[] spaceCount = new int[length];
			int base = (maxWidth - sb.length()) / length;
			int more = (maxWidth - sb.length()) % length;
			Arrays.fill(spaceCount, base);
			for (int i = 0; i < more; i++)
				spaceCount[i]++;
			return spaceCount;
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

		private void addLastLine(List<String> item, List<String> result, int maxWidth) {
			StringBuilder sb = oneSpaceInterval(item);
			appendSpacesToTail(sb, maxWidth - sb.length());
			result.add(sb.toString());
		}

		private StringBuilder appendSpacesToTail(StringBuilder sb, int count) {
			for (int i = 0; i < count; i++) {
				sb.append(" ");
			}
			return sb;
		}

		private StringBuilder oneSpaceInterval(List<String> item) {
			StringBuilder sb = new StringBuilder();
			for (String word : item)
				sb.append(word).append(" ");
			return sb.deleteCharAt(sb.length() - 1);
		}

		private String wholeSpaceLine(int count) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < count; i++)
				sb.append(" ");
			return sb.toString();
		}

	}

}
