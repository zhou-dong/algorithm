package org.dzhou.practice.hard;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example,
 * 
 * Given: <br>
 * s1 = "aabcc", <br>
 * s2 = "dbbca", <br>
 * 
 * When s3 = "aadbbcbcac", return true.<br>
 * When s3 = "aadbbbaccc", return false.<br>
 * 
 * @author zhoudong
 *
 */
public class InterleavingString {

	// dynamic programming solution
	public class Solution {

		public boolean isInterleave(String s1, String s2, String s3) {
			if (s1 == null || s2 == null || s1.length() + s2.length() != s3.length()) {
				return false;
			}

			boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
			dp[0][0] = true;

			for (int row = 1; row < dp.length; row++) {
				if (s1.charAt(row - 1) == s3.charAt(row - 1) && dp[row - 1][0]) {
					dp[row][0] = true;
				}
			}

			for (int col = 1; col < dp[0].length; col++) {
				if (s2.charAt(col - 1) == s3.charAt(col - 1) && dp[0][col - 1]) {
					dp[0][col] = true;
				}

			}
			for (int row = 1; row < dp.length; row++) {
				for (int col = 1; col < dp[0].length; col++) {
					if (((s3.charAt(row + col - 1) == s1.charAt(row - 1) && dp[row - 1][col]))
							|| ((s3.charAt(row + col - 1)) == s2.charAt(col - 1) && dp[row][col - 1])) {
						dp[row][col] = true;
					}
				}
			}

			return dp[s1.length()][s2.length()];
		}

	}

}
