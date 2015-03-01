package org.dzhou.research.algorithm;

public class FindMaxMin {

	private int[] array = { -1, 1, 3, 5, 6, 9, 10, 45, 28, 6 };

	public int max = Integer.MIN_VALUE;
	public int min = Integer.MAX_VALUE;

	public void execute() {
		for (int i : array) {
			if (i > max)
				max = i;
			if (i < min)
				min = i;
		}
	}

	public static void main(String[] args) {
		FindMaxMin instance = new FindMaxMin();
		instance.execute();
		System.out.println(instance.max);
		System.out.println(instance.min);
	}

}