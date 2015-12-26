package org.dzhou.interview.arrays;

/**
 * 
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a
 * rotation of s1 using only one call to isSubstring(e.g., "waterbottle" is a
 * rotation of "erbottlewat").
 * 
 * @author DONG ZHOU
 *
 */
public class StringRotation {

	public static boolean isRotation(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		if (len1 < 0 || len1 != len2)
			return false;
		String s1s1 = s1 + s1;
		return isSubstring(s1s1, s2);
	}

	private static boolean isSubstring(String s1, String s2) {
		return true;
	}

}
