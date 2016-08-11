package org.dzhou.practice.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. Ransom Note
 * 
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note: You may assume that both strings contain only lowercase letters.
 * 
 * canConstruct("a", "b") -> false <br>
 * canConstruct("aa", "ab") -> false <br>
 * canConstruct("aa", "aab") -> true
 * 
 * @author zhoudong
 *
 */
public class RansomNote {

	public class Solution {

		public boolean canConstruct(String ransomNote, String magazine) {
			Map<Character, Integer> map = magazines(magazine);
			for (char c : ransomNote.toCharArray()) {
				if (!map.containsKey(c)) {
					return false;
				}
				int value = map.get(c);
				if (--value < 0)
					return false;
				map.put(c, value);
			}
			return true;
		}

		private Map<Character, Integer> magazines(String magazine) {
			Map<Character, Integer> map = new HashMap<>();
			for (char c : magazine.toCharArray()) {
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			}
			return map;
		}
	}

}
