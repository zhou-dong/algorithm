package org.dzhou.research.algorithm;

public class ShellSort {

	private static int[] array = null;

	public static int[] sort(int[] input) {
		array = input;
		recursiveSort(array.length);
		return array;
	}

	private static void recursiveSort(int size) {
		int half = size / 2;
		if (half == 0)
			return;
		for (int i = half; i < array.length; i++)
			recursiveSwap(i, half);
		recursiveSort(half);
	}

	private static void recursiveSwap(int i, int range) {
		int frontIndex = getFrontIndex(i, range);
		if (frontIndex < 0)
			return;
		if (array[i] >= array[frontIndex])
			return;
		swap(i, frontIndex);
		recursiveSwap(frontIndex, range);
	}

	private static int getFrontIndex(int backIndex, int range) {
		return backIndex - range;
	}

	private static void swap(int i, int j) {
		if (i == j)
			return;
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String args[]) {
		int[] input = { 6, 5, 3, 1, 8, 7, 2, 4, 9, 15 };
		sort(input);
		print();
	}

	private static void print() {
		for (int i : array)
			System.out.print(i + " ");
	}

}