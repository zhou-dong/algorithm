package org.dzhou.practice.hard;

import java.util.Arrays;

/**
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 * 
 * @author zhoudong
 *
 */
public class NQueensII {

	enum Role {
		QUEUE("Q"), OTHER(".");

		String sign;

		Role(String sign) {
			this.sign = sign;
		}
	}

	public class Solution {

		private int count = 0;

		public int totalNQueens(int n) {
			if (n < 0)
				return 0;
			if (n == 1)
				return 1;
			dfs(createChessboard(n), 0);
			return count;
		}

		private Role[][] createChessboard(int n) {
			Role[][] chessboard = new Role[n][n];
			for (Role[] row : chessboard)
				Arrays.fill(row, Role.OTHER);
			return chessboard;
		}

		private void dfs(Role[][] chessboard, int i) {
			if (i == chessboard.length) {
				if (isValidResult(chessboard))
					count++;
				return;
			}
			for (int j = 0; j < chessboard[0].length; j++) {
				if (!isValid(chessboard, i, j))
					continue;
				chessboard[i][j] = Role.QUEUE;
				dfs(chessboard, i + 1);
				chessboard[i][j] = Role.OTHER;
			}
		}

		private boolean isValidResult(Role[][] chessboard) {
			for (int i = 0; i < chessboard.length; i++) {
				boolean containsQueue = false;
				for (int j = 0; j < chessboard[0].length; j++) {
					if (chessboard[i][j] == Role.QUEUE) {
						containsQueue = true;
						break;
					}
				}
				if (containsQueue == false) {
					return false;
				}
			}
			return true;
		}

		private boolean isValid(Role[][] chessboard, int i, int j) {
			// row
			for (int y = 0; y < chessboard[0].length; y++) {
				if (chessboard[i][y] == Role.QUEUE)
					return false;
			}
			// column
			for (int x = 0; x < chessboard.length; x++) {
				if (chessboard[x][j] == Role.QUEUE)
					return false;
			}
			// left-top to right-bottom
			int x = i, y = j;
			while (x < chessboard.length && y < chessboard[0].length) {
				if (chessboard[x++][y++] == Role.QUEUE)
					return false;
			}
			// bottom-right to top-left
			x = i;
			y = j;
			while (x >= 0 && y >= 0) {
				if (chessboard[x--][y--] == Role.QUEUE)
					return false;
			}
			// right-top to left-bottom
			x = i;
			y = j;
			while (x < chessboard.length && y >= 0) {
				if (chessboard[x++][y--] == Role.QUEUE)
					return false;
			}
			// left-bottom to right-top
			x = i;
			y = j;
			while (x >= 0 && y < chessboard[0].length) {
				if (chessboard[x--][y++] == Role.QUEUE)
					return false;
			}
			return true;
		}

	}

}