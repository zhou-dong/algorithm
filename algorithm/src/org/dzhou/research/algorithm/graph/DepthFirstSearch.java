package org.dzhou.research.algorithm.graph;

/**
 * @author DONG ZHOU
 */
public class DepthFirstSearch {

	private int max = Integer.MAX_VALUE;
	private int[] row0 = { 0, 1, 1, max, 1 };
	private int[] row1 = { 1, 0, max, 1, max };
	private int[] row2 = { 1, max, 0, max, 1 };
	private int[] row3 = { max, 1, max, 0, max };
	private int[] row4 = { 1, max, 1, max, 0 };
	private int[][] map = { row0, row1, row2, row3, row4 };
	private int[] book = { 0, 0, 0, 0, 0 };

	private int count = 0;

	public void execute(int cur) {
		if (count == map.length)
			return;
		count++;
		System.out.print((cur + 1) + " ");
		for (int i = 0; i < map.length; i++) {
			if (isBooked(i))
				continue;
			if (isSelf(cur, i)) {
				book(cur);
				continue;
			}
			if (isInvalid(cur, i))
				continue;
			book(cur);
			execute(i);
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
		DepthFirstSearch instance = new DepthFirstSearch();
		instance.execute(0);
	}

}