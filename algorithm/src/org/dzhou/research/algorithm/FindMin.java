package org.dzhou.research.algorithm;

/**
 * @author DONG ZHOU
 */
public class FindMin {

	private int[] array = { -1, 1, 3, 5, 6, 9, 10, 45, 28, 6, -20 };

	public int execute() {
		int result = array[0];
		for (int i = 1; i < array.length; i++)
			if (array[i] < result)
				result = array[i];
		return result;
	}

	public static void main(String[] args) {
		FindMin instance = new FindMin();
		System.out.println(instance.execute());
	}

}