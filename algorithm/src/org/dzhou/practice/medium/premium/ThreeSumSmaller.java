package org.dzhou.practice.medium.premium;

import java.util.Arrays;

/**
 * 259. 3Sum Smaller
 * 
 * Given an array of n integers nums and a target, find the number of index
 * triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] +
 * nums[j] + nums[k] < target.
 * 
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * 
 * Return 2. Because there are two triplets which sums are less than 2:
 * 
 * [-2, 0, 1] <br>
 * [-2, 0, 3] <br>
 * 
 * Follow up: Could you solve it in O(n2) runtime?
 * 
 * @author zhoudong
 *
 */
public class ThreeSumSmaller {

	public class Solution {

		public int threeSumSmaller(int[] nums, int target) {
			Arrays.sort(nums);

			int count = 0;
			for (int i = 0; i < nums.length - 2; i++) {
				int left = i + 1, right = nums.length - 1;
				while (left < right) {
					int sum = nums[i] + nums[left] + nums[right];
					// 如果三个数的和大于等于目标数，那将尾指针向左移
					if (sum >= target) {
						right--;
						// 如果三个数的和小于目标数，那将头指针向右移
					} else {
						// right - left个组合都是小于目标数的
						count += right - left;
						left++;
					}
				}
			}
			return count;
		}

	}

}
