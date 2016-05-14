package org.dzhou.practice.easy;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author zhoudong
 *
 */
public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0 || s.trim().length() == 0)
			return true;
		s = s.toUpperCase();
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (!isAlphaNumeric(s.charAt(left))) {
				left++;
				continue;
			}
			if (!isAlphaNumeric(s.charAt(right))) {
				right--;
				continue;
			}
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	private boolean isAlphaNumeric(char c) {
		return isAlphabet(c) || isNumeric(c);
	}

	private boolean isAlphabet(char c) {
		int val = c - 'A';
		if (val < 0 || val > 25)
			return false;
		else
			return true;
	}

	private boolean isNumeric(char c) {
		int val = c - '0';
		if (val < 0 || val > 9)
			return false;
		else
			return true;
	}

}
