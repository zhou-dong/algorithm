package org.dzhou.interview.moderate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         设计一种算法，找出数组中两数之和为指定值的所有整数对。
 * 
 */
public class FindPairSum {

	public void printPairSums(int[] array, int sum) {
		Set<Integer> set = new HashSet<>();
		for (int i : array)
			set.add(i);
		for (int i : array) {
			int complement = sum - i;
			if (set.contains(complement)) {
				System.out.println(i + " " + complement);
			}
		}
	}

	public void printPairSums2(int[] array, int sum) {
		Arrays.sort(array);
		int first = 0;
		int last = array.length - 1;
		while (first < last) {
			int s = array[first] + array[last];
			if (s == sum) {
				System.out.println(array[first] + " " + array[last]);
				first++;
				last--;
			} else {
				if (s < sum)
					first++;
				else
					last--;
			}
		}
	}

}
