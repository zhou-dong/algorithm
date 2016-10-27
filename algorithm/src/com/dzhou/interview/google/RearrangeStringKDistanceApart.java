package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 358. Rearrange String k Distance Apart
 * 
 * Given a non-empty string str and an integer k, rearrange the string such that
 * the same characters are at least distance k from each other.
 * 
 * All input strings are given in lowercase letters. If it is not possible to
 * rearrange the string, return an empty string "".
 * 
 * Example 1: <br>
 * str = "aabbcc", k = 3 <br>
 * Result: "abcabc" <br>
 * The same letters are at least distance 3 from each other.*
 * 
 * Example 2: <br>
 * str = "aaabc", k = 3 <br>
 * Answer: ""<br>
 * It is not possible to rearrange the string.
 * 
 * Example 3: <br>
 * str = "aaadbbcc", k = 2<br>
 * Answer: "abacabcd"<br>
 * Another possible answer is: "abcabcda"
 * 
 * The same letters are at least distance 2 from each other.
 * 
 * @author zhoudong
 *
 */
public class RearrangeStringKDistanceApart {

	public String rearrangeString(String str, int k) {
		if (k == 0)
			return str;
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}

	private Map<Character, Integer> countMap(String str) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : str.toCharArray()) {
			int value = map.containsKey(ch) ? map.get(ch) + 1 : 1;
			map.put(ch, value);
		}
		return map;
	}

}
