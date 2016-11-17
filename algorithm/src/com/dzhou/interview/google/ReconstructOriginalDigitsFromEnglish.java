package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 423. Reconstruct Original Digits from English
 * 
 * Difficulty: Medium
 * 
 * Given a non-empty string containing an out-of-order English representation of
 * digits 0-9, output the digits in ascending order.
 * 
 * Note:
 * 
 * Input contains only lowercase English letters.
 * 
 * Input is guaranteed to be valid and can be transformed to its original
 * digits. That means invalid inputs such as "abc" or "zerone" are not
 * permitted.
 * 
 * Input length is less than 50,000.
 * 
 * Example 1: Input: "owoztneoer"
 * 
 * Output: "012"
 * 
 * Example 2: Input: "fviefuro"
 * 
 * Output: "45"
 * 
 * @author zhoudong
 *
 */
public class ReconstructOriginalDigitsFromEnglish {

	String[] words = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	char[] distinctCharacters = { 'z', 'w', 'u', 'x', 'g', 'o', 'h', 'f', 's', 'i' };
	int[] nums = { 0, 2, 4, 6, 8, 1, 3, 5, 7, 9 };

	public String originalDigits(String s) {
		int[] counts = new int[10];
		Map<Character, Integer> map = characterCount(s);
		for (int i = 0; i < 10; i++)
			removeAndUpdateCount(map, nums[i], counts, countCharacter(map, i));
		return toResult(counts);
	}

	private int countCharacter(Map<Character, Integer> map, int index) {
		return map.containsKey(distinctCharacters[index]) ? map.get(distinctCharacters[index]) : 0;
	}

	private String toResult(int[] counts) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < counts.length; i++) {
			for (int c = 0; c < counts[i]; c++) {
				sb.append(i);
			}
		}
		return sb.toString();
	}

	private void removeAndUpdateCount(Map<Character, Integer> map, int num, int[] counts, int count) {
		counts[num] = count;
		remove(map, words[num], count);
	}

	private void remove(Map<Character, Integer> map, String num, int time) {
		for (int i = 0; i < time; i++)
			remove(map, num);
	}

	private void remove(Map<Character, Integer> map, String num) {
		for (char ch : num.toCharArray())
			decrease(map, ch);
	}

	private Map<Character, Integer> characterCount(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray())
			increase(map, ch);
		return map;
	}

	private void increase(Map<Character, Integer> map, char ch) {
		if (map.containsKey(ch)) {
			map.put(ch, map.get(ch) + 1);
		} else {
			map.put(ch, 1);
		}
	}

	private void decrease(Map<Character, Integer> map, char ch) {
		int value = map.get(ch);
		if (value == 1) {
			map.remove(ch);
		} else {
			map.put(ch, value - 1);
		}
	}

}
