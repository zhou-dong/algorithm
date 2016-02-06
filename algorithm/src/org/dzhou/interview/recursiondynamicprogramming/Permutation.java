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

	String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}

}
