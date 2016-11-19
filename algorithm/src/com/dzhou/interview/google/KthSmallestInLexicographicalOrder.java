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

	public int findKthNumber(int n, int k) {
		if (k == 1)
			return 1;
		List<Integer> result = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			backtrack(result, i, n, set);
		}
		return result.get(k - 1);
	}

	private void backtrack(List<Integer> result, int start, int n, Set<Integer> set) {
		if (start > n)
			return;
		if (set.contains(start)) {
			return;
		}
		result.add(start);
		set.add(start);
		for (int j = 0; j < n; j++) {
			backtrack(result, start * 10 + j, n, set);
		}
	}

	public static void main(String[] args) {
		KthSmallestInLexicographicalOrder instance = new KthSmallestInLexicographicalOrder();
		int k = 2, n = 13;
		List<Integer> result = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= n; i++)
			instance.backtrack(result, i, n, set);
		System.out.println(result);
		System.out.println(instance.findKthNumber(n, k));
	}

}
