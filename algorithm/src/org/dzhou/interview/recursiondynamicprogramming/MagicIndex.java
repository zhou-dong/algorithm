package org.dzhou.interview.recursiondynamicprogramming;

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
 *         FOLLOW UP
 * 
 *         What if the values are not distinct?
 */
public class MagicIndex {

	public int magicSlow(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}

	public int magicFast(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}

	private int magicFast(int[] array, int start, int end) {
		if (end < start)
			return -1;
		int mid = (start + end) / 2;
		if (array[mid] == mid)
			return mid;
		else if (array[mid] > mid)
			return magicFast(array, start, mid - 1);
		else
			return magicFast(array, mid + 1, end);
	}

	public int magicFastWithUndistinctElements(int[] array) {
		return magicFastWithUndistinctElements(array, 0, array.length - 1);
	}

	private int magicFastWithUndistinctElements(int[] array, int start, int end) {
		if (end < start)
			return -1;

		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];
		if (midValue == midIndex)
			return midValue;

		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicFastWithUndistinctElements(array, start, leftIndex);
		if (left >= 0)
			return left;

		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFastWithUndistinctElements(array, rightIndex, end);
		return right;
	}

}
