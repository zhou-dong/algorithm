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

	public class Solution {

		public int lengthOfLongestSubstring(String s) {

			if (s == null || s.length() == 0)
				return 0;

			Set<Character> set = new HashSet<Character>();

			int left = 0, max = 0;
			for (int i = 0; i < s.length(); i++) {
				char curr = s.charAt(i);
				if (set.contains(curr)) {
					while (left < i && s.charAt(left) != curr) {
						set.remove(s.charAt(left));
						left++;
					}
					left++;
				} else {
					set.add(curr);
					max = Math.max(max, i - left + 1);
				}
			}

			return max;
		}

	}

}
