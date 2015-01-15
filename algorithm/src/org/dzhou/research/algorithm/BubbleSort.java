package org.dzhou.research.algorithm;

public class BubbleSort {

	private static int[] array = null;

	public static void sort(int[] input) {
		array = input;
		for (int i = array.length - 1; i > 0; i--)
			for (int j = 0; j < i; j++)
				if (array[j] > array[j + 1])
					swapNext(j);
	}

	private static void swapNext(int i) {
		swap(i, i + 1);
	}

	private static void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		sort(new int[] { 8, 7, 15, 9, 5, 4, 6, 3, 5, 1, 6, 2, 0 });
		print();
	}

	private static void print() {
		for (int i : array)
			System.out.print(i + " ");
	}

}