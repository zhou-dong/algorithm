package org.dzhou.interview.math;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class Prime {

	public boolean primeNaive(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i < n; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	public boolean primeSlightBetter(int n) {
		if (n < 2)
			return false;
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++)
			if (n % i == 0)
				return false;
		return true;
	}

}
