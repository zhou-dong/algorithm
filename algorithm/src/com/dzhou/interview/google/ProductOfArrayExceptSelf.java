package com.dzhou.interview.google;

/**
 * 238. Product of Array Except Self
 * 
 * Difficulty: Medium
 * 
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up: Could you solve it with constant space complexity? (Note: The
 * output array does not count as extra space for the purpose of space
 * complexity analysis.)
 * 
 * @author zhoudong
 *
 */
public class ProductOfArrayExceptSelf {

	// 我们以一个4个元素的数组为例，nums=[a1, a2, a3, a4]。
	// 想在O(n)时间复杂度完成最终的数组输出，res=[a2*a3*a4, a1*a3*a4, a1*a2*a4, a1*a2*a3]。
	// 比较好的解决方法是构造两个数组相乘：
	// [1, a1, a1*a2, a1*a2*a3]
	// [a2*a3*a4, a3*a4, a4, 1]
	public int[] productExceptSelf(int[] nums) {
		int[] prev = new int[nums.length];
		int[] post = new int[nums.length];

		prev[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			prev[i] = prev[i - 1] * nums[i - 1];
		}

		post[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			post[i] = post[i + 1] * nums[i + 1];
		}

		int[] result = new int[nums.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = prev[i] * post[i];
		}
		return result;
	}

}
