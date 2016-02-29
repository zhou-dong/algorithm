package org.dzhou.interview.moderate;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 * 
 *         编写一个方法找出两个数中最大的那一个。不得使用if-else或其它比较运算符。
 */
public class GetMax {

	// 1变0，0变1
	public static int flip(int bit) {
		return 1 ^ bit;
	}

	// a为正，则返回1，a为负，则返回0
	public static int sign(int a) {
		return flip((a >> 31) & 0x1);
	}

	public static int getMaxNative(int a, int b) {
		int k = sign(a - b);
		int q = flip(k);
		return a * k + b * q;
	}

}
