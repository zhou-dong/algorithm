package org.dzhou.practice.easy;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a
 * power of 4.
 * 
 * Example: Given num = 16, return true. Given num = 5, return false.
 * 
 * Follow up: Could you solve it without loops/recursion?
 * 
 * @author DONG ZHOU
 *
 */
public class PowerOfFour {

	public static boolean isPowerOfFour(int num) {
		if (num < 1) {
			return false;
		}
		while (num % 4 == 0) {
			num /= 4;
		}
		return num == 1;
	}

	/*
	 * String baseChange = Integer.toString(number, base); The code above
	 * converts number into base base and returns the result as a String. For
	 * example, Integer.toString(5, 2) == "101" and Integer.toString(5, 3) ==
	 * "12".
	 * 
	 * We will use the regular expression above for checking if the string
	 * starts with 1 ^1, is followed by zero or more 0s 0* and contains nothing
	 * else $.
	 */
	public static boolean isPowerOfFour1(int n) {
		return Integer.toString(n, 4).matches("^10*$");
	}

	public static boolean isPowerOfFour2(int num) {
		while (num >= 1) {
			if (num == 1)
				return true;
			if (num % 4 != 0)
				return false;
			num /= 4;
		}
		return false;
	}

	public static boolean isPowerOfFour3(int num) {
		int answer = 1;
		while (answer <= num) {
			if (answer == num)
				return true;
			answer *= 4;
			if (answer == 0) // limit control
				return false;
		}
		return false;
	}

	/*
	 * 判断log以4为底n的对数是否为整数
	 * 
	 * Java没有log4,所以判断log10(n)/log10(4)是否为整数
	 * 
	 * This solution is problematic because we start using doubles, which means
	 * we are subject to precision errors. This means, we should never use ==
	 * when comparing doubles. That is because the result of Math.log10(n) /
	 * Math.log10(3) could be 5.0000001 or 4.9999999. This effect can be
	 * observed by using the function Math.log() instead of Math.log10().
	 * 
	 * In order to fix that, we need to compare the result against an epsilon.
	 */
	public static boolean isPowerOfFour4(int num) {
		// return (Math.log10(num) / Math.log(4)) % 1 == 0;
		double epsilon = 0.00000001;
		return (Math.log(num) / Math.log(4) + epsilon) % 1 <= 2 * epsilon;
	}
}
