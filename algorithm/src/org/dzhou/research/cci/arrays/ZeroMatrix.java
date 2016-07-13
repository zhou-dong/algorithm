package org.dzhou.research.cci.arrays;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column are set to 0.
 * 
 * @author zhoudong
 *
 *         用第一排和第一行做来标识要set zero的行和列。
 *
 */
public class ZeroMatrix {

	public class Solution {

		void setZeros(int[][] matrix) {

			boolean rowHasZero = isRowHasZero(matrix, 0);
			boolean colHasZero = isColHasZero(matrix, 0);

			// check for zeros and set to first row and column
			for (int row = 1; row < matrix.length; row++) {
				for (int col = 1; col < matrix[0].length; col++) {
					if (matrix[row][col] == 0) {
						matrix[row][0] = 0;
						matrix[0][col] = 0;
					}
				}
			}

			// Nullify rows based on values in first column
			for (int row = 0; row < matrix.length; row++) {
				if (matrix[row][0] == 0)
					nullifyRow(matrix, row);
			}

			// Nullify columns based on values in first row
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[0][col] == 0)
					nullifyCol(matrix, col);
			}

			// Nullify first row
			if (rowHasZero)
				nullifyRow(matrix, 0);

			// Nullify first column
			if (colHasZero)
				nullifyCol(matrix, 0);

		}

		private boolean isRowHasZero(int[][] matrix, int row) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == 0)
					return true;
			}
			return false;
		}

		private boolean isColHasZero(int[][] matrix, int col) {
			for (int row = 0; row < matrix.length; row++) {
				if (matrix[row][col] == 0)
					return true;
			}
			return false;
		}

		private void nullifyRow(int[][] matrix, int row) {
			for (int col = 0; col < matrix[0].length; col++) {
				matrix[row][col] = 0;
			}
		}

		private void nullifyCol(int[][] matrix, int col) {
			for (int row = 0; row < matrix.length; row++) {
				matrix[row][col] = 0;
			}
		}

	}

}
