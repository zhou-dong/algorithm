package org.dzhou.practice.easy;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * @author zhoudong
 *
 */
public class PlusOne {

	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] = digits[i] + 1;
			if (digits[i] == 10) {
				digits[i] = 0;
			} else {
				return digits;
			}
		}
		// overflow的可能性只能是类似：9999+1=10000。这种，所以第一位为1，后面都为0
		int[] newDigits = new int[digits.length + 1];
		newDigits[0] = 1;
		return newDigits;
	}

}
