package org.dzhou.practice.easy;

import java.util.Arrays;

/**
 * Description:
 * 
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * @author zhoudong
 *
 */
public class CountPrimes {

	public int countPrimes(int n) {
		boolean[] prime = new boolean[n];
		Arrays.fill(prime, true);

		for (int i = 2; i < n; i++) {
			if (prime[i]) {
				for (int j = i * 2; j < n; j = j + i) {
					prime[j] = false;
				}
			}
		}

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (prime[i])
				count++;
		}
		return count;
	}

}
