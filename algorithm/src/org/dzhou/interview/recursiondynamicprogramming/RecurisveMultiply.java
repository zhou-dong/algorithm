package org.dzhou.interview.recursiondynamicprogramming;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         Write a recursive function to multiply two positive integers without
 *         using the * operator (or / operator). You can use addition,
 *         subtraction, and bit shifting, but you should minimize the number of
 *         those operations.
 *
 */
public class RecurisveMultiply {

	public int minProduct(int a, int b) {
		int bigger = a < b ? b : a;
		int smaller = a < b ? a : b;
		return minProductHelper(smaller, bigger);
	}

	private int minProductHelper(int smaller, int bigger) {
		if (smaller == 0)
			return 0;
		else if (smaller == 1)
			return bigger;
		int s = smaller >> 1;
		int side1 = minProduct(s, bigger);
		int side2 = (smaller % 2 == 1) ? side2 = minProductHelper(smaller - s, bigger) : side1;
		return side1 + side2;
	}

	public int minProduct2(int a, int b) {
		int bigger = a < b ? b : a;
		int smaller = a < b ? a : b;
		int memo[] = new int[smaller + 1];
		return minProductHelper(smaller, bigger, memo);
	}

	private int minProductHelper(int smaller, int bigger, int[] memo) {
		if (smaller == 0)
			return 0;
		else if (smaller == 1)
			return bigger;
		else if (memo[smaller] > 0)
			return memo[smaller];
		int s = smaller >> 1;
		int side1 = minProductHelper(s, bigger, memo);
		int side2 = (smaller % 2 == 1) ? minProductHelper(smaller - s, bigger, memo) : side1;
		memo[smaller] = side1 + side2;
		return memo[smaller];
	}

}
