package org.dzhou.practice.medium;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author zhoudong
 *
 */
public class Sum3Closest {

	public class Solution {

		public int threeSumClosest(int[] nums, int target) {
			Arrays.sort(nums);
			int result = 0, min = Integer.MAX_VALUE;

			for (int i = 0; i < nums.length - 2; i++) {
				int low = i + 1;
				int high = nums.length - 1;
				while (low < high) {
					int sum = nums[i] + nums[low] + nums[high];
					if (target == sum)
						return sum;
					else if (target > sum)
						low++;
					else
						high--;
					if (Math.abs(target - sum) < min) {
						min = Math.abs(target - sum);
						result = sum;
					}
				}
			}

			return result;
		}

	}

}
