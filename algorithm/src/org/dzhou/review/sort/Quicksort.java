package org.dzhou.review.sort;

/**
 * @author DONG ZHOU
 */
public class Quicksort<T extends Comparable<T>> {

	private static <T extends Comparable<T>> void sort(T[] array, int lowIndex, int highIndex) {
	}

	public static <T extends Comparable<T>> void sort(T[] array) {
		if (array.length < 2)
			return;
		sort(array, 0, array.length - 1);
	}

}