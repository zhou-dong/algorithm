package org.dzhou.practice.hard;

import java.util.HashMap;
import java.util.Map;

/**
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

	public class Solution {

		public String minWindow(String s, String t) {
			Map<Character, Integer> targetCharCount = charCount(t);
			Map<Character, Integer> windowCharCount = new HashMap<>();

			int found = 0;
			int begin = -1, end = s.length() - 1, minLength = s.length();

			for (char c : s.toCharArray()) {
				if (!targetCharCount.containsKey(c))
					continue;
				addChar(c, windowCharCount);
				if (windowCharCount.get(c) <= targetCharCount.get(c))
					found++;
				if (found == t.length()) {

				}
			}

			return begin == -1 ? "" : s.substring(begin, end);
		}

		private Map<Character, Integer> charCount(String t) {
			Map<Character, Integer> map = new HashMap<>();
			for (char c : t.toCharArray())
				addChar(c, map);
			return map;
		}

		private void addChar(char c, Map<Character, Integer> map) {
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}

	}

}
