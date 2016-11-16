package com.dzhou.interview.google;

/**
 * 459. Repeated Substring Pattern
 * 
 * Difficulty: Easy
 * 
 * Given a non-empty string check if it can be constructed by taking a substring
 * of it and appending multiple copies of the substring together. You may assume
 * the given string consists of lowercase English letters only and its length
 * will not exceed 10000.
 * 
 * Example 1: Input: "abab"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "ab" twice.
 * 
 * Example 2: Input: "aba"
 * 
 * Output: False
 * 
 * Example 3: Input: "abcabcabcabc"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc"
 * twice.)
 * 
 * @author zhoudong
 *
 */
public class RepeatedSubstringPattern {

	public boolean repeatedSubstringPattern(String str) {
		for (int i = 1; i <= str.length() / 2; i++) {
			if (str.length() % i == 0 && isRepeatedSubstring(str, i, str.length() / i)) {
				return true;
			}
		}
		return false;
	}

	private boolean isRepeatedSubstring(String str, int subStringLength, int repeatedTime) {
		int start = 0;
		for (int i = 1; i < repeatedTime; i++) {
			String curr = str.substring(start, start + subStringLength);
			String next = str.substring(start + subStringLength, start + subStringLength + subStringLength);
			if (!curr.equals(next)) {
				return false;
			}
			start = start + subStringLength;
		}
		return true;
	}

}
