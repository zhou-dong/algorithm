package org.dzhou.practice.medium;

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example,
 * 
 * Given s = "the sky is blue",
 * 
 * return "blue is sky the".
 * 
 * @author zhoudong
 *
 */
public class ReverseWordsInAString {

	public class Solution {

		public String reverseWords(String s) {

			if (s == null || s.length() == 0)
				return "";

			String[] words = s.split(" ");

			StringBuilder result = new StringBuilder();
			for (int i = words.length - 1; i >= 0; i--) {
				if (!words[i].equals(""))
					result.append(words[i]).append(" ");
			}

			return result.length() == 0 ? "" : result.substring(0, result.length() - 1);
		}

	}

}
