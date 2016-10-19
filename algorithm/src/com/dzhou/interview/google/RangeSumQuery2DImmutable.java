package com.dzhou.interview.google;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2,
 * col2).
 * 
 * Example: <br>
 * Given matrix = [<br>
 * --[3, 0, 1, 4, 2],<br>
 * --[5, 6, 3, 2, 1],<br>
 * --[1, 2, 0, 1, 5],<br>
 * --[4, 1, 0, 1, 7],<br>
 * --[1, 0, 3, 0, 5]<br>
 * ]<br>
 * 
 * sumRegion(2, 1, 4, 3) -> 8<br>
 * sumRegion(1, 1, 2, 2) -> 11<br>
 * sumRegion(1, 2, 2, 4) -> 12<br>
 * 
 * Note:<br>
 * You may assume that the matrix does not change.<br>
 * There are many calls to sumRegion function.<br>
 * You may assume that row1 ≤ row2 and col1 ≤ col2.<br>
 * 
 * @author zhoudong
 *
 */
public class RangeSumQuery2DImmutable {

	public class NumMatrix {

		int[][] dpTable = null;

		public NumMatrix(int[][] matrix) {
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
				return;
			}
			dpTable = new int[matrix.length][matrix[0].length];
			for (int row = 0; row < matrix.length; row++) {
				dpTable[row] = createDpRow(matrix[row]);
			}
		}

		private int[] createDpRow(int[] row) {
			int[] dp = new int[row.length];
			dp[0] = row[0];
			for (int i = 1; i < row.length; i++) {
				dp[i] = dp[i - 1] + row[i];
			}
			return dp;
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			if (!isValid(row1, col1, row2, col2))
				return -1;
			int sum = 0;
			for (int row = row1; row <= row2; row++)
				sum += sumOneRow(dpTable[row], col1, col2);
			return sum;
		}

		private int sumOneRow(int[] row, int col1, int col2) {
			int lower = col1 == 0 ? 0 : row[col1 - 1];
			int upper = row[col2];
			return upper - lower;
		}

		private boolean isValid(int row1, int col1, int row2, int col2) {
			return row1 >= 0 && col1 >= 0 && row2 < dpTable.length && col2 < dpTable[0].length && row1 <= row2
					&& col1 <= col2;
		}
	}
}
