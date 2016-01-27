package org.dzhou.interview.bitmanipulation;

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

	public String printBinary(double num) {
		if (num >= 1 || num <= 0)
			return ERROR;
		StringBuffer binary = new StringBuffer();
		binary.append(".");
		while (num > 0) {
			if (binary.length() >= 32)
				return ERROR;
			double r = num * 2;
			if (r >= 1) {
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}

}
