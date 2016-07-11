package org.dzhou.research.other.analyze;

public class Other {

	void printUnorderedPairs(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				System.out.println(array[i] + "," + array[j]);
			}
		}
	}

}
