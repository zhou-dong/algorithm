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

		int start = 0, found = 0, begin = -1, end, minLength = Integer.MAX_VALUE;

		public String minWindow(String s, String t) {

			Map<Character, Integer> targetCharCount = charCount(t);
			Map<Character, Integer> windowCharCount = new HashMap<>();

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (!targetCharCount.containsKey(c))
					continue;
				addChar(c, windowCharCount);
				if (windowCharCount.get(c) <= targetCharCount.get(c))
					found++;
				if (found == t.length()) {
					shiftWindow(targetCharCount, windowCharCount, i, s);
					updateMinLength(i);
					removeFirst(s, windowCharCount);
				}
			}

			return begin == -1 ? "" : s.substring(begin, end + 1);
		}

		private void removeFirst(String s, Map<Character, Integer> windowCharCount) {
			subtractOne(s.charAt(start), windowCharCount);
			found--;
			start++; // 子串起始位置加1，我们开始看下一个子串了
		}

		private void updateMinLength(int index) {
			if (index - start < minLength) {
				begin = start;
				end = index;
				minLength = index - start;
			}
		}

		private void shiftWindow(Map<Character, Integer> targetCharCount, Map<Character, Integer> windowCharCount,
				int index, String s) {
			while (start < index) {
				char c = s.charAt(start);
				if (!targetCharCount.containsKey(c)) {
					start++;
				} else if (windowCharCount.get(c) > targetCharCount.get(c)) {
					subtractOne(c, windowCharCount);
					start++;
				} else {
					break;
				}
			}
		}

		private void subtractOne(char c, Map<Character, Integer> map) {
			if (map.containsKey(c))
				map.put(c, map.get(c) - 1);
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
