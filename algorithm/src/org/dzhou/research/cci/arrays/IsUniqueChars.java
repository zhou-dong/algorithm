package org.dzhou.research.cci.arrays;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique
 * character. What is you cannot use additional data structures?
 *
 * 判断一个字符串中的字符是不是都唯一。
 * 
 * 方法：
 * 
 * 0. Brute Force<br>
 * 1. Sort first than compare<br>
 * 2. Use array to index each character<br>
 * 3. Use bit as index<br>
 * 
 * @author zhoudong
 *
 */
public class IsUniqueChars {

	// Bit check: time complexity O(N); space complexity O(1)
	public class Solution3 {
		boolean isUniqueChars(String str) {
			int checker = 0;
			for (char c : str.toCharArray()) {
				int mask = 1 << (c - 'a');
				if ((checker & mask) > 0)
					return false;
				checker |= mask;
			}
			return true;
		}
	}

	// Use array to index: time complexity O(N); space complexity O(N)
	public class Solution2 {
		boolean isUniqueChars(String str) {
			if (str.length() > 128)
				return false;
			boolean[] char_set = new boolean[128];
			for (char c : str.toCharArray()) {
				if (char_set[c])
					return false;
				char_set[c] = true;
			}
			return true;
		}
	}

	// Sort and compare: runtime O(N*log(N))
	public class Solution1 {
		boolean isUniqueChars(String str) {
			char[] sorted = sort(str);
			for (int i = 1; i < sorted.length; i++) {
				if (sorted[i] == sorted[i - 1])
					return false;
			}
			return true;
		}

		private char[] sort(String str) {
			char[] chars = str.toCharArray();
			java.util.Arrays.sort(chars);
			return chars;
		}
	}

	// Brute Force: runtime O(N^2)
	public class Solution {
		boolean isUniqueChars(String str) {
			for (int i = 0; i < str.length(); i++) {
				for (int j = i + 1; j < str.length(); j++) {
					if (str.charAt(i) == str.charAt(j))
						return false;
				}
			}
			return true;
		}
	}

}
