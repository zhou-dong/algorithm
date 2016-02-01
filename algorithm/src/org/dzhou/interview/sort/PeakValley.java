package org.dzhou.interview.sort;

import java.util.Arrays;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class PeakValley {

	public void sortValleyPeak(int[] array) {
		Arrays.sort(array);
		for (int i = 1; i < array.length; i += 2) {
			swap(array, i - 1, i);
		}
	}

	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public void sortValleyPeak2(int[] array) {
		for (int i = 1; i < array.length; i += 2) {
			int biggestIndex = maxIndex(array, i - 1, i, i + 1);
			if (i != biggestIndex) {
				swap(array, i, biggestIndex);
			}
		}
	}

	private int maxIndex(int[] array, int a, int b, int c) {
		int aValue = getArrayValue(array, a);
		int bValue = getArrayValue(array, b);
		int cValue = getArrayValue(array, c);
		int max = Math.max(aValue, Math.max(bValue, cValue));
		if (max == aValue)
			return a;
		else if (max == bValue)
			return b;
		else
			return c;
	}

	private int getArrayValue(int[] array, int index) {
		return (index >= 0 && index < array.length) ? array[index] : Integer.MIN_VALUE;
	}

}
