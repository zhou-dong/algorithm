package org.dzhou.interview.bitmanipulation;

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
 */
public class FlipBitToWin {

	public int longestSequence(int n) {
		if (n == -1)
			return Integer.BYTES * 8;
		List<Integer> sequences = getAlternatingSequences(n);
		return findLongestSequence(sequences);
	}

	private List<Integer> getAlternatingSequences(int n) {
		List<Integer> sequences = new ArrayList<>();
		int searchingFor = 0;
		int counter = 0;
		for (int i = 0; i < Integer.BYTES * 8; i++) {
			if ((n & 1) != searchingFor) {
				sequences.add(counter);
				searchingFor = n & 1;
				counter = 0;
			}
			counter++;
			n >>>= 1;
		}
		sequences.add(counter);
		return sequences;
	}

	private int findLongestSequence(List<Integer> seq) {
		int maxSeq = 1;
		for (int i = 0; i < seq.size(); i += 2) {
			int zeroSeq = seq.get(i);
			int onesSeqRight = i - 1 >= 0 ? seq.get(i - 1) : 0;
			int onesSeqLeft = i + 1 < seq.size() ? seq.get(i + 1) : 0;
			int thisSeq = 0;
			if (zeroSeq == 1) {
				thisSeq = onesSeqLeft + 1 + onesSeqRight;
			} else if (zeroSeq > 1) {
				thisSeq = 1 + Math.max(onesSeqLeft, onesSeqRight);
			} else if (zeroSeq == 0) {
				thisSeq = Math.max(onesSeqLeft, onesSeqRight);
			}
			maxSeq = Math.max(thisSeq, maxSeq);
		}
		return maxSeq;
	}

	public int flipBit(int a) {
		if (~a == 0)
			return Integer.BYTES * 8;
		int currentLength = 0;
		int previousLength = 0;
		int maxLength = 1;
		while (a != 0) {
			if ((a & 1) == 1) {
				currentLength++;
			} else if ((a & 1) == 0) {
				previousLength = (a & 2) == 0 ? 0 : currentLength;
				currentLength = 0;
			}
			maxLength = Math.max(previousLength + currentLength + 1, maxLength);
			a >>>= 1;
		}
		return maxLength;
	}

}
