package org.dzhou.practice.hard;

import java.util.Arrays;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * Note:
 * 
 * You can assume that you can always reach the last index.
 * 
 * @author zhoudong
 *
 */
public class JumpGameII {

	public class Solution {

		// Given array A = [2,3,1,1,4]
		public int jump(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			int lastReach = 0;
			int reach = 0;
			int step = 0;
			for (int i = 0; i <= reach && i < nums.length; i++) {
				if (i > lastReach) {
					step++;
					lastReach = reach;
				}
				reach = Math.max(reach, nums[i] + i);
			}
			if (reach < nums.length - 1)
				return 0;
			return step;
		}

	}

	// Time Limit Exceeded
	public class Solution1 {

		public int jump(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			int[] dp = createDpArray(nums.length + 1);
			return jump(nums, dp);
		}

		public int jump(int[] nums, int[] dp) {
			for (int i = 1; i < dp.length; i++) {
				int step = nums[i - 1];
				int j = (i + step) < dp.length ? (i + step) : dp.length - 1;
				while (j > 0) {
					dp[j] = Math.min(dp[j], dp[i] + 1);
					if (j == dp.length - 1) {
						return dp[dp.length - 1];
					}
					j--;
				}
			}
			return dp[nums.length];
		}

		private int[] createDpArray(int length) {
			int[] dp = new int[length];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;
			dp[1] = 0;
			return dp;
		}

	}

}
