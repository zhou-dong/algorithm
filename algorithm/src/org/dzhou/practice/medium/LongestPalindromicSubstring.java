package org.dzhou.practice.medium;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 * @author zhoudong
 *
 */
public class LongestPalindromicSubstring {

	public class Solution {

		public String longestPalindrome(String s) {

			return null;
		}

	}

	// 中心扩散法 Spread From Center
	public class Solution1 {

		String longest = "";

		public String longestPalindrome(String s) {
			for (int i = 0; i < s.length(); i++) {
				helper(s, i, 0); // 计算奇数子字符串
				helper(s, i, 1); // 计算偶数子字符串
			}
			return longest;
		}

		private void helper(String s, int idx, int offset) {
			int left = idx;
			int right = idx + offset;
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			String currLongest = s.substring(left + 1, right);// 截出当前最长的子串
			if (currLongest.length() > longest.length()) // 判断是否比全局最长还长
				longest = currLongest;
		}

	}

}
