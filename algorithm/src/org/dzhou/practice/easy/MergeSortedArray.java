package org.dzhou.practice.easy;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note: You may assume that nums1 has enough space (size that is greater or
 * equal to m + n) to hold additional elements from nums2. The number of
 * elements initialized in nums1 and nums2 are m and n respectively.
 * 
 * @author zhoudong
 *
 */
public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int x = m - 1, y = n - 1, index = m + n - 1;
		while (x >= 0 && y >= 0) {
			if (nums1[x] > nums2[y])
				nums1[index--] = nums1[x--];
			else
				nums1[index--] = nums2[y--];
		}
		while (x >= 0)
			nums1[index--] = nums1[x--];
		while (y >= 0)
			nums1[index--] = nums2[y--];
	}

	public void merge1(int[] nums1, int m, int[] nums2, int n) {
		int x = m - 1, y = n - 1, index = m + n - 1;
		while (x >= 0 && y >= 0) {
			if (nums1[x] > nums2[y]) {
				nums1[index] = nums1[x];
				x--;
			} else {
				nums1[index] = nums2[y];
				y--;
			}
			index--;
		}
		while (x >= 0) {
			nums1[index] = nums1[x];
			index--;
			x--;

		}
		while (y >= 0) {
			nums1[index] = nums2[y];
			index--;
			y--;
		}
	}

}
