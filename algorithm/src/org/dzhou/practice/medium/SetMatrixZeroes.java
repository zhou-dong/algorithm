package org.dzhou.practice.medium;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * Follow up:
 * 
 * Did you use extra space?
 * 
 * A straight forward solution using O(mn) space is probably a bad idea.
 * 
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * 
 * Could you devise a constant space solution?
 * 
 * @author zhoudong
 *
 *         reference:
 *         http://fisherlei.blogspot.com/2013/01/leetcode-set-matrix-zeroes.html
 *
 *         非常无聊的一道题。解题点就在于清空标志位存在哪里的问题。可以创建O(m+n)的数组来存储，但此题是希望复用已有资源。
 *         这里可以选择第一行和第一列来存储标志位。
 * 
 *         1.先确定第一行和第一列是否需要清零
 * 
 *         2.扫描剩下的矩阵元素，如果遇到了0，就将对应的第一行和第一列上的元素赋值为0
 * 
 *         3.根据第一行和第一列的信息，已经可以讲剩下的矩阵元素赋值为结果所需的值了
 * 
 *         4.根据1中确定的状态，处理第一行和第一列。
 */
public class SetMatrixZeroes {

	public class Solution {

		public void setZeroes(int[][] matrix) {
			if (matrix == null || matrix.length == 0)
				return;

			boolean empty_row0 = rowContainsZero(matrix[0]);
			boolean empty_col0 = colContainsZero(matrix, 0);

			for (int i = 1; i < matrix.length; i++) {
				for (int j = 1; j < matrix[0].length; j++) {
					if (matrix[i][j] == 0) {
						matrix[0][j] = 0;
						matrix[i][0] = 0;
					}
				}
			}

			for (int i = 1; i < matrix.length; i++) {
				for (int j = 1; j < matrix[0].length; j++) {
					if (matrix[0][j] == 0 || matrix[i][0] == 0)
						matrix[i][j] = 0;
				}
			}
			if (empty_row0)
				emptyRow(matrix, 0);

			if (empty_col0)
				emptyCol(matrix, 0);
		}

		private boolean rowContainsZero(int[] row) {
			for (int x : row) {
				if (x == 0)
					return true;
			}
			return false;
		}

		private boolean colContainsZero(int[][] matrix, int j) {
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[i][j] == 0)
					return true;
			}
			return false;
		}

		private void emptyRow(int[][] matrix, int i) {
			for (int j = 0; j < matrix[0].length; j++)
				matrix[i][j] = 0;
		}

		private void emptyCol(int[][] matrix, int j) {
			for (int i = 0; i < matrix.length; i++)
				matrix[i][j] = 0;
		}

	}

}
