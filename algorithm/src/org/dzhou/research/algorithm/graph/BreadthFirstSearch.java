package org.dzhou.research.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DONG ZHOU
 */
public class BreadthFirstSearch {

	private Queue<Integer> queue = new LinkedList<>();

	private int max = Integer.MAX_VALUE;
	private int[] row0 = { 0, 1, 1, max, 1 };
	private int[] row1 = { 1, 0, max, 1, max };
	private int[] row2 = { 1, max, 0, max, 1 };
	private int[] row3 = { max, 1, max, 0, max };
	private int[] row4 = { 1, max, 1, max, 0 };
	private int[][] map = { row0, row1, row2, row3, row4 };
	private int[] book = { 0, 0, 0, 0, 0 };

	public void execute() {
		queue.add(0);
		book[0] = 1;
		while (queue.isEmpty() == false) {
			System.out.print(queue.peek() + 1 + " ");
			for (int i = 0; i < map.length; i++) {
				int current = queue.peek();
				if (isSelf(current, i))
					continue;
				if (isBooked(i))
					continue;
				if (isInvalid(current, i))
					continue;
				book(i);
				queue.add(i);
			}
			queue.remove();
		}
	}

	private boolean isBooked(int input) {
		return book[input] == 1;
	}

	private boolean isSelf(int nextRow, int nextCol) {
		return map[nextRow][nextCol] == 0;
	}

	private boolean isInvalid(int nextRow, int nextCol) {
		return map[nextRow][nextCol] == max;
	}

	private void book(int input) {
		book[input] = 1;
	}

	public static void main(String[] args) {
		BreadthFirstSearch instance = new BreadthFirstSearch();
		instance.execute();
	}

}