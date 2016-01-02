package org.dzhou.interview.arrayandstring;

/**
 * Write a method to replace all spaces in a string with '%20'.
 * 
 * @author DONG ZHOU
 *
 */
public class URLify {

	public static String replaceSpaces(String input) {
		if (input == null || input.length() == 0)
			return "";
		char[] chars = input.toCharArray();
		// first iteration find how many spaces it the string
		int spaceCount = 0;
		for (char c : chars) {
			if (c == ' ') {
				spaceCount++;
			}
		}
		/*
		 * Replace space with '%20' from end to begin. We iterator from end to
		 * begin, so we don't need to check if is last element. We need set last
		 * element = '\0'
		 */
		int newLength = chars.length + 2 * spaceCount;
		char[] result = new char[newLength + 1];
		result[newLength] = '\0';
		for (int i = chars.length - 1; i >= 0; i--) {
			if (chars[i] == ' ') {
				result[--newLength] = '0';
				result[--newLength] = '2';
				result[--newLength] = '%';
			} else {
				result[--newLength] = chars[i];
			}
		}
		return new String(result);
	}

	// We also could use StringBuilder
	public static String replaceSpacesWithStringBuffer(String input) {
		StringBuffer result = new StringBuffer();
		char[] chars = input.toCharArray();
		for (char c : chars)
			if (c == ' ')
				result.append("%20");
			else
				result.append(c);
		return result.toString();
	}

	public static void main(String[] args) {
		String input = "dong zhou come from Troy University!";
		System.out.println(replaceSpaces(input));
		System.out.println(replaceSpacesWithStringBuffer(input));
	}

}
