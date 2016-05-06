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

	public static boolean isPowerOfTwo2(int n) {
		return Integer.toString(n, 2).matches("^10*$");
	}

	public static boolean isPowerOfTwo3(int n) {
		return (Math.log(n) / Math.log(2)) % 1 == 0;
	}

	public static boolean isPowerOfTwo4(int n) {
		double epsilon = 0.00000001;
		return ((Math.log10(n) / Math.log10(2)) % 1 + epsilon) < 2 * epsilon;
	}

}
