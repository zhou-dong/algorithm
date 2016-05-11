package org.dzhou.practice.easy;

import java.util.Arrays;

/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example,<br>
 * s = "anagram", t = "nagaram", return true. <br>
 * s = "rat", t = "car", return false.<br>
 * 
 * Note:<br>
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:<br>
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 * 
 * @author zhoudong
 *
 */
public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		char[] x = s.toCharArray();
		char[] y = t.toCharArray();
		Arrays.sort(x);
		Arrays.sort(y);
		return Arrays.equals(x, y);
	}

	public boolean isAnagram1(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] counter = new int[26];
		for (int i = 0; i < s.length(); i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}
		for (int count : counter) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isAnagram2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] table = new int[26];
		for (int i = 0; i < s.length(); i++) {
			table[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			table[t.charAt(i) - 'a']--;
			if (table[t.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}

}
