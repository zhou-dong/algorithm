package org.dzhou.interview.hard;

/**
 * Practice of "cracking the code interview"
 * 
 * 编写一个方法，数出从0到n（含）中数字2出现了几次。
 * 
 * @author DONG ZHOU
 *
 */
public class Count2 {

	public int numberOf2sInRange(int n) {
		int count = 0;
		for (int i = 2; i <= n; i++) {
			count += numberOf2s(i);
		}
		return count;
	}

	private int numberOf2s(int n) {
		int count = 0;
		while (n > 0) {
			if (n % 10 == 2) {
				count++;
			}
			n /= 10;
		}
		return count;
	}

}
