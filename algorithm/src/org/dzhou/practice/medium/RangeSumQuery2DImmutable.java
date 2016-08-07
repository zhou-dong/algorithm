package org.dzhou.practice.medium;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2,
 * col2).
 * 
 * Range Sum Query 2D The above rectangle (with the red border) is defined by
 * (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * 
 * Example: <br>
 * Given matrix = [ <br>
 * - [3, 0, 1, 4, 2], <br>
 * - [5, 6, 3, 2, 1], <br>
 * - [1, 2, 0, 1, 5], <br>
 * - [4, 1, 0, 1, 7], <br>
 * - [1, 0, 3, 0, 5] <br>
 * ] <br>
 * 
 * sumRegion(2, 1, 4, 3) -> 8 <br>
 * sumRegion(1, 1, 2, 2) -> 11 <br>
 * sumRegion(1, 2, 2, 4) -> 12 <br>
 * 
 * Note: You may assume that the matrix does not change. <br>
 * There are many calls to sumRegion function. <br>
 * You may assume that row1 ≤ row2 and col1 ≤ col2. <br>
 * 
 * @author zhoudong
 *
 */
public class RangeSumQuery2DImmutable {

	public class NumMatrix {

		int[][] table;

		public NumMatrix(int[][] matrix) {
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
				return;
			table = copyFirstColumn(matrix);
			for (int row = 0; row < matrix.length; row++) {
				for (int col = 1; col < matrix[row].length; col++) {
					table[row][col] = (table[row][col - 1] + matrix[row][col]);
				}
			}
		}

		private int[][] copyFirstColumn(int[][] matrix) {
			int[][] copy = new int[matrix.length][matrix[0].length];
			for (int row = 0; row < matrix.length; row++) {
				copy[row][0] = matrix[row][0];
			}
			return copy;
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			if (table == null || table.length == 0 || table[0].length == 0)
				return 0;
			int result = 0;
			for (int row = row1; row <= row2; row++)
				if (col1 == 0)
					result += table[row][col2];
				else
					result += (table[row][col2] - table[row][col1 - 1]);
			return result;
		}

	}

}
