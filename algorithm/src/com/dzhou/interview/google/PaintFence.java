package com.dzhou.interview.google;

/**
 * 276. Paint Fence
 * 
 * Difficulty: Easy
 * 
 * There is a fence with n posts, each post can be painted with one of the k
 * colors.
 * 
 * You have to paint all the posts such that no more than two adjacent fence
 * posts have the same color.
 * 
 * Return the total number of ways you can paint the fence.
 * 
 * Note: n and k are non-negative integers.
 * 
 * @author zhoudong
 *
 */
public class PaintFence {

	// 因为超过相邻两个颜色一致，即不能三个颜色一致,那么x的涂色不能和前一个一致【或者】不能和前前个涂色一致。
	public int numWays(int n, int k) {
		int[] dp = new int[n + 1];
		if (n == 0 || k == 0) {
			return 0;
		}
		if (n == 1) {
			return k;
		}
		dp[0] = k;
		dp[1] = k * k;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
		}
		return dp[n - 1];
	}

}
