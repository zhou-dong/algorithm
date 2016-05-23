package org.dzhou.practice.easy;

/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A<br>
 * 2 -> B<br>
 * 3 -> C<br>
 * ... <br>
 * 26 -> Z<br>
 * 27 -> AA<br>
 * 28 -> AB <br>
 * 
 * @author zhoudong
 *
 */
public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		if (n < 1)
			return "";
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;
			sb.append((char) (n % 26 + 'A'));
			n /= 26;
		}
		return sb.reverse().toString();
	}

}
