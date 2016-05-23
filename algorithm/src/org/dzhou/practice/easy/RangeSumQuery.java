package org.dzhou.practice.easy;

/**
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * Example:
 * 
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1<br>
 * sumRange(2, 5) -> -1<br>
 * sumRange(0, 5) -> -3<br>
 * 
 * Note: You may assume that the array does not change.<br>
 * There are many calls to sumRange function.
 * 
 * @author zhoudong
 *
 */
public class RangeSumQuery {

	public class NumArray {
		private int[] dp;

		public NumArray(int[] nums) {
			dp = new int[nums.length];
			int sum = 0;
			for (int i = 0; i < nums.length; i++) {
				sum += nums[i];
				dp[i] = sum;
			}
		}

		public int sumRange(int i, int j) {
			return i == 0 ? dp[j] : dp[j] - dp[i - 1];
		}
	}

	public class NumArray1 {
		private int[] nums;

		public NumArray1(int[] nums) {
			this.nums = nums;
		}

		public int sumRange(int i, int j) {
			int result = 0;
			for (; i <= j; i++)
				result += nums[i];
			return result;
		}
	}

}
