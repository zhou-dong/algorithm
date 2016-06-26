package org.dzhou.practice.medium;

/**
 * Given two numbers represented as strings, return multiplication of the
 * numbers as a string.
 * 
 * Note:
 * 
 * The numbers can be arbitrarily large and are non-negative.
 * 
 * Converting the input string to integer is NOT allowed.
 * 
 * You should NOT use internal library such as BigInteger.
 * 
 * @author zhoudong
 *
 *
 *         reference from: http://www.cnblogs.com/springfor/p/3889706.html
 *
 *         for example: 385 * 97
 *
 *         385<br>
 *         *97<br>
 *         ---<br>
 *         (7*5) * 1<br>
 *         (7*8 + 9*5) * 10<br>
 *         (7*3 + 9*8) * 100<br>
 *         (9*3) * 1000<br>
 * 
 *         这个数组最大长度是num1.length + num2.length，比如99 * 99，最大不会超过10000，所以4位就够了。
 */
public class MultiplyStrings {

	public class Solution {

		public String multiply(String num1, String num2) {

			if (num1 == null || num2 == null) {
				return "";
			}

			num1 = new StringBuilder(num1).reverse().toString();
			num2 = new StringBuilder(num2).reverse().toString();

			// even 99 * 99 is < 10000, so maximally 4 digits
			int[] hold = new int[num1.length() + num2.length()];
			for (int i = 0; i < num1.length(); i++) {
				int a = num1.charAt(i) - '0';
				for (int j = 0; j < num2.length(); j++) {
					int b = num2.charAt(j) - '0';
					hold[i + j] += a * b; // 本题的亮点（关键）
				}
			}

			StringBuilder sb = new StringBuilder();
			int carry = 0, digit = 0;
			for (int x : hold) {
				x += carry;
				digit = x % 10;
				carry = x / 10;
				sb.insert(0, digit);
			}

			// trim starting zeros
			while (sb.length() > 0 && sb.charAt(0) == '0')
				sb.deleteCharAt(0);

			return sb.length() == 0 ? "0" : sb.toString();
		}

	}

}
