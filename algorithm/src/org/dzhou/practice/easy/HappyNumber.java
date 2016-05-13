package org.dzhou.practice.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 1^2 + 9^2 = 82<br>
 * 8^2 + 2^2 = 68<br>
 * 6^2 + 8^2 = 100<br>
 * 1^2 + 0^2 + 0^2 = 1<br>
 * 
 * @author zhoudong
 *
 */
public class HappyNumber {

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		while (n != 1) {
			if (set.contains(n))
				return false;
			set.add(n);
			n = getSum(n);
		}
		return true;
	}

	private int getSum(int n) {
		int sum = 0;
		while (n > 0) {
			int mod = n % 10;
			sum += mod * mod;
			n /= 10;
		}
		return sum;
	}

}
