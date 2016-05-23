package org.dzhou.practice.easy;

/**
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * @author zhoudong
 *
 */
public class ImplementStrStr {

	public int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		for (int i = 0; i < haystack.length() && i + needle.length() <= haystack.length(); i++)
			if (haystack.charAt(i) == needle.charAt(0) && equal(haystack, needle, i))
				return i;
		return -1;
	}

	private boolean equal(String haystack, String needle, int start) {
		for (int i = 0; i < needle.length(); i++)
			if (needle.charAt(i) != haystack.charAt(i + start))
				return false;
		return true;
	}

}
