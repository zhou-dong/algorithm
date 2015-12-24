package org.dzhou.interview.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Implement an algorithm to determine if a string has all unique character.
 * What if you can not use additional data structures?
 * 
 * @author DONG ZHOU
 * 
 *         First should ask is the string is an ASCII string we know the length
 *         of ASCII, so we can use an array to do, which running time is O(n).
 * 
 *         We also can use bit operation to handle this question, This will
 *         allow use just use a single integer or double to do it. In Java, 1
 *         int take 4 bytes, and 1 byte has 8 bits, so 1 integer == 32 bits.
 *         like: int i = 1 ( 00000000 00000000 00000000 00000001 )
 * 
 *         If the character may be Chinese character or other language which we
 *         do not know how long the character set is, we can sort the string
 *         first, then compare each character from begin to end. which running
 *         time is O(n*log(n)).
 * 
 *         If we can use hash table for hash map, we also could use that, which
 *         the running time is O(n), but will use extra space.
 * 
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

	/*
	 * one int has 32 bits. Like: 1 (0000 0000 0000 0000 0000 0000 0000 0001)
	 * 
	 * -------------------------------------------------------------------------
	 * 
	 * 左移( << )
	 * 
	 * 5 << 2; // 5左移2位, 运行结果是20
	 * 
	 * 5转换为二进制: 0000 0000 0000 0000 0000 0000 0000 0101 然后左移2位后，低位补0：
	 * 
	 * 换成10进制20: 0000 0000 0000 0000 0000 0000 0001 0100
	 * 
	 * -------------------------------------------------------------------------
	 * 
	 * 位与( & )
	 * 
	 * 5 & 3
	 * 
	 * 5转换为二进制：0000 0000 0000 0000 0000 0000 0000 0101
	 * 
	 * 3转换为二进制：0000 0000 0000 0000 0000 0000 0000 0011
	 * 
	 * ----------------------------------------------------
	 * 
	 * 1转换为二进制：0000 0000 0000 0000 0000 0000 0000 0001
	 * 
	 * -------------------------------------------------------------------------
	 * 
	 * |= 按位或赋值
	 * 
	 */
	public static boolean byBitMap(String input) {
		int check = 0;
		for (int i = 0; i < input.length(); i++) {
			int val = input.charAt(i) - 'a';
			if ((check & (1 << val)) > 0) // (1 << val): 1 左移 val个位置
				return false;
			check |= (1 << val); // |= 按位或赋值
		}
		return true;
	}

	public static boolean bySort(String input) {
		char[] chars = input.toCharArray();
		Arrays.sort(chars);
		char check = chars[0];
		for (int i = 1; i < chars.length; i++) {
			if (check == chars[i])
				return false;
			check = chars[i];
		}
		return true;
	}

	public static boolean byHashTable(String input) {
		Map<Character, Boolean> map = new HashMap<>();
		for (char c : input.toCharArray()) {
			if (map.get(c) != null)
				return false;
			map.put(c, true);
		}
		return true;
	}

}
