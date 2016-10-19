package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 * 
 * Difficulty: Hard
 * 
 * Given a string, find the length of the longest substring T that contains at
 * most 2 distinct characters.
 * 
 * For example, Given s = “eceba”,
 * 
 * T is "ece" which its length is 3.
 * 
 * Hide Company Tags
 * 
 * @author zhoudong
 *
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int max = 0, left = 0, count = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			addCharToMap(map, c);
			count++;
			while (map.size() > 2) {
				subtractFromMap(map, s.charAt(left++));
				count--;
			}
			max = Math.max(max, count);
		}
		return max;
	}

	private void subtractFromMap(Map<Character, Integer> map, char c) {
		int count = map.get(c);
		if (count == 1) {
			map.remove(c);
		} else {
			map.put(c, count - 1);
		}
	}

	private void addCharToMap(Map<Character, Integer> map, char c) {
		if (map.containsKey(c)) {
			map.put(c, map.get(c) + 1);
		} else {
			map.put(c, 1);
		}
	}

}
