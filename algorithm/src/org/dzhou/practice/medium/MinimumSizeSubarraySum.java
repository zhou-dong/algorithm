package org.dzhou.practice.medium;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a subarray of which the sum ≥ s. If there isn't one, return
 * 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * 
 * the subarray [4,3] has the minimal length under the problem constraint.
 * 
 * ----------
 * 
 * reference:
 * 
 * http://bookshadow.com/weblog/2015/05/12/leetcode-minimum-size- subarray-sum/
 * 
 * ----------
 * 
 * @author zhoudong
 *
 *         O(n)解法：滑动窗口法，使用两个下标start和end标识窗口（子数组）的左右边界
 * 
 *         O(nlogn)解法：二分枚举答案，每次判断的时间复杂度为O(n)
 */
public class MinimumSizeSubarraySum {

	public class Solution {

		public int minSubArrayLen(int s, int[] nums) {

			if (nums == null || nums.length == 0)
				return 0;
			if (nums[0] >= s)
				return 1;

			int left = 0, sum = nums[0], min = Integer.MAX_VALUE;

			for (int right = 1; right < nums.length; right++) {
				if (nums[right] >= s)
					return 1;
				sum += nums[right];
				if (sum < s)
					continue;
				while (sum >= s) {
					sum -= nums[left];
					left++;
				}
				min = Math.min(min, right - left + 2);
			}

			return min == Integer.MAX_VALUE ? 0 : min;
		}

	}

}
