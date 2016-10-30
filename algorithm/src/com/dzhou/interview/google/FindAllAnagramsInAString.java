package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String
 * 
 * Difficulty: Easy
 * 
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input: s: "cbaebabacd" p: "abc"
 * 
 * Output: [0, 6]
 * 
 * Explanation:
 * 
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * 
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * 
 * Example 2:
 * 
 * Input: s: "abab" p: "ab"
 * 
 * Output: [0, 1, 2]
 * 
 * Explanation:
 * 
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * 
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * 
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * @author zhoudong
 *
 */
public class FindAllAnagramsInAString {

	public List<Integer> findAnagrams(String s, String p) {
		if (s.length() < p.length()) {
			return Collections.emptyList();
		}

		Map<Character, Integer> target = count(p, p.length());
		Map<Character, Integer> current = count(s, p.length());

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i + p.length() <= s.length(); i++) {
			if (isSame(target, current)) {
				result.add(i);
			}
			subtract(current, s.charAt(i));
			if (i + p.length() < s.length()) {
				add(current, s.charAt(i + p.length()));
			}
		}
		return result;
	}

	private Map<Character, Integer> count(String str, int size) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < size; i++)
			add(map, str.charAt(i));
		return map;
	}

	private void add(Map<Character, Integer> map, char key) {
		int value = map.containsKey(key) ? map.get(key) : 0;
		map.put(key, value + 1);
	}

	private void subtract(Map<Character, Integer> map, char key) {
		int value = map.get(key);
		if (value == 1) {
			map.remove(key);
		} else {
			map.put(key, value - 1);
		}
	}

	private boolean isSame(Map<Character, Integer> first, Map<Character, Integer> second) {
		if (first.size() != second.size()) {
			return false;
		}
		for (char key : first.keySet()) {
			if (!second.containsKey(key)) {
				return false;
			}
			if (first.get(key).intValue() != second.get(key).intValue()) {
				return false;
			}
		}
		return true;
	}
}
