package org.dzhou.practice.medium;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted in ascending from left to right. Integers in
 * each column are sorted in ascending from top to bottom. For example,
 * 
 * Consider the following matrix:
 * 
 * [<br>
 * [1, 4, 7, 11, 15],<br>
 * [2, 5, 8, 12, 19],<br>
 * [3, 6, 9, 16, 22],<br>
 * [10, 13, 14, 17, 24],<br>
 * [18, 21, 23, 26, 30]<br>
 * ]<br>
 * 
 * Given target = 5, return true.<br>
 * Given target = 20, return false.<br>
 * 
 * @author zhoudong
 *
 *         O(m + n)<br>
 *         1. 从右上角开始,比较target和matrix[i][j]的值.<br>
 *         --- 如果小于target,则该行不可能有此数,所以i++; <br>
 *         --- 如果大于target,则该列不可能有此数,所以j--. <br>
 *         --- 遇到边界则表明该矩阵不含target.<br>
 * 
 *         T(n) = 3T(n/2) + c<br>
 *         2.分治法，以矩形中点为基准，将矩阵拆分成左上，左下，右上，右下四个区域<br>
 *         若中点值 < 目标值，则舍弃左上区域，从其余三个区域再行查找<br>
 *         若中点值 > 目标值，则舍弃右下区域，从其余三个区域再行查找<br>
 * 
 */
public class SearchA2DMatrixII {

	public class Solution {

		public boolean searchMatrix(int[][] matrix, int target) {
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
				return false;
			int row = 0, col = matrix[0].length - 1;
			while (row < matrix.length && col >= 0) {
				int val = matrix[row][col];
				if (val == target)
					return true;
				if (val > target)
					col--;
				else
					row++;
			}
			return false;
		}

	}

	public class Solution1 {

		public boolean searchMatrix(int[][] matrix, int target) {
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
				return false;
			return helper(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, target);
		}

		boolean helper(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd, int target) {
			if (rowStart > rowEnd || colStart > colEnd) {
				return false;
			}
			int rm = (rowStart + rowEnd) / 2, cm = (colStart + colEnd) / 2;
			if (matrix[rm][cm] == target) {
				return true;
			}
			if (matrix[rm][cm] > target) {// 若中点值 > 目标值，则舍弃右下区域，从其余三个区域再行查找
				return helper(matrix, rowStart, rm - 1, colStart, cm - 1, target)// 左上
						|| helper(matrix, rm, rowEnd, colStart, cm - 1, target)// 右上
						|| helper(matrix, rowStart, rm - 1, cm, colEnd, target);// 左下
			} else {// 若中点值 < 目标值，则舍弃左上区域，从其余三个区域再行查找
				return helper(matrix, rm + 1, rowEnd, cm + 1, colEnd, target)// 右下
						|| helper(matrix, rm + 1, rowEnd, colStart, cm, target)// 右上
						|| helper(matrix, rowStart, rm, cm + 1, colEnd, target);// 左下
			}
		}

	}

}
