package org.dzhou.practice.medium;

/**
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. For example,
 * 
 * Consider the following matrix:
 * 
 * [<br>
 * [1, 3, 5, 7],<br>
 * [10, 11, 16, 20],<br>
 * [23, 30, 34, 50]<br>
 * ]
 * 
 * Given target = 3, return true.
 * 
 * @author zhoudong
 *
 *         1. 将2D矩阵转换成1D，然后利用二分查找法
 *
 *         2. 利用两次二分查找法。先对第一列进行二分查找，锁定该元素所在行数，然后再对列进行二分查找，
 */
public class SearchA2DMatrix {

	// 将2D矩阵转换成1D，然后利用二分查找法
	public class Solution {

		public boolean searchMatrix(int[][] matrix, int target) {

			if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
				return false;

			if (matrix.length == 1 && matrix[0].length == 1)
				return matrix[0][0] == target ? true : false;

			int rows = matrix.length;
			int cols = matrix[0].length;

			int low = 0, high = rows * cols - 1;

			while (low <= high) {
				int mid = (low + high) / 2;
				int val = matrix[mid / cols][mid % cols]; // key idea
				if (val == target)
					return true;
				if (val < target)
					low = mid + 1;
				else
					high = mid - 1;
			}

			return false;
		}

	}

}
