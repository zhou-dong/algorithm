package org.dzhou.practice.medium;

/**
 * Note: This is an extension of House Robber.
 * 
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This time,
 * all houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, the security system for these
 * houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author zhoudong
 *
 */
public class HouseRobberII {

	public class Solution {
		public int rob(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			if (nums.length == 1)
				return nums[0];
			if (nums.length == 2)
				return Math.max(nums[0], nums[1]);
			return Math.max(robHelper(nums, 1, nums.length - 1), robHelper(nums, 0, nums.length - 2));
		}

		private int robHelper(int[] nums, int x, int y) {
			int len = y - x + 1;
			int[] dp = new int[len];
			dp[0] = nums[x];
			dp[1] = Math.max(nums[x], nums[x + 1]);
			for (int i = 2; i < len; i++)
				dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[x + i]);
			return dp[len - 1];
		}
	}
}
