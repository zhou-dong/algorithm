package com.dzhou.interview.third;

/**
 * 494. Target Sum
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target,
 * S. Now you have 2 symbols + and -. For each integer, you should choose one
 * from + and - as its new symbol.
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.
 * 
 * 
 * @author zhoudong
 *
 */
public class TargetSum {

	int result = 0;

	public int findTargetSumWays(int[] nums, int S) {
		if (nums == null || nums.length == 0)
			return result;

		int n = nums.length;
		int[] sums = new int[n];
		sums[n - 1] = nums[n - 1];
		for (int i = n - 2; i >= 0; i--)
			sums[i] = sums[i + 1] + nums[i];

		helper(nums, sums, S, 0);
		return result;
	}

	public void helper(int[] nums, int[] sums, int target, int pos) {
		if (pos == nums.length) {
			if (target == 0)
				result++;
			return;
		}

		if (sums[pos] < Math.abs(target))
			return;

		helper(nums, sums, target + nums[pos], pos + 1);
		helper(nums, sums, target - nums[pos], pos + 1);
	}
}
