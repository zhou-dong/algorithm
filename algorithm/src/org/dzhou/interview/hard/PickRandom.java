package org.dzhou.interview.hard;

import java.util.Random;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         编写一个方法，从大小为n的数组中随机选出m个整数。要求每个元素被选中的概率相同。
 */
public class PickRandom {

	public static Random random = new Random();

	public int[] pickMIteratively(int[] array, int m) {
		int[] result = new int[m];

		for (int i = 0; i < m; i++) {
			result[i] = array[i];
		}

		for (int i = m; i < array.length; i++) {
			int rand = random.nextInt(i);
			if (rand < m) {
				result[rand] = array[i];
			}
		}

		return result;
	}
}
