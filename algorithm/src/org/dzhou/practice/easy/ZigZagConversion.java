package org.dzhou.practice.easy;

/**
 * 
 * @author zhoudong
 *
 */
public class ZigZagConversion {

	public String convert(String s, int numRows) {
		if (numRows < 2 || s == null || s.length() == 0) {
			return s;
		}
		int size = 2 * (numRows - 1);
		StringBuilder rst = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			for (int j = i; j < s.length(); j += size) {
				rst.append(s.charAt(j));
				if (i != 0 && i != numRows - 1 && j + size - 2 * i < s.length()) {
					rst.append(s.charAt(j + size - 2 * i));
				}
			}
		}
		return rst.toString();
	}

}
