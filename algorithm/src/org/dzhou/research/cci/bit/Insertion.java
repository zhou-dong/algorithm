package org.dzhou.research.cci.bit;

/**
 * Practice of "cracking the code interview"
 * 
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to insert M into N such that M starts at bit j and ends at bit
 * i. You can assume that the bits j through i have enough space to fit all of
 * M. That is. if M = 10011, you can assume that there are at least 5 bits
 * between j and i. you would not, for example, have j=3 and i=2, because M
 * could not fully fit between bit 3 and bit 2.
 * 
 * @author DONG ZHOU
 *
 *         Solution
 *
 *         1. Clear the bits j through i in N <br>
 *         2. Shift M so that is lines up with bits in trough i <br>
 *         3. Merge M and N
 */
public class Insertion {

	public class Solution {

		public int updateBits(int n, int m, int i, int j) {
			int mask = getMask(i, j);
			return clearBits(n, mask) | shift(m, i);
		}

		private int shift(int m, int i) {
			return m << i;
		}

		private int clearBits(int n, int mask) {
			return n & mask;
		}

		private int getMask(int i, int j) {
			int allOnes = ~0;
			int left = allOnes << (j + 1); // left = 11100000
			int right = ((1 << i) - 1); // right = 00000011
			return left | right;
		}

	}

}
