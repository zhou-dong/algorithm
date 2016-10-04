package org.dzhou.practice.medium;

/**
 * 390. Elimination Game
 * 
 * Difficulty: Medium
 * 
 * There is a list of sorted integers from 1 to n. Starting from left to right,
 * remove the first number and every other number afterward until you reach the
 * end of the list.
 * 
 * Repeat the previous step again, but this time from right to left, remove the
 * right most number and every other number from the remaining numbers.
 * 
 * We keep repeating the steps again, alternating left to right and right to
 * left, until a single number remains.
 * 
 * Find the last number that remains starting with a list of length n.
 * 
 * Example:
 * 
 * Input:
 * 
 * n = 9,
 * 
 * 1 2 3 4 5 6 7 8 9
 * 
 * 2 4 6 8
 * 
 * 2 6
 * 
 * 6
 * 
 * Output: 6
 * 
 * @author zhoudong
 *
 */
public class EliminationGame {

	public class Iterator_Solution {
		public int lastRemaining(int n) {
			boolean left = true;
			int remain = n;
			int step = 1;
			int head = 1;
			while (remain > 1) {
				if (left || remain % 2 == 1) {
					head += step;

				}
				remain /= 2;
				left = !left;
				step *= 2;
			}
			return head;
		}
	}

	public class Recursive_Solution {
		public int lastRemaining(int n) {
			return f(n, true);
		}

		public int f(int n, boolean flag) {
			if (n <= 2) {
				return flag ? n : 1;
			} else {
				return 2 * f(n / 2, !flag) - (((n & 1) == 0 && !flag) ? 1 : 0);
			}
		}
	}

}
