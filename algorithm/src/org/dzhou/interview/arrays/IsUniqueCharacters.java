package org.dzhou.interview.arrays;

/**
 * 
 * Implement an algorithm to determine if a string has all unique character.
 * What if you can not use additional data structures?
 * 
 * @author DONG ZHOU
 * 
 *         First should ask is the string is an ASCII string or Unicode string.
 */
public class IsUniqueCharacters {

	public static boolean isUniqueForBasicAsciiCode(String input) {
		// Basic ASCII codes has 128 characters;
		return isUniqueForAsciiCode(input, 128);
	}

	public static boolean isUniqueForExtendedAsciiCode(String input) {
		// Extended ASCII Codes has 256 characters.
		return isUniqueForAsciiCode(input, 256);
	}

	private static boolean isUniqueForAsciiCode(String input, int size) {
		if (input.length() > size)
			return false;
		boolean[] char_set = new boolean[size];
		for (int i = 0; i < input.length(); i++) {
			int value = input.charAt(i);
			if (char_set[value])
				return false;
			char_set[value] = true;
		}
		return true;
	}

	public boolean isUniqueChars(String input) {

		return true;
	}

	public boolean byHashTable(String input) {

		return true;
	}

	public boolean byBitMap(String input) {

		return true;
	}

	public boolean bySortFirst(String input) {

		return true;
	}

	public static void main(String[] args) {
		System.out.println((int) 'a');

		System.out.println(isUniqueForExtendedAsciiCode("abc e123456yhnmjff"));

	}
}
