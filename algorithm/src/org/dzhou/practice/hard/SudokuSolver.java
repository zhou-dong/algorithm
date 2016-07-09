package org.dzhou.practice.hard;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 * 
 * @author zhoudong
 *
 */
public class SudokuSolver {

	public class Solution {

		public void solveSudoku(char[][] board) {
			if (board == null || board.length == 0)
				return;
			helper(board);
		}

		private boolean helper(char[][] board) {

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] != '.')
						continue;
					for (char c = '1'; c <= '9'; c++) {
						if (!isValid(board, i, j, c))
							continue;
						board[i][j] = c;
						if (helper(board))
							return true;
						board[i][j] = '.';
					}
					return false;
				}
			}

			return true;
		}

		private boolean isValid(char[][] board, int i, int j, char val) {
			// check row
			for (int y = 0; y < board[0].length; y++) {
				if (board[i][y] == val)
					return false;
			}
			// check column
			for (int x = 0; x < board[0].length; x++) {
				if (board[x][j] == val)
					return false;
			}
			// check grid
			int rowStart = (i / 3) * 3, colStart = (j / 3) * 3;
			int rowEnd = rowStart + 3, colEnd = colStart + 3;
			for (int row = rowStart; row < rowEnd; row++) {
				for (int col = colStart; col < colEnd; col++) {
					if (board[row][col] == val)
						return false;
				}
			}
			return true;
		}

	}

}
