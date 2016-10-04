package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 395. Longest Substring with At Least K Repeating Characters
 * 
 * Difficulty: Medium
 * 
 * Find the length of the longest substring T of a given string (consists of
 * lowercase letters only) such that every character in T appears no less than k
 * times.
 * 
 * Example 1:
 * 
 * Input: s = "aaabb", k = 3
 * 
 * Output: 3
 * 
 * The longest substring is "aaa", as 'a' is repeated 3 times. Example 2:
 * 
 * Input: s = "ababbc", k = 2
 * 
 * Output: 5
 * 
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is
 * repeated 3 times.
 * 
 * @author zhoudong
 *
 *         reference:
 *         http://www.guoting.org/leetcode/leetcode-395-longest-substring-with-
 *         at-least-k-repeating-characters/
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

	public int longestSubstring(String s, int k) {
		if (s == null || s.length() == 0 || s.length() < k)
			return 0;
		if (k <= 1)
			return s.length();

		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}

		List<Integer> pos = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			if (count[s.charAt(i) - 'a'] < k)
				pos.add(i);
		}
		if (pos.size() == 0) {
			return s.length();
		}

		pos.add(0, -1);
		pos.add(s.length());
		int max = 0;
		for (int i = 1; i < pos.size(); i++) {
			int start = pos.get(i - 1) + 1;
			int end = pos.get(i);
			max = Math.max(max, longestSubstring(s.substring(start, end), k));
		}
		return max;
	}

}
