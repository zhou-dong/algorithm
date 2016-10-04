package org.dzhou.practice.easy;

/**
 * 400. Nth Digit
 * 
 * @author zhoudong
 *
 */
public class NthDigit {

	public int findNthDigit(int n) {
		int k = 1;
		long len = 0;
		while (n > len) {
			len += (int) (9 * k * Math.pow(10, k - 1));
			k++;
		}
		k--;
		len -= (int) (9 * k * Math.pow(10, k - 1));
		// ————前部分
		int num = 0;
		if ((n - len) % k == 0) {
			num = (int) ((int) Math.pow(10, k - 1) + (n - len) / k - 1);
			String s = String.valueOf(num);
			return Integer.parseInt("" + s.charAt(s.length() - 1));
		} else {
			num = (int) ((int) Math.pow(10, k - 1) + (n - len) / k);
			String s = String.valueOf(num);
			return Integer.parseInt("" + s.charAt((int) ((n - len) % k - 1)));
		}
	}

}
