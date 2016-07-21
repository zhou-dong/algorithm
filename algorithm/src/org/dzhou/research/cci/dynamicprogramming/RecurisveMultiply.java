package org.dzhou.research.cci.dynamicprogramming;

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

	boolean isOppositeSign(int x, int y) {
		return (x ^ y) < 0;
	}

	boolean isSameSign(int x, int y) {
		return (x ^ y) >= 0;
	}

	class Solution {
		public int multiply(int a, int b) {
			int answer = multiplyPositive(Math.abs(a), Math.abs(b));
			return isSameSign(a, b) ? answer : (0 - answer);
		}

		private int multiplyPositive(int a, int b) {
			int min = Math.min(a, b);
			int max = Math.max(a, b);
			int count = 0;
			for (int i = 0; i < min; i++) {
				count += max;
			}
			return count;
		}
	}

	class Solution1 {
		public int multiply(int a, int b) {
			int answer = multiplyPositive(Math.abs(a), Math.abs(b));
			return isSameSign(a, b) ? answer : (0 - answer);
		}

		private int multiplyPositive(int a, int b) {
			int count = 0;
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {
					count++;
				}
			}
			return count;
		}
	}

	// bit operation
	class Solution2 {

		public int multiply(int a, int b) {
			int answer = multiplyPositive(Math.abs(a), Math.abs(b));
			return isSameSign(a, b) ? answer : (0 - answer);
		}

		public int multiplyPositive(int a, int b) {
			return minProductHelper(Math.min(a, b), Math.max(a, b));
		}

		private int minProductHelper(int smaller, int bigger) {
			if (smaller == 0)
				return 0;
			else if (smaller == 1)
				return bigger;
			int halfProd = minProductHelper(smaller >> 1, bigger);
			if (smaller % 2 == 0) {
				return halfProd + halfProd;
			} else {
				return halfProd + halfProd + bigger;
			}
		}
	}

}