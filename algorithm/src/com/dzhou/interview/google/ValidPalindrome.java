package com.dzhou.interview.google;

/**
 * 125. Valid Palindrome
 * 
 * Difficulty: Easy
 * 
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example,
 * 
 * "A man, a plan, a canal: Panama" is a palindrome.
 * 
 * "race a car" is not a palindrome.
 * 
 * Note:
 * 
 * Have you consider that the string might be empty? This is a good question to
 * ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author zhoudong
 *
 */
public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (!isValid(s.charAt(i))) {
				i++;
			} else if (!isValid(s.charAt(j))) {
				j--;
			} else if (s.charAt(i) != s.charAt(j)) {
				return false;
			} else {
				i++;
				j--;
			}
		}
		return true;
	}

	private boolean isValid(char c) {
		return isDigit(c) || isAlphabet(c);
	}

	private boolean isDigit(char c) {
		int index = c - '0';
		return index >= 0 && index < 10;
	}

	private boolean isAlphabet(char c) {
		int index = c - 'a';
		return index >= 0 && index < 26;
	}
}
