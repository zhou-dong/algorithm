package org.dzhou.interview.sort.test;

import java.util.Arrays;
import java.util.Random;

import org.dzhou.interview.sort.MergeSort;
import org.dzhou.interview.sort.QuickSort;
import org.dzhou.interview.sort.SearcBinary;
import org.junit.Assert;
import org.junit.Test;

public class TestSort {

	public void testSort() {
		int[] data = getRandomArray(10, 20);
		int[] sorted = getSorted(data);
		show(sorted);
		show(data);
		MergeSort.mergesort(data);
		show(data);
		Assert.assertArrayEquals(sorted, data);
	}

	@Test
	public void testQuicksort() {
		int[] data = getRandomArray(10, 20);
		int[] sorted = getSorted(data);
		// show(sorted);
		// show(data);
		QuickSort.sort(data);
		// show(data);
		Assert.assertArrayEquals(sorted, data);
	}

	@Test
	public void testBinarysearch() {
		int[] data = { 0, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9 };
		int index = SearcBinary.binarysearch(data, 9);
		Assert.assertEquals(10, index);
	}

	@Test
	public void testBinarysearchRecursive() {
		int[] data = { 0, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int index = SearcBinary.binarysearchRecurisve(data, 6);
		Assert.assertEquals(7, index);
	}

	void show(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private int[] getSorted(int[] array) {
		int[] clone = array.clone();
		Arrays.sort(clone);
		return clone;
	}

	private int[] getRandomArray(int size, int bound) {
		Random random = new Random();
		int[] result = new int[size];
		for (int i = 0; i < size - 1; i++) {
			result[i] = random.nextInt(bound);
		}
		return result;
	}
}
