package org.dzhou.research.algorithm.graph;

/**
 * @author DONG ZHOU
 */
public class CityMapDepthFirst {

	private int max = Integer.MAX_VALUE;
	private int[] row0 = { 0, 2, max, max, 10 };
	private int[] row1 = { max, 0, 3, max, 7 };
	private int[] row2 = { 4, max, 0, 4, max };
	private int[] row3 = { max, max, max, 0, 5 };
	private int[] row4 = { max, max, 3, max, 0 };
	private int[][] map = { row0, row1, row2, row3, row4 };
	private int[] book = { 0, 0, 0, 0, 0 };

	private int aim = 0;

	public CityMapDepthFirst(int aim) {
		this.aim = aim;
	}

	public void execute(int current, int distance) {
		if (current == aim) {
			if (distance < min)
				min = distance;
			return;
		}
		for (int i = 0; i < map.length; i++) {
			if (isBooked(i))
				continue;
			if (isSelf(current, i)) {
				book(current);
				continue;
			}
			if (isInvalid(current, i))
				continue;
			book(i);
			execute(i, distance + map[current][i]);
			unbook(i);
		}
	}

	private int min = Integer.MAX_VALUE;

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

	private void unbook(int input) {
		book[input] = 0;
	}

	public static void main(String[] args) {
		CityMapDepthFirst instance = new CityMapDepthFirst(4);
		instance.execute(0, 0);
		System.out.println(instance.min);
	}

}