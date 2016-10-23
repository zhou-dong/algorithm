package com.dzhou.interview.google;

/**
 * Write a function that takes in a string and returns the length of the longest
 * string prefix in which all characters are arranged in alphabetical order. Use
 * the language with which you are the most familiar.
 * 
 * @author zhoudong
 *
 */
public class CountcharactersArrangedInAlphabeticalOrder {

	public int solution(String str) {
		if (str == null || str.length() == 0)
			return 0;
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) - str.charAt(i - 1) < 0)
				return count;
			count++;
		}
		return count;
	}

}
