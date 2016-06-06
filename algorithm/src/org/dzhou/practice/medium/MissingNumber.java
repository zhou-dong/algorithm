package org.dzhou.practice.medium;

/**
 * Given an array containing n distinct numbers taken from [0, 1, 2, ..., n],
 * find the one that is missing from the array.
 * 
 * For example, Given nums = [0, 1, 3] return 2.
 * 
 * Note: Your algorithm should run in linear runtime complexity. Could you
 * implement it using only constant extra space complexity?
 * 
 * @author zhoudong
 *
 */
public class MissingNumber {

	// 用等差数列的求和公式求出0到n之间所有的数字之和，然后再遍历数组算出给定数字的累积和，然后做减法，差值就是丢失的那个数字
	public class Solution {

		public int missingNumber(int[] nums) {
			int sum = 0;
			for (int n : nums)
				sum += n;
			sum *= 2;
			return (nums.length * (nums.length + 1) - sum) / 2;
		}

	}

}
