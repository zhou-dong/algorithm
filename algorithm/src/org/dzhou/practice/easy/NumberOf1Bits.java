package org.dzhou.practice.easy;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1'
 * bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ’11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 * 
 * @author zhoudong
 *
 */
public class NumberOf1Bits {

	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			count += (n & 1);
			n >>>= 1;
		}
		return count;
	}

}
