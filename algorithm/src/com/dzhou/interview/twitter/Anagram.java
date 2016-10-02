package com.dzhou.interview.twitter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Find the Anagram from a list of strings
 * 
 * input : {"tea", "ate", "eat", "apple", "java", "vaja", "cut", "utc"};
 * 
 * Output : {"tea", "ate", "eat","java", "vaja", "cut", "utc"}
 * 
 * @author zhoudong
 *
 */
public class Anagram {

	public Set<String> findAnagrams(String[] input) {
		Set<String> result = new HashSet<>();
		for (int i = 0; i < input.length; i++) {
			if (result.contains(input[i])) {
				continue;
			}
			for (int j = i + 1; j < input.length; j++) {
				if (isAnagram(input[i], input[j])) {
					result.add(input[i]);
					result.add(input[j]);
				}
			}
		}
		return result;
	}

	private boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : str1.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		for (char c : str2.toCharArray()) {
			if (!map.containsKey(c)) {
				return false;
			}
			int value = map.get(c);
			if (--value < 0)
				return false;
			map.put(c, value);
		}
		return true;
	}

}
