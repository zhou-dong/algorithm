package org.dzhou.practice.easy;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * @author zhoudong
 *
 *         梯子有n层，每次只能爬1层或2层，那么要爬到第n层，要么是从第n-1层一步上来，要不就是从n- 2层2步上来。所以递推公式：
 * 
 *         dp[n] = dp[n-1] + dp[n-2]
 */
public class ClimbingStairs {

	public int climbStairs(int n) {
		if (n == 1 || n == 2 || n == 3)
			return n;
		int[] dp = new int[n + 1];
		for (int i = 0; i < 3; i++)
			dp[i] = i;
		for (int i = 3; i < n + 1; i++)
			dp[i] = dp[i - 1] + dp[i - 2];
		return dp[n];
	}

}
