package org.dzhou.practice.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * 
 * Example 1:<br>
 * Given s = "hello", return "holle".
 * 
 * Example 2:<br>
 * Given s = "leetcode", return "leotcede".
 * 
 * @author zhoudong
 *
 */
public class ReverseVowelsOfAString {

	public String reverseVowels(String s) {
		char[] result = s.toCharArray();
		int i = 0, j = result.length - 1;
		while (i < j) {
			if (!isVowel(result[i])) {
				i++;
				continue;
			}
			if (!isVowel(result[j])) {
				j--;
				continue;
			}
			swap(result, i, j);
			i++;
			j--;
		}
		return new String(result);
	}

	Set<Character> vowels = new HashSet<>(
			Arrays.asList(new Character[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' }));

	private boolean isVowel(char c) {
		return vowels.contains(c);
	}

	private void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}

}
