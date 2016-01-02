package org.dzhou.interview.arrayandstring;

/**
 * Implement a method to perform basic string compression using the counts or
 * repeated characters. For example, the string aabbcccccaaa would become
 * a2b2c5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string. You can
 * assume the string has only upper case and lower case letters (a-z).
 * 
 * @author DONG ZHOU
 *
 */
public class StringCompression {

	public static String compress(String input) {
		StringBuffer compressed = new StringBuffer();
		int countConsecutive = 0;
		for (int i = 0; i < input.length(); i++) {
			countConsecutive++;
			if ((i + 1) >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
				compressed.append(input.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() < input.length() ? compressed.toString() : input;
	}

	// optimize by int[] with could be save space
	public static String compress2(String input) {
		int compressedLength = countCompression(input);
		if (compressedLength >= input.length())
			return input;
		StringBuffer compressed = new StringBuffer();
		int countConsecutive = 0;
		for (int i = 0; i < input.length(); i++) {
			countConsecutive++;
			if ((i + 1) >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
				compressed.append(input.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.toString();
	}

	private static int countCompression(String input) {
		int compressedLength = 0;
		int countConsecutive = 0;
		for (int i = 0; i < input.length(); i++) {
			countConsecutive++;
			if ((i + 1) >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
				compressedLength += 1 + String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}
		}
		return compressedLength;
	}

	public static void main(String[] args) {
		String test = "aabbccccccccccccccccccccccccccaaa";
		String testResult = "a2b2c5a3";
		String result = StringCompression.compress(test);
		System.out.println(testResult.equals(result));
		System.out.println(result);

		String result2 = StringCompression.compress2(test);
		System.out.println(testResult.equals(result2));
		System.out.println(result2);
	}
}
