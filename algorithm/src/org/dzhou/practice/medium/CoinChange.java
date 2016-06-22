package org.dzhou.practice.medium;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1: coins = [1, 2, 5], amount = 11 return 3 (11 = 5 + 5 + 1)
 * 
 * Example 2: coins = [2], amount = 3 return -1.
 * 
 * Note: You may assume that you have an infinite number of each kind of coin.
 * 
 * @author zhoudong
 *
 */
public class CoinChange {

	// 动态规划
	public class Solution {

		public int coinChange(int[] coins, int amount) {
			if (coins == null || coins.length == 0 || amount <= 0) {
				return 0;
			}

			int[] dp = new int[amount + 1];
			for (int i = 1; i <= amount; i++) {
				dp[i] = Integer.MAX_VALUE;
			}

			for (int i = 1; i <= amount; i++) {
				for (int j = 0; j < coins.length; j++) {
					if (coins[j] <= i) {
						if (dp[i - coins[j]] != Integer.MAX_VALUE) {
							dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
						}
					}
				}
			}

			if (dp[amount] == Integer.MAX_VALUE) {
				return -1;
			} else {
				return dp[amount];
			}
		}
	}

	/*
	 * 使用贪心算法，但这种方法是错误的，可能会错过最优解！
	 * 
	 * 使用贪心算法，但这种方法是错误的，可能会错过最优解！
	 * 
	 * 使用贪心算法，但这种方法是错误的，可能会错过最优解！
	 */
	public class Solution1 {

		int result = -1;
		int count = 0;

		public int coinChange(int[] coins, int amount) {
			if (amount == 0)
				return 0;
			if (coins == null || coins.length == 0 || amount < 0)
				return -1;
			Arrays.sort(coins);
			dfs(coins, amount, 0);
			return result;
		}

		private void dfs(int[] coins, int amount, int val) {
			if (amount < val || result != -1)
				return;
			if (amount == val) {
				result = count;
				return;
			}
			for (int i = coins.length - 1; i >= 0; i--) {
				count += 1;
				dfs(coins, amount, val + coins[i]);
				count -= 1;
			}
		}
	}

}
