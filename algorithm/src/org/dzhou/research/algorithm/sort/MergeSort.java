package org.dzhou.research.algorithm.sort;

public class MergeSort {

	public static int[] recursiveSort(int[] input) {
		int[] sortedLeft = null;
		int[] left = createLeft(input);
		if (left.length == 1)
			sortedLeft = left;
		else
			sortedLeft = recursiveSort(left);
		int[] sortedRight = null;
		int[] right = createRight(input);
		if (right.length == 1)
			sortedRight = right;
		else
			sortedRight = recursiveSort(right);
		return merge(sortedLeft, sortedRight);
	}

	private static int[] createLeft(int[] input) {
		int leftLength = leftLength(input.length);
		int[] result = new int[leftLength];
		for (int i = 0; i < leftLength; i++)
			result[i] = input[i];
		return result;
	}

	private static int leftLength(int totalLength) {
		return totalLength / 2;
	}

	private static int rightLength(int totalLength) {
		return totalLength - leftLength(totalLength);
	}

	private static int[] createRight(int[] input) {
		int leftLength = leftLength(input.length);
		int rightLength = rightLength(input.length);
		int[] result = new int[rightLength];
		for (int i = 0; i < rightLength; i++)
			result[i] = input[leftLength + i];
		return result;
	}

	private static int[] merge(int[] left, int[] right) {
		int leftIndex = 0;
		int rightIndex = 0;
		int[] result = new int[left.length + right.length];
		for (int i = 0; i < result.length; i++) {
			if (leftIndex > left.length - 1) {
				result[i] = right[rightIndex];
				rightIndex++;
				continue;
			}
			if (rightIndex > right.length - 1) {
				result[i] = left[leftIndex];
				leftIndex++;
				continue;
			}
			if (left[leftIndex] <= right[rightIndex]) {
				result[i] = left[leftIndex];
				leftIndex++;
			} else {
				result[i] = right[rightIndex];
				rightIndex++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] array = { 6, 5, 8, 3, 7, 9, 1, 4, 2 };
		int[] result = recursiveSort(array);
		print(result);
	}

	private static void print(int[] input) {
		for (int i : input)
			System.out.print(i + " ");
	}

}