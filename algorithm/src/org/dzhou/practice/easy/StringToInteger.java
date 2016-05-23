package org.dzhou.practice.easy;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * @author zhoudong
 *
 */
public class StringToInteger {

	public int myAtoi(String str) {
		if (str == null || str.length() == 0)
			return 0;
		str = str.trim();
		boolean positive = true;
		int i = 0;
		if (str.charAt(0) == '+')
			i++;
		else if (str.charAt(0) == '-') {
			positive = false;
			i++;
		}
		double temp = 0;
		for (; i < str.length(); i++) {
			int digit = str.charAt(i) - '0';
			if (digit < 0 || digit > 9)
				break;
			if (positive) {
				temp = temp * 10 + digit;
				if (temp > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
			} else {
				temp = temp * 10 - digit;
				if (temp < Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
			}
		}
		return (int) temp;
	}

}
