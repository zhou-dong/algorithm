package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 440. K-th Smallest in Lexicographical Order
 * 
 * Difficulty: Hard
 * 
 * Given integers n and k, find the lexicographically k-th smallest integer in
 * the range from 1 to n.
 * 
 * Note: 1 ≤ k ≤ n ≤ 109.
 * 
 * Example:
 * 
 * Input: n: 13 k: 2
 * 
 * Output: 10
 * 
 * Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6,
 * 7, 8, 9], so the second smallest number is 10.
 * 
 * @author zhoudong
 *
 */
public class KthSmallestInLexicographicalOrder {

	class Denary_Tree_Solution {

		public int findKthNumber(int n, int k) {

			int cur = 1;
			--k;
			while (k > 0) {
				long step = 0, first = cur, last = cur + 1;
				while (first <= n) {
					step += Math.min((long) n + 1, last) - first;
					first *= 10;
					last *= 10;
				}
				if (step <= k) {
					++cur;
					k -= step;
				} else {
					cur *= 10;
					--k;
				}
			}
			return cur;

		}
	}

	class BruteForce_Solution {

		public int findKthNumber(int n, int k) {
			List<Integer> result = new ArrayList<>();
			backtrack(result, 1, n);
			return result.get(k - 1);
		}

		private void backtrack(List<Integer> result, int start, int n) {
			if (start > n)
				return;
			result.add(start);
			backtrack(result, start * 10, n);
			if (start % 10 == 9)
				return;
			backtrack(result, start + 1, n);
		}

	}

}
