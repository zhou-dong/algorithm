package org.dzhou.practice.medium;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2<br>
 * 3,2,1 → 1,2,3<br>
 * 1,1,5 → 1,5,1
 * 
 * @author zhoudong
 *
 *         参考：http://blog.csdn.net/m6830098/article/details/17291259
 *
 *         假设数组大小为 n<br>
 *         1.从后往前，找到第一个 A[i-1] < A[i]的。<br>
 *         2.从 A[n-1]到A[i]中找到一个比A[i-1]大的值,（也就是说在A[n-1]到A[i]的值中找到比A[i-1]大的集合中的最小的一个值）。<br>
 *         3.交换这两个值，并且把A[n-1]到A[i+1]排序，从小到大。
 */
public class NextPermutation {

	public class Solution {

		public void nextPermutation(int[] nums) {
			if (nums == null || nums.length == 0)
				return;
			int i = nums.length - 2;
			// 从后往前，找到第一个 A[i-1] < A[i]的。
			while (i >= 0 && nums[i] >= nums[i + 1])
				i--;
			// 从 A[n-1]到A[i]中找到一个比A[i-1]大的值。
			if (i >= 0) {
				int j = i + 1;
				while (j < nums.length && nums[j] > nums[i])
					j++;
				j--;
				// 交换这两个值
				swap(nums, i, j);
			}
			// 并且把A[n-1]到A[i+1]排序，从小到大。
			reverse(nums, i + 1, nums.length - 1);
		}

		private void swap(int[] nums, int x, int y) {
			int temp = nums[x];
			nums[x] = nums[y];
			nums[y] = temp;
		}

		private void reverse(int[] num, int i, int j) {
			while (i < j)
				swap(num, i++, j--);
		}
	}

}
