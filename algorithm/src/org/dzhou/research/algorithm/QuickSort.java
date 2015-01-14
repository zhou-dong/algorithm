package org.dzhou.research.algorithm;

public class QuickSort {

	private static int[] array = null;

	private static void sort(int[] input) {
		array = input;
		recursiveSort(0, 1, array.length - 1);
	}

	private static void recursiveSort(int pivotIndex, int frontIndex,
			int backIndex) {
		if (frontIndex == backIndex)
			return;
		if (frontIndex < 0 || backIndex < 0)
			return;
		if (backIndex == array.length || frontIndex == array.length)
			return;
		int pivotValue = array[pivotIndex];
		while (true) {
			if (backIndex < 0)
				return;
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
			if (frontIndex == pivotIndex)
				return;
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
		leftRecursiveSort(pivotIndex, frontIndex, backIndex);
		rightRecursiveSort(pivotIndex, frontIndex, backIndex);
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
		int nextPivotIndex = pivotIndex + 1;
		int nextFrontIndex = pivotIndex + 2;
		int nextBackIndex = backIndex;
		recursiveSort(nextPivotIndex, nextFrontIndex, nextBackIndex);
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
		print();
	}

	private static void print() {
		for (int i : array)
			System.out.println(i + " ");
	}
}