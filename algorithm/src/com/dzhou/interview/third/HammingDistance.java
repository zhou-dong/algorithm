package com.dzhou.interview.third;

/**
 * 461. Hamming Distance Add to List QuestionEditorial Solution My Submissions
 * Total Accepted: 1415 Total Submissions: 1779 Difficulty: Easy Contributors:
 * Samuri The Hamming distance between two integers is the number of positions
 * at which the corresponding bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Note: 0 ≤ x, y < 231.
 * 
 * Example:
 * 
 * Input: x = 1, y = 4
 * 
 * Output: 2
 * 
 * Explanation: 1 (0 0 0 1) 4 (0 1 0 0) ↑ ↑
 * 
 * The above arrows point to positions where the corresponding bits are
 * different.
 * 
 * @author zhoudong
 *
 */
public class HammingDistance {

	public int hammingDistance(int x, int y) {
		int count = 0;
		for (int i = 0; i < 32; i++)
			count += (getBit(x, i) ^ getBit(y, i));
		return count;
	}

	private int getBit(int num, int index) {
		int mask = 1 << index;
		return (num & mask) > 0 ? 1 : 0;
	}

}
