package org.dzhou.practice.hard.premium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at
 * most 2 distinct characters.
 * 
 * For example, Given s = “eceba”,
 * 
 * T is "ece" which its length is 3.
 * 
 * @author zhoudong
 *
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

	public class Solution {

		public int lengthOfLongestSubstringTwoDistinct(String s) {
			Map<Character, Integer> map = new HashMap<>();
			int max = 0, start = 0;
			for (int i = 0; i < s.length(); i++) {
				if (map.size() == 2 && !map.containsKey(s.charAt(i))) {
					while (start < i && map.size() == 2) {
						remove(map, s.charAt(start++));
					}
				}
				addToMap(map, s.charAt(i));
				max = Math.max(max, i - start + 1);
			}
			return max;
		}

		private int remove(Map<Character, Integer> map, char c) {
			if (map.containsKey(c)) {
				int count = map.get(c);
				if (count == 1)
					map.remove(c);
				else
					map.put(c, count - 1);
			}
			return map.size();
		}

		private int addToMap(Map<Character, Integer> map, char c) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
			return map.size();
		}

	}

}
