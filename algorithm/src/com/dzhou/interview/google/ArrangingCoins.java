package com.dzhou.interview.google;

/**
 * 441. Arranging Coins
 * 
 * Difficulty: Easy
 * 
 * You have a total of n coins that you want to form in a staircase shape, where
 * every k-th row must have exactly k coins.
 * 
 * Given n, find the total number of full staircase rows that can be formed.
 * 
 * n is a non-negative integer and fits within the range of a 32-bit signed
 * integer.
 * 
 * @author zhoudong
 *
 */
public class ArrangingCoins {

	public int arrangeCoins(int n) {
		int index = 1;
		double sum = 0;
		while (true) {
			sum += index;
			if (sum > n) {
				return index - 1;
			}
			index++;
		}
	}

}
