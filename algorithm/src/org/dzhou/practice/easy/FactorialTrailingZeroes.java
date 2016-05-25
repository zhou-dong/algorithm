package org.dzhou.practice.easy;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * @author zhoudong
 *
 */
public class FactorialTrailingZeroes {

	public int trailingZeroes(int n) {
		int count = 0;
		while (n >= 5) {
			n /= 5;
			count += n;
		}
		return count;
	}

}
