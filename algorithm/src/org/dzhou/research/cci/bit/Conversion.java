package org.dzhou.research.cci.bit;

/**
 * Practice of "cracking the code interview"
 * 
 * Write a function to determine the number of bits you would need to flip to
 * convert integer A to integer B.
 * 
 * @author DONG ZHOU
 *
 *         Idea is simple: just with an XOR
 * 
 */
public class Conversion {

	// XOR
	public class Solution {
		public int bitSwapRequired(int a, int b) {
			int count = 0;
			for (int c = a ^ b; c != 0; c >>= 1) {
				count += c & 1;
			}
			return count;
		}
	}

	public class Solution1 {
		public int bitSwapRequired2(int a, int b) {
			int count = 0;
			for (int c = a ^ b; c != 0; c = c & (c - 1)) {
				count++;
			}
			return count;
		}
	}

}
