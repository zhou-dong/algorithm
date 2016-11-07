package com.dzhou.interview.google;

/**
 * 69. Sqrt(x)
 * 
 * Difficulty: Medium
 * 
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * @author zhoudong
 *
 */
public class Sqrt {

	public int mySqrt(int x) {
		// 对于一个非负数n，它的平方根不会大于（n/2+1）
		long low = 0, high = x / 2 + 1;
		while (low <= high) {
			long mid = (low + high) / 2;
			long square = mid * mid;
			if (square == x)
				return (int) mid;
			else if (square < x)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return (int) high;
	}

}
