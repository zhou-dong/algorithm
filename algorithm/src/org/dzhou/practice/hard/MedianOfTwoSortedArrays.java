package org.dzhou.practice.hard;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * Example 1: <br>
 * nums1 = [1, 3] <br>
 * nums2 = [2] <br>
 * The median is 2.0
 * 
 * Example 2: <br>
 * nums1 = [1, 2] <br>
 * nums2 = [3, 4] <br>
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 * @author zhoudong
 *
 *         reference:
 *
 *         http://fisherlei.blogspot.com/2012/12/leetcode-median-of-two-sorted-
 *         arrays.html
 *
 *         两个中位数nums1[m/2]和nums2[n/2],可以将数组划分为四个部分.而丢弃哪一个部分取决于两个条件：
 * 
 *         1, (m/2 + n/2) ? k；<br>
 *         2, nums1[m/2] ? nums2[n/2];
 */
public class MedianOfTwoSortedArrays {

	public class Solution {
		public double findMedianSortedArrays(int nums1[], int nums2[]) {
			int len = nums1.length + nums2.length;
			return (len % 2 == 0)
					? (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0
					: findKth(nums1, 0, nums2, 0, len / 2 + 1);
		}

		// find kth number of two sorted array
		public int findKth(int[] A, int A_start, int[] B, int B_start, int k) {
			if (A_start >= A.length) {
				return B[B_start + k - 1];
			}
			if (B_start >= B.length) {
				return A[A_start + k - 1];
			}

			if (k == 1) {
				return Math.min(A[A_start], B[B_start]);
			}

			int A_key = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
			int B_key = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;

			if (A_key < B_key) {
				return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
			} else {
				return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
			}
		}
	}

}
