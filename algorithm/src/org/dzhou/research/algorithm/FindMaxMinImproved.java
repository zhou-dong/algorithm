package org.dzhou.research.algorithm;

/**
 * 为了同时找到最大的数和最小的数
 * 
 * 正常比较是：在一次循环过程中每个元素比较两次
 * 
 * 如果两两线比较的话，每两个元素比较三次
 * 
 * @author DONG ZHOU
 */
public class FindMaxMinImproved {

	private int[] array = { 7, -4, -1, 1, 3, 5, 6, 9, 10, 45, 28, 6, 99, -120 };

	public FindMaxMinImproved() {
		initMaxMin(array[0], array[1]);
	}

	public int max;
	public int min;

	public void execute() {
		for (int i = getStart(); i < array.length; i += 2) {
			int first = array[i];
			int second = array[i + 1];
			if (findSmall(first, second) == 0) {
				if (first < min)
					min = first;
				if (second > max)
					max = second;
			} else {
				if (second < min)
					min = second;
				if (first > max)
					max = first;
			}
		}
	}

	/**
	 * 
	 * 如果数组有偶数个元素：从第【三】个元素开始比较】
	 * 
	 * 如果数组有奇数个元素：从第【二】个元素开始比较】
	 * 
	 * @return 进行比较的开始元素下标
	 */
	private int getStart() {
		return isEven() ? 2 : 1;
	}

	private void initMaxMin(int first, int second) {
		if (isEven()) {// array has even number
			if (findSmall(first, second) == 0) {
				min = first;
				max = second;
			} else {
				min = second;
				max = first;
			}
		} else {// array has odd number
			min = first;
			max = first;
		}
	}

	private boolean isEven() {
		return array.length % 2 == 0;
	}

	private int findSmall(int first, int second) {
		return first < second ? 0 : 1;
	}

	public static void main(String[] args) {
		FindMaxMinImproved instance = new FindMaxMinImproved();
		instance.execute();
		System.out.println(instance.max);
		System.out.println(instance.min);
	}

}