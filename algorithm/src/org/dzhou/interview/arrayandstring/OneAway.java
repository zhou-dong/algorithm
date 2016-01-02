package org.dzhou.interview.arrayandstring;

/**
 * There are three types of edits that can be performed on strings: insert a
 * character, remove a character, or replace a character. Given two strings,
 * write a function to check if they are one edit(or zero edits) away.
 * 
 * @author DONG ZHOU
 *
 *         1: Replacement
 *
 *         2: Insertion
 *
 *         3: Removal
 *
 */
public class OneAway {

	public static boolean isOneAway(String first, String second) {
		if (first.length() == second.length())
			return isOneEditReplace(first, second);
		else if (first.length() + 1 == second.length())
			return isOneEditInsert(first, second);
		else if (first.length() - 1 == second.length())
			return isOneEditInsert(second, first);
		return false;
	}

	private static boolean isOneEditReplace(String first, String second) {
		boolean foundDifference = false;
		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) != second.charAt(i)) {
				if (foundDifference)
					return false;
				foundDifference = true;
			}
		}
		return true;
	}

	private static boolean isOneEditInsert(String first, String second) {
		int firstIndex = 0;
		int secondIndex = 0;
		while (firstIndex < first.length() && secondIndex < second.length()) {
			if (first.charAt(firstIndex) != second.charAt(secondIndex)) {
				if (firstIndex != secondIndex)
					return false;
				secondIndex++;
			} else {
				firstIndex++;
				secondIndex++;
			}
		}
		return true;
	}

	public static boolean isOneEditAway(String first, String second) {
		if (first.length() - second.length() > 1)
			return false;
		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;
		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;
		while (index1 < first.length() && index2 < second.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (foundDifference)
					return false;
				foundDifference = true;
				if (first.length() == second.length())
					index1++;
			} else
				index1++;
			index2++;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isOneAway("pale", "ple"));
		System.out.println(isOneAway("pales", "pale"));
		System.out.println(isOneAway("pale", "bale"));
		System.out.println(isOneAway("pale", "ble"));
		// test second method of isOneEditAway
		System.out.println(isOneEditAway("pale", "ple"));
		System.out.println(isOneEditAway("pales", "pale"));
		System.out.println(isOneEditAway("pale", "bale"));
		System.out.println(isOneEditAway("pale", "ble"));
	}
}
