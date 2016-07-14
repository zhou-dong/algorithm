package org.dzhou.research.cci.arraystring;

/**
 * Assume you have a method is Substring with checks if one word is substring of
 * another. Given two Strings, s1 and s2, write code to check if s2 is a
 * rotation of s1 using only one call to isSubstring.
 * 
 * @author zhoudong
 *
 */
public class StringRotation {

	public class Solution {

		boolean isRotation(String s1, String s2) {
			if (s1 == null || s2 == null || s1.length() == 0 || s1.length() != s2.length())
				return false;
			return isSubstring(s1 + s1, s2);
		}

		// TODO
		private boolean isSubstring(String s1, String s2) {
			return false;
		}

	}

}
