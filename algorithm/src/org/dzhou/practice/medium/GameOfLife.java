package org.dzhou.practice.medium;

/**
 * 
 * @author zhoudong
 *
 */
public class GameOfLife {

	public class Solution {

		int[][] dir = { { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };

		public void gameOfLife(int[][] board) {

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					int live = 0;
					for (int[] d : dir) {
						if (d[0] + i < 0 || d[0] + i >= board.length || d[1] + j < 0 || d[1] + j >= board[0].length)
							continue;
						if (board[d[0] + i][d[1] + j] == 1 || board[d[0] + i][d[1] + j] == 2)
							live++;
					}
					if (board[i][j] == 0 && live == 3)
						board[i][j] = 3;
					if (board[i][j] == 1 && (live < 2 || live > 3))
						board[i][j] = 2;
				}
			}

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					board[i][j] %= 2;
				}
			}

		}

	}
}
