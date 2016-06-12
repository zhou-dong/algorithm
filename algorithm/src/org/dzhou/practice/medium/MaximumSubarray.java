package org.dzhou.practice.medium;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 * 
 * More practice: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 * 
 * @author zhoudong
 *
 */
public class MaximumSubarray {

	public class Solution {
		public int maxSubArray(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;

			int max = Integer.MIN_VALUE, sum = 0;
			for (int i = 0; i < nums.length; i++) {
				sum += nums[i];
				max = Math.max(max, sum);
				sum = Math.max(sum, 0);
			}

			return max;
		}
	}

}
