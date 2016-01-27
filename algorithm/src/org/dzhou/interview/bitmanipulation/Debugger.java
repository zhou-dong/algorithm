package org.dzhou.interview.bitmanipulation;

/**
 * Practice of "cracking the code interview"
 * 
 * Explain what the following code does: ((n & (n - 1)) == 0).
 * 
 * @author DONG ZHOU
 *
 */
public class Debugger {

	public boolean isPowerTo2(int n) {
		return ((n & (n - 1)) == 0);
	}

}
