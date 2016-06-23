package org.dzhou.practice.medium;

import java.util.Arrays;

/**
 * Write a program to find the nth super ugly number.
 * 
 * Super ugly numbers are positive numbers whose all prime factors are in the
 * given prime list primes of size k.
 * 
 * For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of
 * the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 * 
 * Note:<br>
 * (1) 1 is a super ugly number for any given primes.<br>
 * (2) The given numbers in primes are in ascending order.<br>
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.*
 * 
 * @author zhoudong
 * 
 *         题目大意：
 *
 *         编写程序寻找第n个“超级丑陋数”
 * 
 *         超级丑陋数是指只包含给定的k个质因子的正数。例如，给定长度为4的质数序列primes = [2, 7, 13,
 *         19]，前12个超级丑陋数序列为：[1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]
 * 
 *         注意：
 * 
 *         (1) 1 被认为是超级丑陋数，无论给定怎样的质数列表.
 * 
 *         (2) 给定的质数列表以升序排列.
 * 
 *         (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * 
 *         参考自（用图一步一步的解释）： http://www.cnblogs.com/Liok3187/p/5016076.html
 * 
 */
public class SuperUglyNumber {

	public class Solution {

		public int nthSuperUglyNumber(int n, int[] primes) {

			int[] superUglyNumbers = new int[n];
			superUglyNumbers[0] = 1;

			int[] index = new int[primes.length];
			Arrays.fill(index, 0);

			for (int i = 1; i < n; i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < primes.length; j++) {
					int temp = primes[j] * superUglyNumbers[index[j]];
					min = min < temp ? min : temp;
				}
				for (int j = 0; j < primes.length; j++) {
					if (min == primes[j] * superUglyNumbers[index[j]]) {
						index[j]++;
					}
				}
				superUglyNumbers[i] = min;
			}

			return superUglyNumbers[n - 1];
		}

	}
}
