package org.dzhou.practice.medium;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * @author zhoudong
 *
 *
 *         当有重复数字，会存在A[mid] = A[end]的情况。此时右半序列
 * 
 *         A[mid-1 : end]可能是sorted，也可能并没有sorted，如下例子。
 * 
 *         3 1 2 3 3 3 3
 * 
 *         3 3 3 3 1 2 3
 * 
 *         所以当A[mid] = A[end] != target时，无法排除一半的序列，而只能排除掉A[end]：
 * 
 *         A[mid] = A[end] != target时：搜寻A[start : end-1]
 * 
 *         正因为这个变化，在最坏情况下，算法的复杂度退化成了O(n)： 序列 2 2 2 2 2 2 2 中寻找target = 1。
 * 
 */
public class SearchInRotatedSortedArrayII {

	public class Solution {

		public boolean search(int[] nums, int target) {
			if (nums == null || nums.length == 0) {
				return false;
			}

			int start = 0, end = nums.length - 1;

			while (start <= end) {
				int mid = start + (end - start) / 2;
				if (nums[mid] == target) {
					return true;
				}
				if (nums[mid] < nums[end]) { // right half sorted
					if (target > nums[mid] && target <= nums[end])
						start = mid + 1;
					else
						end = mid - 1;
				} else if (nums[mid] > nums[end]) { // left half sorted
					if (target >= nums[start] && target < nums[mid])
						end = mid - 1;
					else
						start = mid + 1;
				} else {
					end--;
				}
			}

			return false;
		}

	}
}
