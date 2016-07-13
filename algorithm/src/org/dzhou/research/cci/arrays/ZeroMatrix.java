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
