package org.dzhou.interview.recursiondynamicprogramming;

import java.util.ArrayList;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         Write a method to compute all permutations of a string of unique
 *         characters.
 */
public class Permutation {

	public ArrayList<String> getPerms(String str) {
		if (str == null)
			return null;
		ArrayList<String> permutations = new ArrayList<>();

		if (str.length() == 0) {
			permutations.add("");
			return permutations;
		}

		char first = str.charAt(0);
		String remainder = str.substring(1);
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {

		}

		return permutations;
	}

	String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}

}
