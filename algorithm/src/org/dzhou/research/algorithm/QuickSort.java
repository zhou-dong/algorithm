package org.dzhou.research.algorithm;

public class QuickSort {

	private static int[] array = null;

	private static void sort(int[] input) {
		int pivot = array[0];
		int pivotIndex = 0;
		int frontIndex = 1;
		int backIndex = array.length - 1;

		if (backIndex == frontIndex) {

		}

	}

	private static void recursiveSort(int pivotIndex, int frontIndex,
			int backIndex) {
		if (frontIndex == backIndex)
			return;
		int pivotValue = array[pivotIndex];
		while (true) {
			int backValue = array[backIndex];
			int frontValue = array[frontIndex];
			if (backIndex == frontIndex) {
				if (frontValue < pivotValue)
					swap(pivotIndex, frontIndex);
				break;
			}
			if (backValue >= pivotValue)
				backIndex--;
			else
				break;
		}
		while (true) {
			int frontValue = array[frontIndex];
			int backValue = array[backIndex];
			if (frontIndex == backIndex) {
				if (backValue < pivotValue)
					swap(pivotIndex, backIndex);
				break;
			}
			if (frontValue <= pivotValue)
				frontIndex++;
			else
				break;
		}
		if (backIndex != frontIndex)
			swap(backIndex, frontIndex);
	}

	private static void leftRecursiveSort(int pivotIndex, int frontIndex,
			int backIndex) {
		int nextPivotIndex = frontIndex;
		int nextFrontIndex = frontIndex + 1;
		int nextBackIndex = pivotIndex - 1;
		recursiveSort(nextPivotIndex, nextFrontIndex, nextBackIndex);
	}

	private static void rightRecursiveSort(int pivotIndex, int frontIndex,
			int backIndex) {
		int nextRightFrontIndex = pivotIndex + 1;
		int nextRightBackIndex = backIndex;

	}

	private static void swap(int i, int j) {
		if (i == j)
			return;
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String args[]) {
		int[] input = { 6, 8, 5, 3, 7, 9, 1, 4, 2 };
		sort(input);
		print(input);
	}

	private static void print(int[] input) {
		for (int i : input)
			System.out.println(i);
	}
}