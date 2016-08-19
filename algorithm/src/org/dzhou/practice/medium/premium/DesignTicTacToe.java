package org.dzhou.practice.medium.premium;

/**
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 * 
 * You may assume the following rules:
 * 
 * 1.A move is guaranteed to be valid and is placed on an empty block.
 * 
 * 2.Once a winning condition is reached, no more moves is allowed.
 * 
 * 3.A player who succeeds in placing n of their marks in a horizontal,
 * vertical, or diagonal row wins the game.
 * 
 * Follow up:
 * 
 * Could you do better than O(n2) per move() operation?
 * 
 * Hint:
 * 
 * 1.Could you trade extra space such that move() operation can be done in O(1)?
 * 
 * 2.You need two arrays: int rows[n], int cols[n], plus two variables:
 * diagonal, anti_diagonal.
 * 
 * @author zhoudong
 * 
 */
public class DesignTicTacToe {

	public class TicTacToe {

		int[][] board = null;

		/** Initialize your data structure here. */
		public TicTacToe(int n) {
			board = new int[n][n];
		}

		/**
		 * Player {player} makes a move at ({row}, {col}).
		 * 
		 * @param row
		 *            The row of the board.
		 * @param col
		 *            The column of the board.
		 * @param player
		 *            The player, can be either 1 or 2.
		 * @return The current winning condition, can be either: <br>
		 *         0: No one wins. <br>
		 *         1: Player 1 wins. <br>
		 *         2: Player 2 wins. <br>
		 */
		public int move(int row, int col, int player) {
			if (!isValidLocation(row, col) || board[row][col] != 0)
				return 0;
			board[row][col] = player;
			return (checkRow(row, col, player) || checkCol(row, col, player) || checkDiagonal(row, col, player)
					|| checkAntiDiagonal(row, col, player)) ? player : 0;
		}

		private boolean checkAntiDiagonal(int row, int col, int player) {
			return (upRightLen(row, col, player) + leftDownLen(row, col, player) + 1) == board.length;
		}

		private int upRightLen(int row, int col, int player) {
			int len = 0;
			while (isSamePlayer(--row, ++col, player))
				len++;
			return len;
		}

		private int leftDownLen(int row, int col, int player) {
			int len = 0;
			while (isSamePlayer(++row, --col, player))
				len++;
			return len;
		}

		private boolean checkDiagonal(int row, int col, int player) {
			return (upLeftLen(row, col, player) + rightDownLen(row, col, player) + 1) == board.length;
		}

		private int upLeftLen(int row, int col, int player) {
			int len = 0;
			while (isSamePlayer(--row, --col, player))
				len++;
			return len;
		}

		private int rightDownLen(int row, int col, int player) {
			int len = 0;
			while (isSamePlayer(++row, ++col, player))
				len++;
			return len;
		}

		private boolean checkCol(int row, int col, int player) {
			return (upLen(row, col, player) + downLen(row, col, player) + 1) == board.length;
		}

		private int upLen(int row, int col, int player) {
			int len = 0;
			while (isSamePlayer(--row, col, player))
				len++;
			return len;
		}

		private int downLen(int row, int col, int player) {
			int len = 0;
			while (isSamePlayer(++row, col, player))
				len++;
			return len;
		}

		private boolean checkRow(int row, int col, int player) {
			return (leftLen(row, col, player) + rightLen(row, col, player) + 1) == board.length;
		}

		private int leftLen(int row, int col, int player) {
			int len = 0;
			while (isSamePlayer(row, --col, player))
				len++;
			return len;
		}

		private int rightLen(int row, int col, int player) {
			int len = 0;
			while (isSamePlayer(row, ++col, player))
				len++;
			return len;
		}

		private boolean isSamePlayer(int row, int col, int player) {
			return isValidLocation(row, col) && board[row][col] == player;
		}

		private boolean isValidLocation(int row, int col) {
			return row >= 0 && col >= 0 && row < board.length && col < board[row].length;
		}
	}

	// Your TicTacToe object will be instantiated and called as such:
	// TicTacToe obj = new TicTacToe(n);
	// int param_1 = obj.move(row,col,player);
}
