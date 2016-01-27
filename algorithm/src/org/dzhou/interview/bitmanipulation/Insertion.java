package org.dzhou.interview.bitmanipulation;

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
 */
public class Insertion {

	public int updateBits(int n, int m, int i, int j) {
		int allOnes = ~0; // will equal sequence of all 1s
		int left = allOnes << (j + 1);
		int right = ((1 << i) - 1);
		int mask = left | right;
		int n_cleared = n & mask;
		int m_shifted = m << i;
		return n_cleared | m_shifted;
	}

}
