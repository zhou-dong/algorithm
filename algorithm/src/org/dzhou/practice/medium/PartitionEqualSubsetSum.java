package org.dzhou.practice.medium;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 * 
 * Difficulty: Medium
 * 
 * Given a non-empty array containing only positive integers, find if the array
 * can be partitioned into two subsets such that the sum of elements in both
 * subsets is equal.
 * 
 * Note: Both the array size and each of the array element will not exceed 100.
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

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 5 };
		// int[] nums = { 1, 5, 11, 5 };
		boolean b = new PartitionEqualSubsetSum().canPartition(nums);
		System.out.println(b);
	}

	public boolean canPartition(int[] nums) {
		Arrays.sort(nums);

		int[] leftToRight = new int[nums.length];
		int[] rightToLeft = new int[nums.length];

		leftToRight[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			leftToRight[i] = nums[i] + leftToRight[i - 1];
		}

		rightToLeft[nums.length - 1] = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			rightToLeft[i] = nums[i] + rightToLeft[i + 1];
		}

		for (int i = 0; i < nums.length - 1; i++) {
			// if (leftToRight[i] == rightToLeft[nums.length - 1 - i]) {
			int a = leftToRight[i];
			int b = rightToLeft[i + 1];
			if (a == b) {
				return true;
			}
		}

		return false;
	}

}
