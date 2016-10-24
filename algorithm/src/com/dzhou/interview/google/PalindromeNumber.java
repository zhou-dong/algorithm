package com.dzhou.interview.google;

/**
 * 9. Palindrome Number
 * 
 * Difficulty: Easy
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author zhoudong
 *
 */
public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}

		// initialize how many zeros
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}

		while (x != 0) {
			int left = x / div;
			int right = x % 10;

			if (left != right) {
				return false;
			}

			x = (x % div) / 10;
			div /= 100;
		}

		return true;
	}

}
