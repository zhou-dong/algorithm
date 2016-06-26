package org.dzhou.practice.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 * 
 * [<br>
 * [ 1, 2, 3 ],<br>
 * [ 4, 5, 6 ],<br>
 * [ 7, 8, 9 ]<br>
 * ]<br>
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * @author zhoudong
 *
 */
public class SpiralMatrix {

	public class Solution {

		public List<Integer> spiralOrder(int[][] matrix) {

			if (matrix == null || matrix.length == 0)
				return Collections.emptyList();

			List<Integer> result = new LinkedList<>();

			int row = matrix.length, col = matrix[0].length;
			int x = 0, y = 0;

			while (row > 0 && col > 0) {

				if (row == 1) {// only one row
					for (int i = 0; i < col; i++)
						result.add(matrix[x][y++]);
					return result;
				} else if (col == 1) {// only one column
					for (int i = 0; i < row; i++)
						result.add(matrix[x++][y]);
					return result;
				}

				// top (left --> right)
				for (int i = 0; i < col - 1; i++)
					result.add(matrix[x][y++]);

				// right (up --> down)
				for (int i = 0; i < row - 1; i++)
					result.add(matrix[x++][y]);

				// bottom (right --> left)
				for (int i = 0; i < col - 1; i++)
					result.add(matrix[x][y--]);

				// left (down --> up)
				for (int i = 0; i < row - 1; i++)
					result.add(matrix[x--][y]);

				x++;
				y++;
				row -= 2;
				col -= 2;
			}
			return result;
		}

	}
}
