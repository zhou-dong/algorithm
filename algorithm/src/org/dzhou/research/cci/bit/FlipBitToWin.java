package org.dzhou.research.cci.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * Practice of "cracking the code interview"
 * 
 * You have an integer and you can flip exactly one bit from a 0 to a 1. Write
 * code to find the length of the longest sequence of 1s you could create.
 * 
 * @author DONG ZHOU
 *
 *         Example:
 *
 *         11011101111 <br>
 *         20304<br>
 */
public class FlipBitToWin {

	public class Solution {
		public int longestSequence(int n) {
			int max = Integer.MIN_VALUE;
			List<Integer> sequences = getAlternatingSequences(n);
			for (int i = 1; i < sequences.size(); i++)
				max = Math.max(max, sequences.get(i) + sequences.get(i - 1));
			return max + 1;
		}

		private List<Integer> getAlternatingSequences(int n) {
			List<Integer> sequences = new ArrayList<>();
			int counter = 0;
			for (int i = 0; i < Integer.BYTES * 8; i++) {
				int mask = 1 << i;
				if ((n & mask) == 0) {
					sequences.add(counter);
					counter = 0;
				} else {
					counter++;
				}
			}
			sequences.add(counter);
			return sequences;
		}
	}

}
