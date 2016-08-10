package org.dzhou.practice.medium.premium;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it such that:
 * 
 * nums[0] < nums[1] > nums[2] < nums[3]....
 * 
 * Example: <br>
 * Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * 
 * Note: You may assume all input has valid answer.
 * 
 * Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?
 * 
 * @author zhoudong
 *
 */
public class WiggleSortII {

	public class Solution {

		public void wiggleSort(int[] nums) {
			Arrays.sort(nums);
			int n = nums.length, mid = (n - 1) / 2, index = 0;
			int[] temp = new int[n];
			for (int i = 0; i <= mid; i++) {
				temp[index] = nums[mid - i];
				if (index + 1 < n) {
					temp[index + 1] = nums[n - 1 - i];
				}
				index += 2;
			}
			System.arraycopy(temp, 0, nums, 0, n);
		}

	}

}
