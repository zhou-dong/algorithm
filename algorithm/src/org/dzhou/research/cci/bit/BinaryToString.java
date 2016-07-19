package org.dzhou.research.cci.bit;

/**
 * Practice of "cracking the code interview"
 * 
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a
 * double, print the binary representation. If the number can not be represented
 * accurately in binary with at most 32 characters, print "ERROR".
 * 
 * @author DONG ZHOU
 *
 */
public class BinaryToString {

	private final static String ERROR = "ERROR";

	public class Solution {
		public String printBinary(double num) {
			if (num >= 1 || num <= 0)
				return ERROR;
			StringBuilder binary = new StringBuilder();
			binary.append(".");
			while (num > 0) {
				if (binary.length() >= 32) {
					return ERROR;
				}
				double r = num * 2; // shirt left
				if (r >= 1) {
					binary.append(1);
					num = r - 1; // 1.00011101 - 1 = 0.00011101
				} else {
					binary.append(0);
					num = r;
				}
			}
			return binary.toString();
		}
	}

	// math solution
	public class Solution1 {
		public String printBinary(double num) {
			if (num >= 1 || num <= 0)
				return ERROR;
			StringBuilder binary = new StringBuilder();
			binary.append(".");
			double frac = 0.5;
			while (num > 0) {
				if (binary.length() > 32) {
					return ERROR;
				}
				if (num >= frac) {
					binary.append(1);
					num -= frac;
				} else {
					binary.append(0);
				}
				frac /= 2;
			}
			return binary.toString();
		}
	}

}
