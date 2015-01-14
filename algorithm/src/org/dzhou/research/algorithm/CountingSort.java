package org.dzhou.research.algorithm;

/* 1. Use the method of bucket sort to insert number into bucket . 
 * 2. Every value in bucket add the previous value into itself, to indicate how many numbers above it.
 * 3. Translate the position of number from bucket then add the result.*/
public class CountingSort {

	private static int[] result;
	private static int[] bucket;
	private static int[] input;

	public static void main(String[] args) {
		sort(new int[] { 6, 2, 3, 1, 8, 7, 5, 4, 9, 2, 4 });
		print(result);
	}

	public static void sort(int[] array) {
		input = array;
		result = new int[input.length];
		bucket = new int[getBucketSize()];
		insertIntoBucket();
		addWithAboveInBucket();
		translationFromBucket();
	}

	// 3: translation from bucket
	private static int[] translationFromBucket() {
		for (int i = input.length - 1; i > -1; i--) {
			int bucketIndex = input[i];
			result[--bucket[bucketIndex]] = input[i];
		}
		return result;
	}

	// 2: add number from above in bucket to find "how many numbers above"
	private static void addWithAboveInBucket() {
		for (int i = 1; i < bucket.length; i++)
			bucket[i] += bucket[i - 1];
	}

	// 1: insert number into bucket. like bucket sort
	private static void insertIntoBucket() {
		for (int i : input)
			bucket[i]++;
	}

	private static int getBucketSize() {
		int result = 0;
		for (int i = 0; i < input.length; i++)
			if (input[i] > result)
				result = input[i];
		return result + 1;
	}

	private static void print(int[] array) {
		for (int i : array)
			System.out.print(i + " ");
	}

}