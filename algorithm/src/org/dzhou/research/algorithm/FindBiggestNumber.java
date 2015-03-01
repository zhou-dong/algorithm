package org.dzhou.research.algorithm;

public class FindBiggestNumber {

	private int[] array = { 1, 3, 5, 6, 9, 10, 45, 28, 6 };

	public int execute() {
		int result = array[0];
		for (int i : array)
			if (i > result)
				result = i;
		return result;
	}

	public static void main(String[] args) {
		FindBiggestNumber instance = new FindBiggestNumber();
		System.out.println(instance.execute());
	}

}