package org.dzhou.interview.hard;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         编写一个函数，将两个数字相加。不得使用+或其它算术运算符。
 * 
 */
public class Add {

	// 每次 (a & b) << 1，都会进位，直到 a & b == 0
	public static int add(int a, int b) {
		if (b == 0)
			return a;
		int sum = a ^ b; // 相加但不进位
		int carry = (a & b) << 1; // 进位，但不相加
		return add(sum, carry);
	}

}
