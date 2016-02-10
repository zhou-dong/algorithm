package org.dzhou.interview.recursiondynamicprogramming;

import java.util.List;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         Write an algorithm to print all ways of arranging eight queens on an
 *         8x8 chess board so that none of them share the same row, column or
 *         diagonal. In this case, "diagonal" means all diagonals, not just the
 *         two that bisect the board.
 * 
 *         Observe that since each row can only have one queen, we don't need to
 *         store our board as full 8x8 matrix. We only need a single array where
 *         column[r]=c indicates that row r has a queen at column c.
 */
public class EightQueens {

	int GRID_SIZE = 8;

	public void placeQueens(int row, Integer[] columns, List<Integer[]> results) {
		if (row == GRID_SIZE) {
			results.add(columns.clone());
		} else {
			for (int col = 0; col < GRID_SIZE; col++) {
				if (checkValid(columns, row, col)) {
					columns[row] = col;
					placeQueens(row + 1, columns, results);
				}
			}
		}
	}

	private boolean checkValid(Integer[] columns, int row1, int column1) {
		for (int row2 = 0; row2 < row1; row2++) {
			int column2 = columns[row2];
			if (column1 == column2) {
				return false;
			}
			int columnDistance = Math.abs(column2 - column1);
			int rowDistance = row1 - row2;
			if (columnDistance == rowDistance) {
				return false;
			}
		}
		return true;
	}

}
