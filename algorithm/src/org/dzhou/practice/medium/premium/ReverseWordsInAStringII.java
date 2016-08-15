package org.dzhou.practice.medium.premium;

/**
 * Given an input string, reverse the string word by word. A word is defined as
 * a sequence of non-space characters.
 * 
 * The input string does not contain leading or trailing spaces and the words
 * are always separated by a single space.
 * 
 * For example, <br>
 * Given s = "the sky is blue", <br>
 * return "blue is sky the".
 * 
 * Could you do it in-place without allocating extra space?
 * 
 * @author zhoudong
 *
 */
public class ReverseWordsInAStringII {

	public class Solution {

		public void reverseWords(char[] s) {
			if (s == null || s.length < 2)
				return;
			reverse(s, 0, s.length - 1);
			int last = 0;
			for (int i = 0; i <= s.length; i++) {
				if (i == s.length || s[i] == ' ') {
					reverse(s, last, i - 1);
					last = i + 1;
				}
			}
		}

		private void reverse(char[] chars, int i, int j) {
			for (; i < j; i++, j--) {
				swap(chars, i, j);
			}
		}

		private void swap(char[] chars, int i, int j) {
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}

	}

}
