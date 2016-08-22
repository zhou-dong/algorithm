package org.dzhou.practice.medium.premium;

/**
 * 325. Maximum Size Subarray Sum Equals k
 * 
 * Given an array nums and a target value k, find the maximum length of a
 * subarray that sums to k. If there isn't one, return 0 instead.
 * 
 * Example 1: <br>
 * Given nums = [1, -1, 5, -2, 3], k = 3, <br>
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * 
 * Example 2: <br>
 * Given nums = [-2, -1, 2, 1], k = 1, <br>
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest) <br>
 * 
 * Follow Up:<br>
 * Can you do it in O(n) time?
 * 
 * @author zhoudong
 *
 */
public class MaximumSizeSubarraySumEqualsK {

	// brute force
	public class Solution {

		public int maxSubArrayLen(int[] nums, int k) {
			int max = 0;
			for (int i = 0; i < nums.length; i++) {
				int sum = 0;
				for (int j = i; j < nums.length; j++) {
					sum += nums[j];
					if (sum == k) {
						max = Math.max(max, j + 1 - i);
					}
				}
			}
			return max;
		}

	}

}
