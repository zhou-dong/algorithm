package org.dzhou.practice.hard.premium;

import java.util.HashMap;
import java.util.Map;

/**
 * 340. Longest Substring with At Most K Distinct Characters
 * 
 * Given a string, find the length of the longest substring T that contains at
 * most k distinct characters.
 * 
 * For example, Given s = “eceba” and k = 2,
 * 
 * T is "ece" which its length is 3.
 * 
 * @author zhoudong
 *
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

	public class Solution {

		public int lengthOfLongestSubstringKDistinct(String s, int k) {
			if (s == null || s.length() == 0 || k == 0)
				return 0;
			int max = 0, start = 0;
			Map<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				if (map.size() == k && !map.containsKey(s.charAt(i))) {
					while (start < i && map.size() == k) {
						remove(map, s.charAt(start++));
					}
				}
				add(map, s.charAt(i));
				max = Math.max(max, i + 1 - start);
			}
			return max;
		}

		private void remove(Map<Character, Integer> map, char c) {
			if (!map.containsKey(c))
				return;
			int count = map.get(c);
			if (count == 1) {
				map.remove(c);
			} else {
				map.put(c, count - 1);
			}
		}

		private void add(Map<Character, Integer> map, char c) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

	}

}
