package org.dzhou.research.algorithm;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {

	@SuppressWarnings("unchecked")
	private static List<Integer>[] buckets = new ArrayList[10];
	private static int[] array = null;

	public static int[] sort(int[] input) {
		array = input;
		int sortTime = getSortTime();
		int index = 1;
		for (int i = 0; i < sortTime; i++) {
			initBuckets();
			for (int j : array)
				buckets[remainder(j, index)].add(j);
			fromBucketsToArray();
			index *= 10;
		}
		return array;
	}

	private static void initBuckets() {
		for (int i = 0; i < buckets.length; i++)
			buckets[i] = new ArrayList<Integer>();
	}

	private static int remainder(int number, int index) {
		return (number / index) % 10;
	}

	private static void fromBucketsToArray() {
		int index = 0;
		for (List<Integer> bucket : buckets) {
			if (bucket.size() == 0)
				continue;
			for (Integer i : bucket)
				array[index++] = i;
		}
	}

	private static int getSortTime() {
		int maxNumber = getMaxNumber();
		int index = 1;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			index *= 10;
			if (maxNumber / index == 0)
				return i + 1;
		}
		return 0;
	}

	private static int getMaxNumber() {
		int result = 0;
		for (int i : array)
			if (i > result)
				result = i;
		return result;
	}

	public static void main(String[] args) {
		int[] result = sort(new int[] { 312, 427, 632, 210, 127, 236, 982, 531,
				9, 21 });
		print(result);
	}

	private static void print(int[] input) {
		for (int i : input)
			System.out.print(i + " ");
	}

}