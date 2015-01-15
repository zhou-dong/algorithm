package org.dzhou.research.algorithm;

public class QuickSort {

	private static int[] array;

	public static void sort(int[] input) {
		array = input;
		quicksort(0, array.length - 1);
	}

	private static void quicksort(int front, int tail) {
		int i = front;
		int j = tail;
		int pivot = array[getPivot(front, tail)];
		while (i <= j) {
			while (array[i] < pivot)
				i++;
			while (array[j] > pivot)
				j--;
			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		if (front < j)
			quicksort(front, j);
		if (i < tail)
			quicksort(i, tail);
	}

	private static int getPivot(int front, int tail) {
		return (tail + front) / 2;
	}

	private static void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		sort(new int[] { 6, 2, 3, 1, 8, 7, 5, 4, 9, 2, 4 });
		print();
	}

	private static void print() {
		for (int i : array)
			System.out.print(i + " ");
	}
}