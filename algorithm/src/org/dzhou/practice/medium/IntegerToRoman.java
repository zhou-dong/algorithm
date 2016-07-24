package org.dzhou.practice.medium;

/**
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * reference:
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-integer-to-roman.html
 * 
 * @author zhoudong
 * 
 *         I: 1<br>
 *         V: 5<br>
 *         X: 10<br>
 *         L: 50<br>
 *         C: 100<br>
 *         D: 500<br>
 *         M: 1000<br>
 */
public class IntegerToRoman {

	enum Roman {
		I(1, "I"), IV(4, "IV"), V(5, "V"), IX(9, "IX"), X(10, "X"), XL(40, "XL"), L(50, "L"), XC(90, "XC"), C(100,
				"C"), CD(400, "CD"), D(500, "D"), CM(900, "CM"), M(1000, "M");

		private int decimal;
		private String roman;

		Roman(int decimal, String roman) {
			this.decimal = decimal;
			this.roman = roman;
		}

		public int getDecimal() {
			return decimal;
		}

		public String getRoman() {
			return roman;
		}

	}

	public class Solution {

		public String intToRoman(int num) {
			StringBuilder sb = new StringBuilder();

			Roman[] romans = Roman.values();
			for (int i = romans.length - 1; i >= 0; i--) {
				int current = romans[i].getDecimal();
				if (num >= current) {
					int count = num / current;
					for (int j = 0; j < count; j++) {
						sb.append(romans[i].getRoman());
					}
					num %= current;
				}
			}

			return sb.toString();
		}

	}

}
