package org.dzhou.interview.moderate;

import java.util.Random;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         给定一个rand5()，实现一个方法rand7()。也即，给定一个产生0到4（含）随机数的方法，编写一个产生0到6（含）随机数的方法。
 *
 */
public class Rand7 {

	public static int rand5() {
		Random random = new Random();
		return random.nextInt(5);
	}

	/*
	 * 这个方法有问题，比如：
	 * 
	 * value = 0 只能是(0+0=0)
	 * 
	 * value = 4 可以是(1+3=4), (3+1=4), (2+2=4)
	 * 
	 */
	public static int rand7Bad() {
		int value = rand5() + rand5();
		return value % 7;
	}

	public static int rand7() {
		while (true) {
			int num = 5 * rand5() + rand5();
			if (num < 21) {
				return num % 7;
			}
		}
	}

}
