package org.dzhou.practice.medium;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * For example, Given n = 3,
 * 
 * You should return the following matrix:
 * 
 * [<br>
 * [ 1, 2, 3 ],<br>
 * [ 8, 9, 4 ],<br>
 * [ 7, 6, 5 ]<br>
 * ]
 * 
 * @author zhoudong
 *
 * 
 *         REFERENCE: http://www.cnblogs.com/springfor/p/3887900.html
 *
 *         这道题跟Spiral Matrix想法也是类似的，就是依照矩阵从外圈到内圈建立。
 * 
 *         要考虑如果是奇数行列的话，最中心的那个点要单加。
 * 
 */
public class SpiralMatrixII {

	public class Solution {

		public int[][] generateMatrix(int n) {

			int[][] res = new int[n][n];
			int k = 1;

			int top = 0, bottom = n - 1, left = 0, right = n - 1;
			while (left < right && top < bottom) {
				for (int j = left; j < right; j++) {
					res[top][j] = k++;
				}
				for (int i = top; i < bottom; i++) {
					res[i][right] = k++;
				}
				for (int j = right; j > left; j--) {
					res[bottom][j] = k++;
				}
				for (int i = bottom; i > top; i--) {
					res[i][left] = k++;
				}
				left++;
				right--;
				top++;
				bottom--;
			}

			if (n % 2 != 0)
				res[n / 2][n / 2] = k;

			return res;

		}

	}

}
