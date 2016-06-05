package org.dzhou.practice.medium;

/**
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

	/*
	 * 我们以一个4个元素的数组为例，nums=[a1, a2, a3, a4]。
	 * 
	 * 想在O(n)时间复杂度完成最终的数组输出，res=[a2*a3*a4, a1*a3*a4, a1*a2*a4, a1*a2*a3]。
	 * 
	 * 比较好的解决方法是构造两个数组相乘：
	 * 
	 * [1, a1, a1*a2, a1*a2*a3]
	 * 
	 * [a2*a3*a4, a3*a4, a4, 1]
	 * 
	 * 这样思路是不是清楚了很多，而且这两个数组我们是比较好构造的。
	 */
	public class Solution {

		public int[] productExceptSelf(int[] nums) {
			int[] pSeq = new int[nums.length];
			int[] nSeq = new int[nums.length];
			pSeq[0] = 1;
			for (int i = 1; i < nums.length; i++) {
				pSeq[i] = pSeq[i - 1] * nums[i - 1];
			}
			nSeq[nums.length - 1] = 1;
			for (int i = nums.length - 2; i >= 0; i--) {
				nSeq[i] = nSeq[i + 1] * nums[i + 1];
			}
			for (int i = 0; i < nums.length; i++) {
				pSeq[i] = pSeq[i] * nSeq[i];
			}
			return pSeq;
		}

	}

	public class Solution1 {

		public int[] productExceptSelf(int[] nums) {
			multiply(nums, 1, 0, nums.length);
			return nums;
		}

		private int multiply(int[] nums, int fwdProduct, int index, int length) {
			int revProduct = 1;
			if (index < length) {
				revProduct = multiply(nums, fwdProduct * nums[index], index + 1, length);
				int cur = nums[index];
				nums[index] = fwdProduct * revProduct;
				revProduct *= cur;
			}
			return revProduct;
		}

	}

}
