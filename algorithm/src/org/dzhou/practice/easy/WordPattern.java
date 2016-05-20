package org.dzhou.practice.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Examples:<br>
 * pattern = "abba", str = "dog cat cat dog" should return true.<br>
 * pattern = "abba", str = "dog cat cat fish" should return false.<br>
 * pattern = "aaaa", str = "dog cat cat dog" should return false.<br>
 * pattern = "abba", str = "dog dog dog dog" should return false.<br>
 * 
 * Notes:<br>
 * You may assume pattern contains only lower case letters, and str contains
 * lower case letters separated by a single space.
 * 
 * 
 * @author zhoudong
 *
 */
public class WordPattern {

	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if (pattern.length() != words.length)
			return false;
		Map<Character, String> map1 = new HashMap<>();
		Map<String, Character> map2 = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			char c = pattern.charAt(i);
			String word = words[i];
			if (!map1.containsKey(c) && !map2.containsKey(word)) {
				map1.put(c, word);
				map2.put(word, c);
			} else {
				if (!map1.containsKey(c) || !map2.containsKey(word)) {
					return false;
				}
				if (!word.equals(map1.get(c)) || c != map2.get(word)) {
					return false;
				}
			}
		}
		return true;
	}

}
