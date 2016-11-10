package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 424. Longest Repeating Character Replacement
 * 
 * Difficulty: Medium
 * 
 * Given a string that consists of only uppercase English letters, you can
 * replace any letter in the string with another letter at most k times. Find
 * the length of a longest substring containing all repeating letters you can
 * get after performing the above operations.
 * 
 * Note: Both the string's length and k will not exceed 104.
 * 
 * Example 1:
 * 
 * Input: s = "ABAB", k = 2
 * 
 * Output: 4
 * 
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * 
 * Example 2:
 * 
 * Input: s = "AABABBA", k = 1
 * 
 * Output: 4
 * 
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * 
 * @author zhoudong
 *
 *         example: AABACBAAA
 */
public class LongestRepeatingCharacterReplacement {

	public int characterReplacement(String s, int k) {
		int max = 0, total = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int slow = 0, fast = 0; slow < s.length() && fast < s.length(); slow++) {
			while (fast <= s.length() && total - maxCharacterCount(map) <= k) {
				max = Math.max(max, total);
				if (fast == s.length()) {
					return max;
				}
				increase(map, s.charAt(fast));
				fast++;
				total++;
			}
			total--;
			decrease(map, s.charAt(slow));
		}
		return max;
	}

	private void decrease(Map<Character, Integer> map, char ch) {
		int value = map.get(ch);
		if (value == 1) {
			map.remove(ch);
		} else {
			map.put(ch, value - 1);
		}
	}

	private void increase(Map<Character, Integer> map, char ch) {
		if (!map.containsKey(ch)) {
			map.put(ch, 1);
		} else {
			map.put(ch, map.get(ch) + 1);
		}
	}

	private int maxCharacterCount(Map<Character, Integer> map) {
		int max = 0;
		for (int value : map.values())
			max = Math.max(max, value);
		return max;
	}

}
