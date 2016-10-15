package org.dzhou.again.dp;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * 
 * Difficulty: Medium
 * 
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18],
 * 
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is
 * 4. Note that there may be more than one LIS combination, it is only necessary
 * for you to return the length.
 * 
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * @author zhoudong
 *
 */
public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		return (nums == null || nums.length == 0) ? 0 : dpHelper(nums);
	}

	private int dpHelper(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return max(dp);
	}

	private int max(int[] nums) {
		int max = 1;
		for (int num : nums)
			max = Math.max(max, num);
		return max;
	}

}
