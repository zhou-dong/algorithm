package org.dzhou.interview.moderate;

/**
 * 
 * @author DONG ZHOU
 *
 *         有一个整数数组，请编写一个函数，找出索引m和n，只要将m和n之间的元素排好序，整个数组就是有序的。
 *         注意：n-m应该越小越好，也就是说，找出符合条件的最短序列。
 *         给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的起点和终点。
 *         (原序列位置从0开始标号,若原序列有序，返回[0,0])。 保证A中元素均为正整数。
 * 
 *         测试样例： [1,4,6,5,9,10],6 返回：[2,3]
 */
public class FindUnsortedSequence {

	public class Result {
		public int left;
		public int right;

		public Result(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	int findEndOfLeftSubsequence(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				return i - 1;
			}
		}
		return array.length - 1;
	}

	int findStartOfRightSubsequence(int[] array) {
		for (int i = array.length - 2; i >= 0; i--) {
			if (array[i] > array[i + 1]) {
				return i + 1;
			}
		}
		return 0;
	}

	int shrinkLeft(int[] array, int min_index, int start) {
		int comp = array[min_index];
		for (int i = start - 1; i >= 0; i--) {
			if (array[i] <= comp) {
				return i + 1;
			}
		}
		return 0;
	}

	int shrinkRight(int[] array, int max_index, int start) {
		int comp = array[max_index];
		for (int i = start; i < array.length; i++) {
			if (array[i] >= comp) {
				return i - 1;
			}
		}
		return array.length - 1;
	}

	public Result findUnsortedSequence(int[] array) {
		// 找出左子序列
		int end_left = findEndOfLeftSubsequence(array);
		// 找出右子序列
		int start_right = findStartOfRightSubsequence(array);
		// 找出中间部分的最小值和最大值
		int min_index = end_left + 1;
		if (min_index >= array.length) {
			return new Result(0, 0);// 已排序
		}
		int max_index = start_right - 1;
		for (int i = end_left; i < start_right; i++) {
			if (array[i] < array[min_index]) {
				min_index = i;
			}
			if (array[i] > array[max_index]) {
				max_index = i;
			}
		}
		// 向左移动，直到小于array[min_index]
		int left_index = shrinkLeft(array, min_index, end_left);
		// 向右移动，直到大于array[max_index]
		int right_index = shrinkRight(array, max_index, start_right);
		return new Result(left_index, right_index);
	}

}
