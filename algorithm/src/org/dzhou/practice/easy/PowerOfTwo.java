package org.dzhou.practice.easy;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * @author DONG ZHOU
 *
 */
public class PowerOfTwo {

	public static boolean isPowerOfTwo(int n) {
		if (n < 1)
			return false;
		while (n % 2 == 0) {
			n /= 2;
		}
		return n == 1;
	}

	public static boolean isPowerOfTwo1(int n) {
		int result = 1;
		while (result <= n) {
			if (result == n)
				return true;
			result *= 2;
			if (result == 0) // limit check
				return false;
		}
		return false;
	}

}
