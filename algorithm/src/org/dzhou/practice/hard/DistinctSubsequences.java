package org.dzhou.practice.hard;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 * @author zhoudong
 *
 *         “When you see string problem that is about subsequence or matching,
 *         dynamic programming method should come to your mind naturally. ”
 * 
 *         reference: http://blog.csdn.net/abcbc/article/details/8978146
 * 
 *         - - r a b b b i t <br>
 *         - 1 1 1 1 1 1 1 1 <br>
 *         r 0 1 1 1 1 1 1 1 <br>
 *         a 0 0 1 1 1 1 1 1 <br>
 *         b 0 0 0 1 2 3 3 3 <br>
 *         b 0 0 0 0 1 3 3 3 <br>
 *         i 0 0 0 0 0 0 3 3 <br>
 *         t 0 0 0 0 0 0 0 3 <br>
 */
public class DistinctSubsequences {

	// Dynamic Solution
	public class Solution {
		public int numDistinct(String s, String t) {
			if (s == null || t == null)
				return 0;
			if (s.isEmpty()) {
				if (t.isEmpty())
					return 1;
				else
					return 0;
			}
			int[][] dp = createDpTable(t.length() + 1, s.length() + 1);
			init0thRowIsMatchEmptyTarget(dp[0]);
			runDP(dp, t, s);
			return dp[t.length()][s.length()];
		}

		private int[][] createDpTable(int row, int col) {
			int[][] table = new int[row][col];
			table[0][0] = 1;
			return table;
		}

		private void init0thRowIsMatchEmptyTarget(int[] row) {
			for (int col = 1; col < row.length; col++) {
				row[col] = 1;
			}
		}

		private void runDP(int[][] dp, String t, String s) {
			for (int i = 1; i < dp.length; i++) {
				for (int j = 1; j < dp[i].length; j++) {
					if (t.charAt(i - 1) == s.charAt(j - 1)) {
						dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
					} else {
						dp[i][j] = dp[i][j - 1];
					}
				}
			}
		}
	}

	// DFS solution
	public class Solution1 {
		int max = 0;

		public int numDistinct(String s, String t) {
			dfs(s, t);
			return max;
		}

		private void dfs(String s, String t) {
			if (t.length() == 0) {
				max++;
				return;
			}
			if (s.length() == 0)
				return;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == t.charAt(0)) {
					dfs(s.substring(i + 1), t.substring(1));
				}
			}
		}
	}
}
