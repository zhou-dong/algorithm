package org.dzhou.practice.easy;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
 * should be [1, 3, 12, 0, 0].
 * 
 * @author DONG ZHOU
 *
 */
public class MoveZeroes {

	public static void moveZeroes(int[] nums) {
		for (int i = nums.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (nums[j] == 0) {
					swap(nums, j, j + 1);
				}
			}
		}
	}

	public static void moveZeroes1(int[] nums) {
		for (int i = 0, j = 1; j < nums.length && i < nums.length; i++) {
			if (nums[i] == 0) {
				if (j <= i) {
					j = i + 1;
				}
				while (j < nums.length) {
					if (nums[j] == 0)
						j++;
					else
						break;
				}
				if (j == nums.length) {
					break;
				}
				swap(nums, i, j);
			}
		}
	}

	private static void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}

}
