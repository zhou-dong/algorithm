package org.dzhou.practice.easy;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,<br>
 * a = "11"<br>
 * b = "1"<br>
 * Return "100".<br>
 * 
 * @author zhoudong
 *
 */
public class AddBinary {

	public String addBinary(String a, String b) {
		StringBuilder rst = new StringBuilder();
		int x = a.length() - 1, y = b.length() - 1, carries = 0;
		for (; x >= 0 && y >= 0; x--, y--) {
			int sum = (int) (a.charAt(x) - '0') + (int) (b.charAt(y) - '0') + carries;
			rst.append(sum % 2);
			carries = sum / 2;
		}
		while (x >= 0) {
			int sum = (int) (a.charAt(x) - '0') + carries;
			rst.append(sum % 2);
			carries = sum / 2;
			x--;
		}
		while (y >= 0) {
			int sum = (int) (b.charAt(y) - '0') + carries;
			rst.append(sum % 2);
			carries = sum / 2;
			y--;
		}
		if (carries > 0)
			rst.append(1);
		return rst.reverse().toString();
	}

}
