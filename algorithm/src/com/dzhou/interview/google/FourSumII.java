package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 454. 4Sum II
 * 
 * Difficulty: Medium
 * 
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j,
 * k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * 
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤
 * N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is
 * guaranteed to be at most 231 - 1.
 * 
 * Example:
 * 
 * Input: <br>
 * A = [ 1, 2] <br>
 * B = [-2,-1] <br>
 * C = [-1, 2] <br>
 * D = [ 0, 2] <br>
 * 
 * Output: 2
 * 
 * Explanation: <br>
 * The two tuples are: <br>
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0 <br>
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0 <br>
 * 
 * @author zhoudong
 *
 */
public class FourSumII {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int[] AB = twoSumCombination(A, B);
		int[] CD = twoSumCombination(C, D);
		return countZero(AB, CD);
	}

	private int countZero(int[] A, int[] B) {
		Map<Integer, Integer> map = toHashMap(B);
		int count = 0;
		for (int num : A) {
			if (map.containsKey(0 - num)) {
				count += map.get(0 - num);
			}
		}
		return count;
	}

	private Map<Integer, Integer> toHashMap(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		return map;
	}

	private int[] twoSumCombination(int[] A, int[] B) {
		int[] result = new int[A.length * B.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				result[i * B.length + j] = A[i] + B[j];
			}
		}
		return result;
	}
}
