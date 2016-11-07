package com.dzhou.interview.google;

import java.util.Arrays;

/**
 * 279. Perfect Squares
 * 
 * Difficulty: Medium
 * 
 * a positive integer n, find the least number of perfect square numbers (for
 * example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 * 
 * @author zhoudong
 *
 */
public class PerfectSquares {

	public int numSquares(int n) {

		int[] dp = new int[n + 1];

		// 将所有非平方数的结果置最大，保证之后比较的时候不被选中
		Arrays.fill(dp, Integer.MAX_VALUE);

		// 将所有平方数的结果置1
		for (int i = 1; i * i <= n; i++) {
			dp[i * i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; i + j * j <= n; j++) {
				dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
			}
		}
		return dp[n];
	}

}
