package com.dzhou.interview.third;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 500. Keyboard Row
 * 
 * Given a List of words, return the words that can be typed using letters of
 * alphabet on only one row's of American keyboard like the image below.
 * 
 * Example 1:
 * 
 * Input: ["Hello", "Alaska", "Dad", "Peace"] Output: ["Alaska", "Dad"]
 * 
 * Note:
 * 
 * You may use one character in the keyboard more than once.
 * 
 * You may assume the input string will only contain letters of alphabet.
 * 
 * @author zhoudong
 *
 */
public class KeyboardRow {

	public String[] findWords(String[] words) {

		String[] strs = { "QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM" };
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			for (char ch : strs[i].toCharArray()) {
				map.put(ch, i);
			}
		}

		List<String> result = new LinkedList<>();

		for (String word : words) {
			if (word == null || word.length() == 0) {
				continue;
			}
			char[] chars = word.toUpperCase().toCharArray();
			int index = map.getOrDefault(chars[0], -1);
			if (index == -1)
				continue;
			boolean flag = true;
			for (char ch : chars) {
				if (map.getOrDefault(ch, -1) != index) {
					flag = false;
					break;
				}
			}
			if (flag) {
				result.add(word);
			}
		}

		return result.toArray(new String[0]);
	}

}
