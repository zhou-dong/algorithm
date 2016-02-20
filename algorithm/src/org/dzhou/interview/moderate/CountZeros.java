package org.dzhou.interview.moderate;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         设计一个算法，算出n阶乘有多少个尾随零。规定0阶乘有0个尾随零，负数没有阶乘。
 * 
 *         1、把n! 分解成若干个素数相乘，只有 2*5 才可能产生尾随零，而2 的数量多于5，所以问题转化为计算有多少个5.
 * 
 *         2、先数一数1到n之间有几个5的倍数（数量为n/5），然后数有几个25的倍数（数量为n/25），依次类推。
 * 
 */
public class CountZeros {

	public int factorsOf5(int i) {
		int count = 0;
		while (i % 5 == 0) {
			count++;
			i /= 5;
		}
		return count;
	}

	public int countFactZeros(int num) {
		int count = 0;
		for (int i = 5; i <= num; i++) {
			count += factorsOf5(i);
		}
		return count;
	}

	public int countFactZeros2(int num) {
		int count = 0;
		if (num < 0) {
			return -1;
		}
		for (int i = 5; num / i > 0; i *= 5) {
			count += num / i;
		}
		return count;
	}
}
