package com.dzhou.interview.google;

/**
 * 416. Partition Equal Subset Sum Difficulty: Medium
 * 
 * Given a non-empty array containing only positive integers, find if the array
 * can be partitioned into two subsets such that the sum of elements in both
 * subsets is equal.
 * 
 * Note:
 * 
 * Each of the array element will not exceed 100.
 * 
 * The array size will not exceed 200.
 * 
 * Example 1:
 * 
 * Input: [1, 5, 11, 5]
 * 
 * Output: true
 * 
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * 
 * Example 2:
 * 
 * Input: [1, 2, 3, 5]
 * 
 * Output: false
 * 
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * 
 * @author zhoudong
 *
 */
public class PartitionEqualSubsetSum {

	public boolean canPartition(int[] nums) {
		int sum = sum(nums);
		// Time Limit Exceeded
		return (sum % 2 != 0) ? false : dfs(nums, sum / 2, 0, 0);
	}

	// Time Limit Exceeded
	boolean dfs(int[] nums, int sum, int start, int prev) {
		if (prev + nums[start] == sum) {
			return true;
		}
		for (int i = start; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (dfs(nums, sum, j, prev + nums[i])) {
					return true;
				}
			}
		}
		return false;
	}

	private int sum(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		return sum;
	}

}
