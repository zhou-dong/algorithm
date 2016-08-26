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
			Map<String, Integer> map = new HashMap<>();
			int max = 0, fast = 0;
			for (int i = 0; i < s.length(); i++) {
				if (map.size() == 2) {
					max = Math.max(max, fast - i);
				}
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
