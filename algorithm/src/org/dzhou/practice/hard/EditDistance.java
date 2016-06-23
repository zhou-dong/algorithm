package org.dzhou.practice.hard;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * 
 * b) Delete a character
 * 
 * c) Replace a character
 * 
 * @author zhoudong
 *
 */
public class EditDistance {

	public class Solution {

		public int minDistance(String word1, String word2) {

			int len1 = word1.length();
			int len2 = word2.length();

			int[][] dp = new int[len1 + 1][len2 + 1];

			for (int i = 0; i < len1 + 1; i++) {
				dp[i][0] = i;
			}

			for (int j = 0; j < len2 + 1; j++) {
				dp[0][j] = j;
			}

			for (int i = 1; i < len1 + 1; i++) {
				char c1 = word1.charAt(i - 1);
				for (int j = 1; j < len2 + 1; j++) {
					char c2 = word2.charAt(j - 1);
					if (c1 == c2) {
						dp[i][j] = dp[i - 1][j - 1];
					} else {
						int replace = dp[i - 1][j - 1] + 1;
						int insert = dp[i - 1][j] + 1;
						int delete = dp[i][j - 1] + 1;
						dp[i][j] = Math.min(Math.min(replace, insert), delete);
					}
				}
			}

			return dp[len1][len2];

		}

	}

}
