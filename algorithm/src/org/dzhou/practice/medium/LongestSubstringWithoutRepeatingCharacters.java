package org.dzhou.practice.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * @author zhoudong
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {

		Set<Character> set = new HashSet<>();

		int max = 0, left = 0;
		for (char c : s.toCharArray()) {
			while (set.contains(c)) {
				set.remove(s.charAt(left++));
			}
			set.add(c);
			max = Math.max(max, set.size());
		}

		return max;
	}

}
