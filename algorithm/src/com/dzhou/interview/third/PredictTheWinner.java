package com.dzhou.interview.third;

/**
 * 486. Predict the Winner
 * 
 * Given an array of scores that are non-negative integers. Player 1 picks one
 * of the numbers from either end of the array followed by the player 2 and then
 * player 1 and so on. Each time a player picks a number, that number will not
 * be available for the next player. This continues until all the scores have
 * been chosen. The player with the maximum score wins.
 * 
 * Given an array of scores, predict whether player 1 is the winner. You can
 * assume each player plays to maximize his score.
 * 
 * @author zhoudong
 *
 */
public class PredictTheWinner {

	class Solution {
		public boolean PredictTheWinner(int[] nums) {
			int n = nums.length;
			int[][] dp = new int[n][n];
			for (int i = 0; i < n; i++) {
				dp[i][i] = nums[i];
			}
			for (int len = 1; len < n; len++) {
				for (int i = 0; i < n - len; i++) {
					int j = i + len;
					dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
				}
			}
			return dp[0][n - 1] >= 0;
		}
	}

}
