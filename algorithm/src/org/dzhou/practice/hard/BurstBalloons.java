package org.dzhou.practice.hard;

/**
 * 312. Burst Balloons
 * 
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a
 * number on it represented by array nums. You are asked to burst all the
 * balloons. If the you burst balloon i you will get nums[left] * nums[i] *
 * nums[right] coins. Here left and right are adjacent indices of i. After the
 * burst, the left and right then becomes adjacent.
 * 
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * 
 * Note: <br>
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you
 * can not burst them. <br>
 * (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 * Example: <br>
 * Given [3, 1, 5, 8] <br>
 * Return 167
 * 
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> [] <br>
 * coins = 3*1*5 + 3*5*8 + 1*3*8 + 1*8*1 = 167
 * 
 * @author zhoudong
 *
 */
public class BurstBalloons {

	public class Solution {
		public int maxCoins(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;

			int[][] dp = new int[nums.length][nums.length];
			for (int len = 1; len <= nums.length; len++) {
				for (int start = 0; start <= nums.length - len; start++) {
					int end = start + len - 1;
					for (int i = start; i <= end; i++) {
						int coins = nums[i] * getValue(nums, start - 1) * getValue(nums, end + 1);
						// If not first one, we can add subrange on its left.
						coins += i != start ? dp[start][i - 1] : 0;
						// If not last one, we can add subrange on its right
						coins += i != end ? dp[i + 1][end] : 0;
						dp[start][end] = Math.max(dp[start][end], coins);
					}
				}
			}
			return dp[0][nums.length - 1];
		}

		// Deal with num[-1] and num[num.length]
		private int getValue(int[] nums, int i) {
			if (i < 0 || i >= nums.length) {
				return 1;
			}
			return nums[i];
		}
	}
}
