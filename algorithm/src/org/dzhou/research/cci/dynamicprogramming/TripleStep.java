package org.dzhou.research.cci.dynamicprogramming;

/**
 * Practice of "cracking the code interview"
 * 
 * A child is running up a staircase with n steps and can hop either 1 step, 2
 * steps, or 3 steps at a time. Implement a method to count how many possible
 * ways the child can run up the stairs.
 * 
 * @author DONG ZHOU
 *
 */
public class TripleStep {

	public class Solution {

		public int countWays(int n) {
			if (n < 0)
				return 0;
			int[] memo = createMemo(n);
			return countWays(n, memo);
		}

		private int[] createMemo(int n) {
			int size = (n < 3) ? 4 : n + 1;
			int[] memo = new int[size];
			memo[0] = 0;
			memo[1] = 1;
			memo[2] = 2;
			memo[3] = 4;
			return memo;
		}

		private int countWays(int n, int[] memo) {
			if (memo[n] != 0)
				return memo[n];
			memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
			return memo[n];
		}

	}

}
