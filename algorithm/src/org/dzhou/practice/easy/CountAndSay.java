package org.dzhou.practice.easy;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.<br>
 * 11 is read off as "two 1s" or 21.<br>
 * 21 is read off as "one 2, then one 1" or 1211.<br>
 * Given an integer n, generate the nth sequence.<br>
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author zhoudong
 *
 */
public class CountAndSay {

	public String countAndSay(int n) {
		String result = "1";
		while (n > 1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < result.length(); i++) {
				int count = 1;
				while ((i + 1) < result.length() && result.charAt(i) == result.charAt(i + 1)) {
					count++;
					i++;
				}
				sb.append(count + "" + result.charAt(i));
			}
			result = sb.toString();
			n--;
		}
		return result;
	}

}
