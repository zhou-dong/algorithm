package org.dzhou.research.algorithm;

public class CountingSort {

	private static int[] array;

	public static void main(String[] args) {
		swap(1, 1);
	}

	private static void swap(int i, int j) {
		if (i == j)
			return;
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
