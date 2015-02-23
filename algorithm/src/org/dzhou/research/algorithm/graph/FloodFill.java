package org.dzhou.research.algorithm.graph;

public class FloodFill {

	private int[] row0 = { 1, 2, 1, 0, 0, 0, 0, 0, 2, 3 };
	private int[] row1 = { 3, 0, 2, 0, 1, 2, 1, 0, 1, 2 };
	private int[] row2 = { 4, 0, 1, 0, 1, 2, 3, 2, 0, 1 };
	private int[] row3 = { 3, 2, 0, 0, 0, 1, 2, 4, 0, 0 };
	private int[] row4 = { 0, 0, 0, 0, 0, 0, 1, 5, 3, 0 };
	private int[] row5 = { 0, 1, 2, 1, 0, 1, 5, 4, 3, 0 };
	private int[] row6 = { 0, 1, 2, 3, 1, 3, 6, 2, 1, 0 };
	private int[] row7 = { 0, 0, 3, 4, 8, 9, 7, 5, 0, 0 };
	private int[] row8 = { 0, 0, 0, 3, 7, 8, 6, 0, 1, 2 };
	private int[] row9 = { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 };

	protected int[][] map = { row0, row1, row2, row3, row4, row5, row6, row7,
			row8, row9 };

	private final int[][] next = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	protected int rows;
	protected int cols;
	private int[][] book;

	private void initBook() {
		book = new int[rows][];
		for (int i = 0; i < map.length; i++)
			book[i] = map[i].clone();
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				book[i][j] = 0;
	}

	public FloodFill() {
		rows = map.length;
		cols = map[0].length;
		initBook();
	}

	public void execute(int row, int col) {
		for (int i = 0; i < next.length; i++) {
			int nextRow = row + next[i][0];
			int nextCol = col + next[i][1];
			if (isOutOfMap(nextRow, nextCol))
				continue;
			if (isInvalid(nextRow, nextCol))
				continue;
			if (isBooked(nextRow, nextCol))
				continue;
			book(nextRow, nextCol);
			shade(nextRow, nextCol);
			execute(nextRow, nextCol);
		}
	}

	public int color = 0;

	private void shade(int nextRow, int nextCol) {
		map[nextRow][nextCol] = color;
	}

	private void book(int nextRow, int nextCol) {
		book[nextRow][nextCol] = 1;
	}

	private boolean isOutOfMap(int nextRow, int nextCol) {
		return nextRow < 0 || nextRow > rows - 1 || nextCol < 0
				|| nextCol > cols - 1;
	}

	private boolean isBooked(int nextRow, int nextCol) {
		return book[nextRow][nextCol] == 1;
	}

	private boolean isInvalid(int nextRow, int nextCol) {
		return map[nextRow][nextCol] == 0;
	}

	public void display() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int val = map[i][j];
				if (val > -1)
					System.out.print("0" + val + " ");
				else
					System.out.print(val + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		FloodFill instance = new FloodFill();
		for (int i = 0; i < instance.rows; i++) {
			for (int j = 0; j < instance.cols; j++) {
				if (instance.map[i][j] > 0) {
					instance.color--;
					instance.execute(i, j);
				}
			}
		}
		instance.display();
	}
}