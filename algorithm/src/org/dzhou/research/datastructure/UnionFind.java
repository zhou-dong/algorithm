package org.dzhou.research.datastructure;

import java.util.ArrayList;
import java.util.List;

public class UnionFind {

	private static void union() {
		for (Integer[] pair : datas)
			merge(pair[0], pair[1]);
	}

	private static void merge(int leftIndex, int rightIndex) {
		int leftFather = getFather(leftIndex);
		int rightFather = getFather(rightIndex);
		if (leftFather != rightFather)
			array[rightFather] = leftFather;
	}

	private static int getFather(int index) {
		if (array[index] == index)
			return index;
		else {
			// update all the value to the last return value
			array[index] = getFather(array[index]);
			return array[index];
		}
	}

	// must do count to update last time
	private static int count() {
		int result = 0;
		for (int i = 1; i < array.length; i++)
			if (getFather(i) == i)
				result++;
		return result;
	}

	public static void main(String[] args) {
		initArray();
		initDatas();
		union();
		int count = count();
		print(count);
	}

	private static List<Integer[]> datas = new ArrayList<Integer[]>();
	private static int[] array = new int[10];

	private static void initArray() {
		for (int i = 0; i < 10; i++)
			array[i] = i;
	}

	private static void initDatas() {
		datas.add(new Integer[] { 1, 2 });
		datas.add(new Integer[] { 3, 4 });
		datas.add(new Integer[] { 5, 2 });
		datas.add(new Integer[] { 4, 6 });
		datas.add(new Integer[] { 2, 6 });
		datas.add(new Integer[] { 8, 7 });
		datas.add(new Integer[] { 9, 7 });
		datas.add(new Integer[] { 1, 6 });
		datas.add(new Integer[] { 2, 4 });
	}

	private static void print(int count) {
		System.out.println("Group Count: " + count);
		for (int i = 1; i < array.length; i++)
			System.out.print(i + " ");
	}

}