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

}
