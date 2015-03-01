package org.dzhou.research.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DONG ZHOU
 */
public class SearchPointBreadthFirst {

	public Queue<Note> queue = new LinkedList<>();

	public class Note {

		int row;
		int col;
		int step;

		public Note(int row, int col, int step) {
			this.row = row;
			this.col = col;
			this.step = step;
		}

	}

	private int[] row0 = { 0, 0, 1, 0 };
	private int[] row1 = { 0, 0, 0, 0 };
	private int[] row2 = { 0, 0, 1, 0 };
	private int[] row3 = { 0, 1, 0, 0 };
	private int[] row4 = { 0, 0, 0, 1 };

	private int[][] map = { row0, row1, row2, row3, row4 };

	private int rows;
	private int cols;

	public SearchPointBreadthFirst() {
		rows = map.length;
		cols = map[0].length;
		initBook();
	}

	private int[][] book;

	private void initBook() {
		book = new int[rows][];
		for (int i = 0; i < map.length; i++)
			book[i] = map[i].clone();
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				book[i][j] = 0;
	}

	private final int[][] next = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public void execute() {
		queue.add(new Note(0, 0, 0));
		book(0, 0);
		while (queue.isEmpty() == false) {
			for (int i = 0; i < next.length; i++) {
				Note note = queue.peek();
				int nextRow = note.row + next[i][0];
				int nextCol = note.col + next[i][1];
				if (isOutOfMap(nextRow, nextCol))
					continue;
				if (isBooked(nextRow, nextCol))
					continue;
				if (isBarrier(nextRow, nextCol))
					continue;
				book(nextRow, nextCol);
				queue.add(new Note(nextRow, nextCol, note.step + 1));
				if (isArrived(nextRow, nextCol)) {
					arrived = true;
					break;
				}
			}
			if (arrived)
				break;
			queue.remove();
		}

	}

	private boolean arrived = false;

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

	private boolean isBarrier(int nextRow, int nextCol) {
		return map[nextRow][nextCol] == 1;
	}

	private int[] aim = { 3, 2 };

	private boolean isArrived(int rowIndex, int colIndex) {
		return rowIndex == aim[0] && colIndex == aim[1];
	}

	public static void main(String[] args) {
		SearchPointBreadthFirst instance = new SearchPointBreadthFirst();
		instance.execute();
		for (Note note : instance.queue)
			System.out.println(note.step);
	}

}