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

	}

	int shrinkRight(int[] array, int max_index, int start) {

	}

}
