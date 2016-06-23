package org.dzhou.practice.medium;

import java.util.Arrays;

/**
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers.
 * 
 * Note that 1 is typically treated as an ugly number.
 * 
 * Hint:
 * 
 * 1. The naive approach is to call isUgly for every number until you reach the
 * nth one. Most numbers are not ugly. Try to focus your effort on generating
 * only the ugly ones.
 * 
 * 2. An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly
 * number.
 * 
 * 3. The key is how to maintain the order of the ugly numbers. Try a similar
 * approach of merging from three sorted lists: L1, L2, and L3.
 * 
 * 4. Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2
 * * 3, L3 * 5).
 * 
 * @author zhoudong
 *
 */
public class UglyNumberII {

	public class Solution {

		public int nthUglyNumber(int n) {

			int[] primes = { 2, 3, 5 };
			int[] nums = new int[n];
			nums[0] = 1;
			int[] index = new int[primes.length];
			Arrays.fill(index, 0);

			for (int i = 1; i < n; i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < primes.length; j++) {
					int temp = primes[j] * nums[index[j]];
					min = Math.min(temp, min);
				}
				for (int j = 0; j < primes.length; j++) {
					if (min == primes[j] * nums[index[j]]) {
						index[j]++;
					}
				}
				nums[i] = min;
			}

			return nums[n - 1];
		}

	}

}
