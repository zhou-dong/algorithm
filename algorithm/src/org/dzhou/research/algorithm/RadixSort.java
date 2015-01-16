package org.dzhou.research.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RadixSort {

	@SuppressWarnings("unchecked")
	private static List<Integer>[] buckets = new LinkedList[10];
	private static int[] array = null;

	public static void main(String[] args) {
		sort(new int[] { 312, 427, 632, 210, 127, 236, 982, 531 });

		System.out.println(getMaxNumber());

		System.out.println(getSortTime());

		System.out.println("312%10: " + (312 / 1) % 10);
		System.out.println("312%100: " + (312 / 10) % 10);
		System.out.println("312%100: " + (312 / 100) % 10);

	}

	public static int[] sort(int[] input) {
		array = input;
		int sortTime = getSortTime();
		int index = 1;
		for (int i = 0; i < sortTime; i++) {
			index *= 10;
			for (int j : array)
				buckets[j / index].add(j);

		}
		return array;
	}

	private static void insertIntoArrayFromBuckets() {

	}

	private static int getSortTime() {
		int maxNumber = getMaxNumber();
		int index = 1;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			index *= 10;
			if (maxNumber / index == 0)
				return i;
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

	private static void print(int[] input) {
		for (int i : input)
			System.out.println(i + " ");
	}
}