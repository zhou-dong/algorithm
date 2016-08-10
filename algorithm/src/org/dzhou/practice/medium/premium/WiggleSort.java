package org.dzhou.practice.medium.premium;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it in-place such that: <br>
 * nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * 
 * For example, <br>
 * given nums = [3, 5, 2, 1, 6, 4], <br>
 * one possible answer is [1, 6, 2, 5, 3, 4].
 * 
 * @author zhoudong
 *
 *         reference: https://segmentfault.com/a/1190000003783283
 */
public class WiggleSort {

	/**
	 * 题目对摇摆排序的定义有两部分：<br>
	 * 如果i是奇数，nums[i] >= nums[i - 1] <br>
	 * 如果i是偶数，nums[i] <= nums[i - 1] <br>
	 * 
	 * 所以我们只要遍历一遍数组，把不符合的情况交换一下就行了。<br>
	 * 具体来说，如果nums[i] > nums[i - 1]， 则交换以后肯定有nums[i] <= nums[i - 1]。
	 */
	public class Solution {

		public void wiggleSort(int[] nums) {
			for (int i = 1; i < nums.length; i++) {
				if (shouldSwap(nums, i)) {
					swap(nums, i, i - 1);
				}
			}
		}

		// 需要交换的情况：奇数时nums[i] < nums[i - 1]或偶数时nums[i] > nums[i - 1]
		private boolean shouldSwap(int[] nums, int i) {
			return oddAndSwap(nums, i) || evenAndSwap(nums, i);
		}

		private boolean oddAndSwap(int[] nums, int i) {
			if (i % 2 == 1 && nums[i] < nums[i - 1])
				return true;
			return false;
		}

		private boolean evenAndSwap(int[] nums, int i) {
			if (i % 2 == 0 && nums[i] > nums[i - 1])
				return true;
			return false;
		}

		private void swap(int[] nums, int x, int y) {
			int temp = nums[x];
			nums[x] = nums[y];
			nums[y] = temp;
		}
	}

	public class Solution1 {

		// 1 2 3 4 5 6 7 8 9 10
		// 1 3 2 5 4 7 6 9 8 10
		public void wiggleSort(int[] nums) {
			Arrays.sort(nums);
			for (int i = 2; i < nums.length; i++) {
				swap(nums, i, i - 1);
			}
		}

		private void swap(int[] nums, int x, int y) {
			int temp = nums[x];
			nums[x] = nums[y];
			nums[y] = temp;
		}
	}

}
