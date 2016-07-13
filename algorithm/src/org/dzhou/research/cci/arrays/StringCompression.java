package org.dzhou.research.cci.arrays;

/**
 * Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string aabcccccaaa would become
 * a2blc5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string.
 * 
 * @author zhoudong
 *
 */
public class StringCompression {

	public class Solution {

		String compress(String str) {

			int finalLength = countCompression(str);
			if (finalLength >= str.length())
				return str;

			StringBuilder compressed = new StringBuilder(finalLength);
			int countConsecutive = 0;
			for (int i = 0; i < str.length(); i++) {
				countConsecutive++;
				if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
					compressed.append(str.charAt(i)).append(countConsecutive);
					countConsecutive = 0;
				}
			}
			return compressed.toString();
		}

		private int countCompression(String str) {
			int compressedLength = 0;
			int countConsecutive = 0;
			for (int i = 0; i < str.length(); i++) {
				countConsecutive++;
				if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
					compressedLength += 1 + String.valueOf(countConsecutive).length();
					countConsecutive = 0;
				}
			}
			return compressedLength;
		}

	}

}
