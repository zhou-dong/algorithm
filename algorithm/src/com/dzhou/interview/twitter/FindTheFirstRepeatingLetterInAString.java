package com.dzhou.interview.twitter;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个String s，返回第一个duplicate，例如s=abcba, return = a;
 * 
 * @author zhoudong
 *
 */
public class FindTheFirstRepeatingLetterInAString {

	public int firstRepeatingLetter(String input) {
		if (input == null || input.length() == 0)
			return ' ';
		int result = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, i);
			}
			result = Math.min(i, map.get(c));
		}
		return result;
	}

}
