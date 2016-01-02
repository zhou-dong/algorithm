package org.dzhou.interview.arrayandstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * As always should confirm some details with interviews: (1). if the
 * permutation comparison is case sensitive? (2). if whitespace is significant?
 * 
 * @author DONG ZHOU
 *
 *         Sort the strings. O(n*log(n))
 * 
 *         count each character's appear time. O(n)
 */
public class Permutation {

	static String sort(String input) {
		char[] chars = input.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	public static boolean isPermutationBySort(String first, String second) {
		if (first.length() != second.length())
			return false;
		return sort(first).equals(sort(second));
	}

	// If ASCII codes string
	public static boolean isPermutationInAscii(String first, String second) {
		if (first.length() != second.length())
			return false;
		int[] characters = new int[128];
		for (int i = 0; i < first.length(); i++) {
			characters[first.charAt(i)]++;
		}
		for (int i = 0; i < second.length(); i++) {
			int val = second.charAt(i);
			characters[val]--;
			if (characters[val] < 0)
				return false;
		}
		return true;
	}

	// If Chinese language like UTF-8
	public static boolean isPermutationByMap(String first, String second) {
		if (first.length() != second.length())
			return false;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < first.length(); i++) {
			char key = first.charAt(i);
			if (map.get(key) == null)
				map.put(key, 1);
			else
				map.put(key, map.get(key) + 1);
		}
		for (int i = 0; i < second.length(); i++) {
			char key = second.charAt(i);
			if (map.get(key) == null)
				return false;
			else {
				map.put(key, map.get(key) - 1);
				if (map.get(key) < 0)
					return false;
			}
		}
		return true;
	}

}
