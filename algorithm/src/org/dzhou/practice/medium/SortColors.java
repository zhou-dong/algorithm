package org.dzhou.practice.medium;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * @author zhoudong
 *
 */
public class SortColors {

	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0)
			return;

		int left = 0, right = nums.length - 1;
		while (left < nums.length && nums[left] == 0)
			left++;
		while (right >= 0 && nums[right] == 2)
			right--;

		int index = left;
		while (index <= right) {
			if (nums[index] == 0) {
				swap(nums, index, left);
				left++;
				index++;
			} else if (nums[index] == 2) {
				swap(nums, index, right);
				right--;
			} else
				index++;
		}
	}

	private void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}

}
