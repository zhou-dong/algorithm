package org.dzhou.interview.math;

/**
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author DONG ZHOU
 *
 */
public class PalindromeNumber {

	public boolean isPalindrome(int x) {

		if (x < 0) {
			return false;
		}

		// count how many zeros in x
		int dev = 1;
		while (x / dev >= 10) {
			dev *= 10;
		}

		while (x > 0) {

			int left = x / dev;
			int right = x % 10;

			if (left != right) {
				return false;
			}

			x %= dev; // remove left
			x /= 10; // remove right

			dev /= 100;
		}

		return true;
	}

}
