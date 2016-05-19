package org.dzhou.practice.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * @author zhoudong
 *
 */
public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		Map<Character, Character> map1 = new HashMap<>();
		Map<Character, Character> map2 = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			if (map1.containsKey(c1) && (map1.get(c1) != c2))
				return false;
			if (map2.containsKey(c2) && (map2.get(c2) != c1))
				return false;
			map1.put(c1, c2);
			map2.put(c2, c1);
		}
		return true;
	}

}
