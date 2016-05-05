package org.dzhou.practice.easy;

public class PowerOfThree {

	public static boolean isPowerOfThree(int n) {
		if (n < 1)
			return false;
		while (n % 3 == 0)
			n /= 3;
		return n == 1;
	}

	public static boolean isPowerOfThree1(int n) {
		int result = 1;
		while (result <= n) {
			if (result == n)
				return true;
			result *= 3;
			if (result == 0) // limit check
				return false;
		}
		return false;
	}

	public static boolean isPowerOfThree2(int n) {
		return Integer.toString(n, 3).matches("^10*$");
	}

	public static boolean isPowerOfThree3(int n) {
		// return (Math.log10(n) / Math.log(3)) % 1 == 0;
		double epsilon = 0.00000001;
		return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
	}

	public static boolean isPowerOfThree4(int n) {
		return n > 0 && 1162261467 % n == 0;
	}

	public static boolean isPowerOfThree5(int n) {
		while (n >= 1) {
			if (n == 1)
				return true;
			if (n % 3 != 0)
				return false;
			n /= 3;
		}
		return false;
	}

}
