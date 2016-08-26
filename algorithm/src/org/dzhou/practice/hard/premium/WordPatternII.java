package org.dzhou.practice.hard.premium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty substring in str.
 * 
 * Examples: <br>
 * 1. pattern = "abab", str = "redblueredblue" should return true. <br>
 * 2. pattern = "aaaa", str = "asdasdasdasd" should return true. <br>
 * 3.pattern = "aabb", str = "xyzabcxzyabc" should return false. <br>
 * 
 * Notes:<br>
 * You may assume both pattern and str contains only lowercase letters.
 * 
 * @author zhoudong
 *
 */
public class WordPatternII {

	public class Solution {

		Map<Character, String> map = null;
		Set<String> set = null;
		boolean res = false;

		public boolean wordPatternMatch(String pattern, String str) {
			map = new HashMap<Character, String>();
			set = new HashSet<String>();
			res = false;
			helper(pattern, str, 0, 0);
			return res;
		}

		public void helper(String pattern, String str, int i, int j) {
			if (i == pattern.length() && j == str.length()) {
				res = true;
				return;
			}
			if (i >= pattern.length() || j >= str.length()) {
				return;
			}
			char c = pattern.charAt(i);
			for (int cut = j + 1; cut <= str.length(); cut++) {
				String substr = str.substring(j, cut);
				if (!set.contains(substr) && !map.containsKey(c)) {
					map.put(c, substr);
					set.add(substr);
					helper(pattern, str, i + 1, cut);
					map.remove(c);
					set.remove(substr);
				} else if (map.containsKey(c) && map.get(c).equals(substr)) {
					helper(pattern, str, i + 1, cut);
				}
			}
		}
	}
}
