package org.dzhou.interview.recursiondynamicprogramming;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         Write an algorithm to print all ways of arranging eight queens on an
 *         8x8 chess board so that none of them share the same row, column or
 *         diagonal. In this case, "diagonal" means all diagonals, not just the
 *         two that bisect the board.
 */
public class EightQueens {

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
