package org.dzhou.interview.hard;

import java.util.Random;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         编写一个方法，洗一副牌。要求做到完美洗牌，换言之，这副牌52！种排列组合出现的概率相同。假设给定一个完美的随机数生成器。
 */
public class Shuffle {

	public static Random random = new Random();

	public int[] shuffleArrayRecursively(int[] cards, int i) {
		if (i == 0)
			return cards;
		shuffleArrayRecursively(cards, i - 1);
		int rand = random.nextInt(i);
		swap(cards, rand, i);
		return cards;
	}

	public void shuffleArrayInteratively(int cars[]) {
		for (int i = 0; i < cars.length; i++) {
			int rand = random.nextInt(i);
			swap(cars, i, rand);
		}
	}

	private void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

}
