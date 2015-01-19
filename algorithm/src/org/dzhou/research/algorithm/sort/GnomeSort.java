package org.dzhou.research.algorithm.sort;

// Similar with insertion sort
public class GnomeSort {

	private static int[] array;

	public static int[] sort(int[] input) {
		array = input;
		for (int i = 1; i < array.length; i++)
			recursiveSort(i);
		return array;
	}

	private static void recursiveSort(int i) {
		if (i == 0)
			return;
		if (array[i] >= array[i - 1])
			return;
		swap(i, i - 1);
		recursiveSort(i - 1);
	}

	private static void swap(int i, int j) {
		if (i == j)
			return;
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		sort(new int[] { 6, 5, 3, 7, 8, 1, 2, 4, 4, 9, 1 });
		print();
	}

	private static void print() {
		for (int i : array)
			System.out.print(i + " ");
	}
}