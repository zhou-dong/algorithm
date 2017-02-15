package com.dzhou.interview.third;

/**
 * 504. Base 7
 * 
 * Given an integer, return its base 7 string representation.
 * 
 * Example 1: Input: 100 Output: "202"
 * 
 * Example 2: Input: -7 Output: "-10"
 * 
 * Note: The input will be in range of [-1e7, 1e7].
 * 
 * @author zhoudong
 *
 */
public class Base7 {

	public String convertTo7(int num) {
		if (num == 0)
			return "0";

		StringBuilder sb = new StringBuilder();
		boolean negative = false;

		if (num < 0) {
			negative = true;
		}

		while (num != 0) {
			sb.append(Math.abs(num % 7));
			num = num / 7;
		}

		if (negative) {
			sb.append("-");
		}

		return sb.reverse().toString();
	}

}
