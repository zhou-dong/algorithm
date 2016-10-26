package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * 
 * Difficulty: Hard
 * 
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * @author zhoudong
 *
 */
public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {

		int found = 0;

		Map<Character, Integer> target = countMap(t);
		Map<Character, Integer> window = new HashMap<>();
		int min = s.length();
		for (int slow = 0; slow < s.length(); slow++) {

		}
		return null;
	}

	private Map<Character, Integer> countMap(String t) {
		Map<Character, Integer> countMap = new HashMap<>();
		for (char ch : t.toCharArray())
			add(countMap, ch);
		return countMap;
	}

	private void subtract(Map<Character, Integer> map, char ch) {
		if (!map.containsKey(ch))
			return;
		map.put(ch, map.get(ch) - 1);
	}

	private void add(Map<Character, Integer> map, char ch) {
		int previous = map.containsKey(ch) ? map.get(ch) : 0;
		map.put(ch, previous + 1);
	}

}
