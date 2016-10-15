package org.dzhou.again.dp;

/**
 * 392. Is Subsequence
 * 
 * Difficulty: Medium
 * 
 * Given a string s and a string t, check if s is subsequence of t.
 * 
 * You may assume that there is only lower case English letters in both s and t.
 * t is potentially a very long (length ~= 500,000) string, and s is a short
 * string (<=100).
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * Example 1: s = "abc", t = "ahbgdc"
 * 
 * Return true.
 * 
 * Example 2: s = "axc", t = "ahbgdc"
 * 
 * Return false.
 * 
 * Follow up: If there are lots of incoming S, say S1, S2, ... , Sk where k >=
 * 1B, and you want to check one by one to see if T has its subsequence. In this
 * scenario, how would you change your code?
 * 
 * Binary Search Dynamic Programming Greedy
 * 
 * @author zhoudong
 *
 */
public class IsSubsequence {

	public class Greedy_Solution {

		public boolean isSubsequence(String s, String t) {
			return (s.length() == 0) ? true : greedyHelper(s, t);
		}

		private boolean greedyHelper(String s, String t) {
			int index = 0;
			for (char c : t.toCharArray()) {
				if (s.charAt(index) == c) {
					index++;
				}
				if (index == s.length()) {
					return true;
				}
			}
			return index == s.length();
		}

	}

	// Memory Limit Exceeded
	public class DP_Solution {

		public boolean isSubsequence(String s, String t) {
			return (s.length() == 0) ? true : dpHelper(s, t);
		}

		private boolean dpHelper(String s, String t) {
			boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
			dp[0][0] = true;
			initFirstRow(dp);
			initFirstCol(dp);
			for (int row = 1; row < dp.length; row++) {
				for (int col = 1; col < dp[row].length; col++) {
					if (s.charAt(row - 1) == t.charAt(col - 1)) {
						dp[row][col] = dp[row - 1][col - 1];
					} else {
						dp[row][col] = dp[row][col - 1];
					}
				}
			}
			return dp[dp.length - 1][dp[0].length - 1];
		}

		private void initFirstRow(boolean[][] dp) {
			for (int col = 1; col < dp[0].length; col++) {
				dp[0][col] = true;
			}
		}

		private void initFirstCol(boolean[][] dp) {
			for (int row = 1; row < dp.length; row++) {
				dp[row][0] = false;
			}
		}

	}

}
