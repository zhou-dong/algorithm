package org.dzhou.practice.medium;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * @author zhoudong
 * 
 *         这道题运用位运算的异或。异或是相同为0，不同为1。
 * 
 *         这里运用到异或的性质：对于任何数x，都有x^x=0，x^0=x
 * 
 *         -------------------------------------------------
 * 
 *         同时异或还有性质：
 * 
 *         交换律 A XOR B = B XOR A
 * 
 *         结合律 A XOR B XOR C = A XOR (B XOR C) = (A XOR B) XOR C
 * 
 *         自反性 A XOR B XOR B = A XOR 0 = A
 */
public class SingleNumber {

	public int singleNumber(int[] nums) {
		for (int i = 1; i < nums.length; i++)
			nums[i] ^= nums[i - 1];
		return nums[nums.length - 1];
	}

}
