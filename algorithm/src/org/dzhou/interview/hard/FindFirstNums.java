package org.dzhou.interview.hard;

import java.util.Random;

/**
 * Practice of "cracking the code interview"
 * 
 * 设计一个算法，给定10亿个数字，找出最小的100万个数字。假定计算机内存足以容纳10亿个数字。
 * 
 * @author DONG ZHOU
 *
 */
public class FindFirstNums {

	// 解法1：排序。（按升序排列所有数，然后取出前100个数）。时间复杂度为O(n*log(n))。

	/*
	 * 解法2：小顶堆。可以使用“小顶堆”来解题。
	 * 
	 * 首先为前100万个数字创建一个大顶堆（最大元素位于顶端）。
	 * 
	 * 然后遍历整个数列，将每个元素插入大顶推，并删除最大的元素。
	 * 
	 * 遍历结束后，我们将得到一个堆，刚好包含100万个数字。
	 * 
	 * 这个算法的时间复杂度为O(n*log(m))，其中m为带查找数值的数量。
	 */

	/*
	 * 解法3：选择排序
	 * 
	 * 1. 在数组中随机挑选一个元素，将它当做pivot，比它小的放到左边，比它大的放在它右边。
	 * 
	 * 2. 如果左边刚好有i个元素，return
	 * 
	 * 3. 如果左边元素大于i，在左边重复该算法
	 * 
	 * 4. 如果左边元素小于i，在右边执行该算法
	 */

	public static int partition(int[] array, int left, int right, int pivot) {
		while (true) {
			while (left <= right && array[left] <= pivot) {
				left++;
			}
			while (left <= right && array[right] > pivot) {
				right--;
			}
			if (left > right) {
				return left - 1;
			}
			swap(array, left, right);
		}
	}

	public static int rank(int[] array, int left, int right, int rank) {
		int pivot = randomInRange(left, right);
		int leftEnd = partition(array, left, right, pivot);

		int leftSize = leftEnd - left + 1;
		if (leftSize == rank + 1) {
			return leftEnd;
		} else if (rank < leftSize) {
			return rank(array, left, leftEnd, rank);
		} else {
			return rank(array, leftEnd + 1, right, rank);
		}
	}

	static Random random = new Random();

	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static int randomInRange(int left, int right) {
		return random.nextInt(left) + random.nextInt(right - left);
	}

}
