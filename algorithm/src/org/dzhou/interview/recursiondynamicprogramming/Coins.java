package org.dzhou.interview.recursiondynamicprogramming;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         Given an infinite number of quarters (25 cents), dimes (10 cents),
 *         nickels (5 cents) and pennies (1 cent), write code to calculate the
 *         number of ways of representing n cents.
 *
 */
public class Coins {

	public int makeChange(int amount, int[] denoms, int index) {
		int ways = 0;

		return ways;

	}

	int makeChange(int n) {
		int[] denoms = { 25, 10, 5, 1 };
		return makeChange(n, denoms, 0);
	}

}
