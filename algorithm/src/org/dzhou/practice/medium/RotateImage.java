package org.dzhou.practice.medium;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
 * 
 * @author zhoudong
 *
 */
public class RotateImage {

	public class Solution {
		public void rotate(int[][] matrix) {
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
				return;
			}

			int length = matrix.length;

			for (int i = 0; i < length / 2; i++) {
				for (int j = 0; j < (length + 1) / 2; j++) {
					int tmp = matrix[i][j];
					matrix[i][j] = matrix[length - j - 1][i];
					matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
					matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
					matrix[j][length - i - 1] = tmp;
				}
			}
		}
	}

}
