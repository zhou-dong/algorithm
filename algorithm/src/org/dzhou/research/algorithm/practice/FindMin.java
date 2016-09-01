package org.dzhou.research.algorithm.practice;

/**
 * @author DONG ZHOU
 */
public class FindMin {

	public static class Solution {

		public int min(int[] array) {
			int min = array[0];
			for (int i = 1; i < array.length; i++)
				if (array[i] < min) {
					min = array[i];
				}
			return min;
		}

	}

	public static class Solution1 {

		public int min(int[] array) {
			int min = array[0];
			for (int i = 1; i < array.length; i++)
				min = min(min, array[i]);
			return min;
		}

		private int min(int x, int y) {
			return x < y ? x : y;
		}

	}

	public static class Solution2 {

		public int min(int[] array) {
			int min = array[0];
			for (int i = 1; i < array.length; i++)
				min = Math.min(min, array[i]);
			return min;
		}

	}

}