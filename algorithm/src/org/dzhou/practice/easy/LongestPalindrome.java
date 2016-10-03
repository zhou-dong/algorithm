package org.dzhou.practice.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. Longest Palindrome
 * 
 * Difficulty: Easy
 * 
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note: Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * 
 * Input: "abccccdd"
 * 
 * Output: 7
 * 
 * Explanation: One longest palindrome that can be built is "dccaccd", whose
 * length is 7.
 * 
 * @author zhoudong
 *
 */
public class LongestPalindrome {

	public int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		int countOdd = 0;
		for (int count : map.values()) {
			if (count % 2 == 1) {
				countOdd++;
			}
		}
		return (countOdd < 2) ? s.length() : s.length() - (countOdd - 1);
	}

}
