package org.dzhou.practice.easy;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * 
 * Example2: x = -123, return -321
 * 
 * @author zhoudong
 *
 */
public class ReverseInteger {

	public int reverse(int x) {
		boolean isNegative = x < 0 ? true : false;
		if (isNegative)
			x *= -1;
		int result = 0;
		while (x > 0) {
			// handle the overflow case
			if (result > Integer.MAX_VALUE / 10
					|| ((result == Integer.MAX_VALUE / 10) && (x % 10 > Integer.MAX_VALUE % 10)))
				return 0;
			result *= 10;
			int mod = x % 10;
			result += mod;
			x /= 10;
		}
		if (isNegative)
			return result * -1;
		else
			return result;
	}

}
