package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 340. Longest Substring with At Most K Distinct Characters
 * 
 * Difficulty: Hard Given a string, find the length of the longest substring T
 * that contains at most k distinct characters.
 * 
 * For example, Given s = “eceba” and k = 2,
 * 
 * T is "ece" which its length is 3.
 * 
 * @author zhoudong
 *
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int max = 0, left = 0, count = 0;
		for (char c : s.toCharArray()) {
			addToMap(map, c);
			count++;
			while (map.size() > k) {
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

	private void addToMap(Map<Character, Integer> map, char c) {
		if (map.containsKey(c)) {
			map.put(c, map.get(c) + 1);
		} else {
			map.put(c, 1);
		}
	}

}
