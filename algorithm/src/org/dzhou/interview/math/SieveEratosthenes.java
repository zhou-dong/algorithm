package org.dzhou.interview.math;

import java.util.Arrays;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class SieveEratosthenes {

	boolean[] sieveEratosthenes(int max) {
		boolean[] flags = createFlags(max);
		int prime = 2;
		while (prime <= Math.sqrt(max)) {
			crossOff(flags, prime);
			prime = getNextPrime(flags, prime);
		}
		return flags;
	}

	void crossOff(boolean[] flags, int prime) {
		for (int i = prime * prime; i < flags.length; i += prime) {
			flags[i] = false;
		}
	}

	int getNextPrime(boolean[] flags, int prime) {
		int next = prime + 1;
		while (next < flags.length && !flags[next]) {
			next++;
		}
		return next;
	}

	boolean[] createFlags(int max) {
		boolean[] flags = new boolean[max + 1];
		init(flags);
		return flags;
	}

	void init(boolean[] flags) {
		Arrays.fill(flags, true);
		flags[0] = false;
		flags[1] = false;
	}

}
