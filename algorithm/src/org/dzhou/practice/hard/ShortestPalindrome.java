package org.dzhou.practice.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * For example:
 * 
 * Given "aacecaaa", return "aaacecaaa".
 * 
 * Given "abcd", return "dcbabcd".
 * 
 * @author zhoudong
 *
 *         reference: https://www.youtube.com/watch?v=c4akpqTwE5g
 * 
 *         上面reference的视频，别其他的人的用文字描述的要简单多了！
 * 
 */
public class ShortestPalindrome {

	public class Solution {
		public String shortestPalindrome(String s) {
			if (s == null || s.length() == 0)
				return "";
			if (isPalindrome(s))
				return s;
			String reverse = new StringBuilder(s).reverse().toString();
			int[] kmpTable = kmpPartialTable(s + "#" + reverse);
			return reverse.substring(0, s.length() - kmpTable[kmpTable.length - 1]) + s;
		}

		private int[] kmpPartialTable(String s) {
			int[] table = new int[s.length()];
			for (int i = 1; i < s.length(); i++) {
				int j = table[i - 1];
				while (j > 0 && s.charAt(i) != s.charAt(j))
					j = table[j - 1];
				if (s.charAt(i) == s.charAt(j)) {
					table[i] = j + 1;
				}
			}
			return table;
		}

		private boolean isPalindrome(String s) {
			if (s.length() < 2)
				return true;
			int low = 0, high = s.length() - 1;
			while (low < high) {
				if (s.charAt(low) != s.charAt(high))
					return false;
				low++;
				high--;
			}
			return true;
		}
	}

	public class Solution1 {
		public String shortestPalindrome(String s) {
			if (s == null || s.length() == 0)
				return "";
			if (isPalindrome(s))
				return s;
			String reverse = new StringBuilder(s).reverse().toString();
			String join = s + "#" + reverse;
			Set<String> properPrefix = properPrefix(join);
			Set<String> properSuffix = properSuffix(join);
			int end = longestSamePrefixSuffix(properPrefix, properSuffix);
			return reverse.substring(0, s.length() - end) + s;
		}

		private int longestSamePrefixSuffix(Set<String> prefix, Set<String> suffix) {
			int max = 0;
			for (String item : prefix) {
				if (!suffix.contains(item))
					continue;
				max = Math.max(max, item.length());
			}
			return max;
		}

		private Set<String> properPrefix(String s) {
			Set<String> result = new HashSet<>();
			for (int i = 0; i < s.length() - 1; i++) {
				result.add(s.substring(0, i + 1));
			}
			return result;
		}

		private Set<String> properSuffix(String s) {
			Set<String> result = new HashSet<>();
			for (int i = 1; i < s.length(); i++) {
				result.add(s.substring(i));
			}
			return result;
		}

		private boolean isPalindrome(String s) {
			if (s.length() < 2)
				return true;
			int low = 0, high = s.length() - 1;
			while (low < high) {
				if (s.charAt(low) != s.charAt(high))
					return false;
				low++;
				high--;
			}
			return true;
		}
	}

}
