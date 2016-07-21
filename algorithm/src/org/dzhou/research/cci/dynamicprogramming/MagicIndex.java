package org.dzhou.research.cci.dynamicprogramming;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *
 *         A magic index in an array A[1...n-1] is defined to be an index such
 *         that A[i] = i. Given a sorted array of distinct integers, write a
 *         method to find a magic index, if one exists, in array A.
 * 
 * 
 *         如果array中没有重复的数，<br>
 *         并且array中元素是升序排列<br>
 *         并且如果存在magic index的话<br>
 *         那么array中的第一个元素一定：小于等于（<=）0。
 * 
 *         FOLLOW UP:
 * 
 *         What if the values are not distinct?
 * 
 */
public class MagicIndex {

	public class Solution {
		public int magicFast(int[] array) {
			return magicFast(array, 0, array.length - 1);
		}

		private int magicFast(int[] array, int start, int end) {
			if (end < start)
				return -1;
			int mid = (start + end) / 2;
			if (array[mid] == mid) {
				return mid;
			} else if (array[mid] > mid) {
				return magicFast(array, start, mid - 1);
			} else {
				return magicFast(array, mid + 1, end);
			}
		}

	}

	public class Solution1 {
		public int magicFast(int[] array) {
			if (array.length <= 0)
				return -1;
			int start = 0, end = array.length - 1;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (array[mid] == mid)
					return mid;
				else if (array[mid] > mid) { // 因为是升序排列，说明array[mid]后面所有的元素，都要比index大。
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			return -1;
		}
	}

	public class Solution2 {
		public int magicSlow(int[] array) {
			for (int i = 0; i < array.length; i++) {
				if (i == array[i]) {
					return i;
				}
			}
			return -1;
		}
	}

	// magic fast with not distinct elements
	public class Solution3 {
		public int magicFast(int[] array) {
			return magicFast(array, 0, array.length - 1);
		}

		private int magicFast(int[] array, int start, int end) {
			if (end < start)
				return -1;

			int midIndex = (start + end) / 2;
			int midValue = array[midIndex];
			if (midValue == midIndex)
				return midValue;

			int leftIndex = Math.min(midIndex - 1, midValue);
			int left = magicFast(array, start, leftIndex);
			if (left >= 0)
				return left;

			int rightIndex = Math.max(midIndex + 1, midValue);
			int right = magicFast(array, rightIndex, end);
			return right;
		}

	}
}
