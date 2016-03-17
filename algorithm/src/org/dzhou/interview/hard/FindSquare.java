package org.dzhou.interview.hard;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class FindSquare {

	class Subsquare {
		int row;
		int col;
		int size;

		public Subsquare(int row, int col, int size) {
			this.row = row;
			this.col = col;
			this.size = size;
		}
	}

	Subsquare findSquare(int[][] matrix) {
		for (int i = matrix.length; i >= 1; i--) {
			Subsquare subsquare = findSquareWithSize(matrix, i);
			if (subsquare != null) {
				return subsquare;
			}
		}
		return null;
	}

	Subsquare findSquareWithSize(int[][] matrix, int squareSize) {
		int count = matrix.length - squareSize + 1;
		for (int row = 0; row < count; row++) {
			for (int col = 0; col < count; col++) {
				if (isSquare(matrix, row, col, squareSize)) {
					return new Subsquare(row, col, squareSize);
				}
			}
		}
		return null;
	}

	boolean isSquare(int[][] matrix, int row, int col, int size) {
		// 检查上边界和下边界
		for (int j = 0; j < size; j++) {
			if (matrix[row][col + j] == 1) {
				return false;
			}
			if (matrix[row + size - 1][col + j] == 1) {
				return false;
			}
		}
		// 检查左边界和右边界
		for (int i = 1; i < size - 1; i++) {
			if (matrix[row + i][col] == 1) {
				return false;
			}
			if (matrix[row + i][col + size - 1] == 1) {
				return false;
			}
		}
		return true;
	}

}
