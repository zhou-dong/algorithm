package org.dzhou.interview.sort;

import java.util.List;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class BinarySearch {

	public int search(List<Integer> list, int value) {
		int index = 1;
		while (list.get(index) != -1 && list.get(index) < value) {
			index *= 2;
		}
		return binarySearch(list, value, index / 2, index);
	}

	int binarySearch(List<Integer> list, int value, int low, int high) {
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			int middle = list.get(mid);
			if (middle > value || middle == -1) {
				high = mid - 1;
			} else if (middle < value) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
