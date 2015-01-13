package org.dzhou.research.algorithm;

public class BucketSort {

	private static int[] buckets = null;
	private static int[] sortedArray = null;

	public static void main(String[] args) {
		int[] input = { 6, 5, 8, 5, 3, 7, 9, 1, 4, 2, 1, 1, 9 };
		sortedArray = new int[input.length];
		buckets = new int[findbucketSize(input)];
		insertIntoBucket(input);
		buildSortedArray();
		printSortedArray();
	}

	private static int findbucketSize(int[] input) {
		int result = 0;
		for (int i : input)
			if (result < i)
				result = i;
		return result + 1;
	}

	private static void insertIntoBucket(int[] input) {
		for (int i : input)
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