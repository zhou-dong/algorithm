package org.dzhou.practice.hard;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author zhoudong
 *
 *         copy from: 写的太好了：
 *         http://bangbingsyb.blogspot.com/2014/11/leetcode-search-in-rotated-
 *         sorted-array.html
 *
 *         题目一看就知道是binary
 *         search。所以关键点在于每次要能判断出target位于左半还是右半序列。解这题得先在纸上写几个rotated sorted
 *         array的例子出来找下规律。Rotated sorted array根据旋转得多少有两种情况：
 * 
 *         原数组：0 1 2 4 5 6 7 情况1： 6 7 0 1 2 4 5 起始元素0在中间元素的左边 情况2： 2 4 5 6 7 0 1
 *         起始元素0在中间元素的右边
 * 
 *         两种情况都有半边是完全sorted的。根据这半边，当target != A[mid]时，可以分情况判断：
 * 
 *         当A[mid] < A[end] < A[start]：情况1，右半序列A[mid+1 : end] sorted A[mid] <
 *         target <= A[end], 右半序列，否则为左半序列。
 * 
 *         当A[mid] > A[start] > A[end]：情况2，左半序列A[start : mid-1] sorted A[start]
 *         <= target < A[mid], 左半序列，否则为右半序列
 * 
 *         Base case：当start + 1 = end时 假设 2 4: A[mid] = A[start] = 2 <
 *         A[end]，A[mid] < target <= A[end] 右半序列，否则左半序列
 * 
 *         假设 4 2: A[mid] = A[start ] = 4 > A[end], A[start] <= target < A[mid]
 *         左半序列，否则右半序列
 * 
 *         加入base case的情况，最终总结的规律是：
 * 
 *         A[mid] = target, 返回mid，否则
 * 
 *         (1) A[mid] < A[end]: A[mid+1 : end] sorted A[mid] < target <= A[end]
 *         右半，否则左半。
 * 
 *         (2) A[mid] > A[end] : A[start : mid-1] sorted A[start] <= target <
 *         A[mid] 左半，否则右半。
 */
public class SearchInRotatedSortedArray {

	public class Solution {

		public int search(int[] nums, int target) {

			if (nums == null || nums.length == 0) {
				return -1;
			}

			int start = 0, end = nums.length - 1, mid;

			while (start + 1 < end) {
				mid = start + (end - start) / 2;
				if (nums[mid] == target) {
					return mid;
				}
				if (nums[start] < nums[mid]) {
					if (nums[start] <= target && target <= nums[mid]) {
						end = mid;
					} else {
						start = mid;
					}
				} else {
					if (nums[mid] <= target && target <= nums[end]) {
						start = mid;
					} else {
						end = mid;
					}
				}
			}

			if (nums[start] == target) {
				return start;
			}
			if (nums[end] == target) {
				return end;
			}
			return -1;
		}

	}

}
