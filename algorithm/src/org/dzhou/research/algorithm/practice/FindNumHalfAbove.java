package org.dzhou.research.algorithm.practice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 已知一个集合中一个数出现次数超过50%，找出这个数
 * 
 * @author DONG ZHOU
 */
public class FindNumHalfAbove {

	private Integer[] array = { 1, 5, 6, 5, 2, 5, 8, 5, 5, 6, 0, 8, 5, 5, 5 };
	private List<Integer> list = new LinkedList<>(Arrays.asList(array));

	public void execute() {
		int first = 0;
		int second = list.get(1);
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			first = iterator.next();
			if (first != second)
				iterator.remove();
			second = first;
		}
	}

	public void display() {
		for (int i : list)
			System.out.print(i + " ");
	}

	public static void main(String[] args) {
		FindNumHalfAbove instance = new FindNumHalfAbove();
		instance.execute();
		instance.display();
	}

}