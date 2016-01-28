package org.dzhou.interview.bitmanipulation;

/**
 * Practice of "cracking the code interview"
 * 
 * Given a positive integer, print the next smallest and next largest number
 * that have the same number of 1 bits in their binary representation.
 * 
 * @author DONG ZHOU
 *
 */
public class MaxMinNumber {

	private int num1s(int n) {
		int count = 0;
		while (n > 0) {
			if ((n & 1) != 0) {
				count++;
			}
			n >>= 1;
		}
		return count;
	}

	public int previousNum(int n) {
		int num1s = num1s(n);
		int result = 0;
		for (int i = 0; i < num1s; i++) {
			result = (result << 1 | 1);
		}
		return result;
	}

	public int nextNum(int n) {
		int num1s = num1s(n);
		int mask = 1 << (Integer.BYTES * 8 - 2);
		int result = 0;
		for (int i = 0; i < num1s; i++) {
			result = (result >> 1) | mask;
		}
		return result;
	}

}
