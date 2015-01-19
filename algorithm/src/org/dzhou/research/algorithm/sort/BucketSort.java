package org.dzhou.research.algorithm.sort;

public class BucketSort {

	private static int[] array = null;
	private static int[] buckets = null;
	private static int[] sortedArray = null;

	public static void main(String[] args) {
		sort(new int[] { 6, 5, 8, 5, 3, 7, 9, 1, 4, 2, 1, 1, 9 });
		printSortedArray();
	}

	public static int[] sort(int[] input) {
		array = input;
		sortedArray = new int[array.length];
		buckets = new int[findbucketSize()];
		insertIntoBucket();
		buildSortedArray();
		return sortedArray;
	}

	private static int findbucketSize() {
		int result = 0;
		for (int i : array)
			if (result < i)
				result = i;
		return result + 1;
	}

	private static void insertIntoBucket() {
		for (int i : array)
			buckets[i]++;
	}

	private static void buildSortedArray() {
		int index = 0;
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] == 0)
				continue;
			for (int j = 0; j < buckets[i]; j++) {
				sortedArray[index] = i;
				index++;
			}
		}
	}

	private static void printSortedArray() {
		for (int i : sortedArray)
			System.out.print(i + " ");
	}
}