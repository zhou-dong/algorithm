package org.dzhou.again.regularexpressionmatching;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.<br>
 * '*' Matches zero or more of the preceding element.
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
 * isMatch("aa", "a*") → true<br>
 * isMatch("aa", ".*") → true<br>
 * isMatch("ab", ".*") → true<br>
 * isMatch("aab", "c*a*b") → true
 * 
 * references:
 * 
 * http://articles.leetcode.com/regular-expression-matching
 * 
 * http://harrifeng.github.io/algo/leetcode/regular-expression-matching.html
 * 
 * @author zhoudong
 * 
 *         "匹配"这个问题,非常容易转换成"匹配了一部分",整个匹配不匹配,要看"剩下的匹配"情况.<br>
 *         这就很好的把一个大的问题转换成了规模较小的问题:递归
 */
public class RegularExpressionMatching {

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
			boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
			dp[0][0] = true;
			for (int j = 1; j < dp[0].length; j++) {
				if (p.charAt(j - 1) == '*') {
					dp[0][j] = dp[0][j - 2];
				} else {
					dp[0][j] = false;
				}
			}
			return dp;
		}

		private void execute(String s, String p, boolean[][] dp, int i, int j) {
			if (isMatch(s.charAt(i - 1), p.charAt(j - 1))) {
				dp[i][j] = dp[i - 1][j - 1];
			} else if (p.charAt(j - 1) == '*') {
				if (dp[i][j - 2]) {
					dp[i][j] = dp[i][j - 2];
				} else if (isMatch(s.charAt(i - 1), p.charAt(j - 2))) {
					dp[i][j] = dp[i - 1][j];
				}
			} else {
				dp[i][j] = false;
			}
		}

		private boolean isMatch(char s, char p) {
			return p == '.' || p == s;
		}
	}

	// recursive
	public class Solution1 {

		public boolean isMatch(String s, String p) {
			if (p.length() == 0)
				return s.length() == 0;
			if (p.length() == 1)
				return s.length() == 1 && isMatch(s, p, 0);

			if (p.charAt(1) != '*')
				return isMatch(s, p, 0) && isMatch(s.substring(1), p.substring(1));

			if (isMatch(s, p.substring(2))) // appear 0 time
				return true;
			return isMatch(s, p, 0) && isMatch(s.substring(1), p);
		}

		private boolean isMatch(String s, String p, int index) {
			if (validIndex(s, index) && validIndex(p, index))
				return p.charAt(index) == '.' || p.charAt(index) == s.charAt(index);
			return false;
		}

		private boolean validIndex(String str, int index) {
			return index >= 0 && index < str.length();
		}

	}

}
