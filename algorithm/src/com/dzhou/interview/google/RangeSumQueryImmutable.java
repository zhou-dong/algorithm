package com.dzhou.interview.google;

/**
 * 303. Range Sum Query - Immutable
 * 
 * Difficulty: Easy
 * 
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * Example: Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1
 * 
 * sumRange(2, 5) -> -1
 * 
 * sumRange(0, 5) -> -3
 * 
 * Note:
 * 
 * You may assume that the array does not change.
 * 
 * There are many calls to sumRange function.
 * 
 * @author zhoudong
 *
 */
public class RangeSumQueryImmutable {

	public class NumArray {

		int[] dp = null;

		public NumArray(int[] nums) {
			if (nums == null || nums.length == 0)
				return;
			dp = new int[nums.length];
			dp[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				dp[i] = dp[i - 1] + nums[i];
			}
		}

		public int sumRange(int i, int j) {
			if (i < 0 || i > j || j > dp.length - 1)
				return -1;
			int lower = (i == 0) ? 0 : dp[i - 1];
			int upper = dp[j];
			return upper - lower;
		}

	}

	// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.sumRange(1, 2);
}
