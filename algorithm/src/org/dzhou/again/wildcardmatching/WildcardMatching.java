package org.dzhou.again.wildcardmatching;

/**
 * '?' Matches any single character.<br>
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:<br>
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:<br>
 * isMatch("aa","a") → false<br>
 * isMatch("aa","aa") → true<br>
 * isMatch("aaa","aa") → false<br>
 * isMatch("aa", "*") → true<br>
 * isMatch("aa", "a*") → true<br>
 * isMatch("ab", "?*") → true<br>
 * isMatch("aab", "c*a*b") → false<br>
 * 
 * @author zhoudong
 *
 *         reference:
 * 
 *         https://simpleandstupid.com/2014/10/26/wildcard-matching-leetcode-%E8
 *         %A7%A3%E9%A2%98%E7%AC%94%E8%AE%B0/
 * 
 *         贪心算法 greedy algorithm
 * 
 *         自己感觉这道题用动态规划，比用贪心算法清晰多了。（纯属个人意见，见仁见智）
 * 
 *         https://www.youtube.com/watch?v=3ZDZ-N0EPV0
 * 
 *         动态规划的解法简直太棒了，幸好当时算法课的时候老师着重讲了动态规划的算法。
 * 
 */
public class WildcardMatching {

	// dynamic programming
	public class Solution {

		public boolean isMatch(String s, String p) {
			if (s == null || p == null)
				return false;
			boolean[][] dp = createTable(s, p);
			for (int i = 1; i < dp.length; i++) {
				for (int j = 1; j < dp[i].length; j++) {
					execute(s, p, dp, i, j);
				}
			}
			return dp[s.length()][p.length()];
		}

		private boolean[][] createTable(String s, String p) {
			boolean[][] table = new boolean[s.length() + 1][p.length() + 1];
			table[0][0] = true;
			for (int j = 1; j < table[0].length; j++) {
				if (p.charAt(j - 1) == '*') {
					table[0][j] = table[0][j - 1];
				} else {
					table[0][j] = false;
				}
			}
			return table;
		}

		private void execute(String s, String p, boolean[][] dp, int i, int j) {
			if (isMatch(s.charAt(i - 1), p.charAt(j - 1))) {
				dp[i][j] = dp[i - 1][j - 1];
			} else if (p.charAt(j - 1) == '*') {
				dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
			} else {
				dp[i][j] = false;
			}
		}

		private boolean isMatch(char s, char p) {
			return p == '?' || p == s;
		}
	}

	public class Solution1 {

		public boolean isMatch(String s, String p) {

			if (s == null || p == null)
				return false;

			int indexS = 0, indexP = 0;
			int star = -1, mark = -1;

			while (indexS < s.length()) {
				if (indexP < p.length() && isMatch(s, p, indexS, indexP)) {
					indexS++;
					indexP++;
				} else if (indexP < p.length() && p.charAt(indexP) == '*') {
					star = indexP;
					indexP++;
					mark = indexS;
					// 这一步是关键，匹配s中当前字符与p中‘*’后面的字符:
					// 如果匹配，则在第一个if中处理，如果不匹配，则继续比较s中的下一个字符。
				} else if (star != -1) {
					indexP = star + 1;
					indexS = mark++;
				} else {
					return false;
				}
			}

			// 跳过末尾的所有的'*'
			while (indexP < p.length() && p.charAt(indexP) == '*')
				indexP++;

			return indexP == p.length();
		}

		private boolean isMatch(String s, String p, int indexS, int indexP) {
			return p.charAt(indexP) == '?' || p.charAt(indexP) == s.charAt(indexS);
		}

	}

}
