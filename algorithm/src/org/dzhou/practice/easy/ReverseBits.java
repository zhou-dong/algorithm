package org.dzhou.practice.easy;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 * 
 * Follow up:
 * 
 * If this function is called many times, how would you optimize it?
 * 
 * 
 * @author zhoudong
 *
 */
public class ReverseBits {

	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int reversed = 0;
		for (int i = 0; i < 32; i++) {
			reversed = (reversed << 1) | (n & 1);
			n >>= 1;
		}
		return reversed;
	}

}
