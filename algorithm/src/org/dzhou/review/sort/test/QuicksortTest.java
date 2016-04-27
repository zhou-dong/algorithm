package org.dzhou.review.sort.test;

import java.util.Arrays;
import java.util.Random;

import org.dzhou.interview.sort.QuickSort;
import org.junit.Assert;
import org.junit.Test;

public class QuicksortTest {

	@Test
	public void test0() {

		int size = 10;
		int[] array0 = randomArray(size, 100);
		int[] array1 = Arrays.copyOf(array0, size);

		printArray(array0);
		printArray(array1);

		Arrays.sort(array0);
		QuickSort.sort(array1);

		printArray(array0);
		printArray(array1);

	}

	@Test
	public void test1() {
		int size = 10;
		int[] array0 = randomArray(size, 100);
		int[] array1 = Arrays.copyOf(array0, size);
		Arrays.sort(array0);
		QuickSort.sort(array1);
		Assert.assertArrayEquals(array0, array1);
	}

	private int[] randomArray(int size, int bound) {
		int[] array0 = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++)
			array0[i] = random.nextInt(bound);
		return array0;
	}

	protected void printArray(int[] array) {
		for (int i : array)
			System.out.print(i + " ");
		System.out.println();
	}

}
