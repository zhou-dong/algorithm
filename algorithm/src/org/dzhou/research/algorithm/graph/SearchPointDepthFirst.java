package org.dzhou.research.algorithm.graph;

public class SearchPointDepthFirst {

	private int[] row0 = { 0, 0, 1, 0 };
	private int[] row1 = { 0, 0, 0, 0 };
	private int[] row2 = { 0, 0, 1, 0 };
	private int[] row3 = { 0, 1, 0, 0 };
	private int[] row4 = { 0, 0, 0, 1 };

	private int[][] map = { row0, row1, row2, row3, row4 };

	public SearchPointDepthFirst() {
		row = map.length;
		col = map[0].length;
		initBook();
	}

	private int[][] book;

	private void initBook() {
		book = new int[row][];
		for (int i = 0; i < map.length; i++)
			book[i] = map[i].clone();
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				book[i][j] = 0;
	}

	private final int[][] next = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public void execute(int rowIndex, int colIndex, int step) {
		if (isArrived(rowIndex, colIndex)) {
			updateMin(step);
			return;
		}
		for (int i = 0; i < next.length; i++) {
			int nextRow = rowIndex + next[i][0];
			int nextCol = colIndex + next[i][1];
			if (isOutOfMap(nextRow, nextCol))
				continue;
			if (isBarrier(nextRow, nextCol))
				continue;
			if (isBooked(nextRow, nextCol))
				continue;
			book(nextRow, nextCol);
			execute(nextRow, nextCol, step + 1);
			unbook(nextRow, nextCol);
		}
	}

	private int[] aim = { 3, 2 };

	private boolean isArrived(int rowIndex, int colIndex) {
		return rowIndex == aim[0] && colIndex == aim[1];
	}

	public int min = Integer.MAX_VALUE;

	private void updateMin(int step) {
		if (step < min)
			min = step;
	}

	private int row;
	private int col;

	private boolean isOutOfMap(int nextRow, int nextCol) {
		return nextRow < 0 || nextRow > row - 1 || nextCol < 0
				|| nextCol > col - 1;
	}

	private boolean isBooked(int nextRow, int nextCol) {
		return book[nextRow][nextCol] == 1;
	}

	private boolean isBarrier(int nextRow, int nextCol) {
		return map[nextRow][nextCol] == 1;
	}

	private void book(int nextRow, int nextCol) {
		book[nextRow][nextCol] = 1;
	}

	private void unbook(int nextRow, int nextCol) {
		book[nextRow][nextCol] = 0;
	}

	public static void main(String[] args) {
		SearchPointDepthFirst instance = new SearchPointDepthFirst();
		instance.execute(0, 0, 0);
		System.out.println(instance.min);
	}

}