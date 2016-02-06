package org.dzhou.interview.recursiondynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         Write a method to compute all permutations of a string of unique
 *         characters.
 */
public class Permutation {

	public List<String> getPerms(String str) {
		if (str == null)
			return null;
		ArrayList<String> permutations = new ArrayList<>();
		if (str.length() == 0) {
			permutations.add("");
			return permutations;
		}
		char first = str.charAt(0);
		String remainder = str.substring(1);
		List<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; j < word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}

	private String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}

	public List<String> getPerms2(String remainder) {
		int len = remainder.length();
		List<String> result = new ArrayList<>();
		if (len == 0) {
			result.add("");
			return result;
		}
		for (int i = 0; i < len; i++) {
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			List<String> partials = getPerms2(before + after);
			for (String s : partials) {
				result.add(remainder.charAt(i) + s);
			}
		}
		return result;
	}

	public List<String> getPerms3(String str) {
		List<String> result = new ArrayList<>();
		getPerms("", str, result);
		return result;
	}

	private void getPerms(String prefix, String remainder, List<String> result) {
		if (remainder.length() == 0)
			result.add(prefix);
		int len = remainder.length();
		for (int i = 0; i < len; i++) {
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			char c = remainder.charAt(i);
			getPerms(prefix + c, before + after, result);
		}
	}

}
