package org.dzhou.interview.moderate;

import java.util.HashMap;
import java.util.Map;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class OXO {

	public enum Piece {
		EMPTY;
	}

	public static Map<Integer, Boolean> recordMap = new HashMap<>();

	// 解法1
	public static boolean hasWon(int board) {
		return recordMap.get(board);
	}

	public static int convertBoardToInt(char[][] board) {
		int factor = 1;
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int v = 0;
				if (board[i][j] == 'x') {
					v = 1;
				} else if (board[i][j] == 'o') {
					v = 2;
				}
				sum += v * factor;
				factor *= 3;
			}
		}
		return sum;
	}

	// 解法2 (For 3x3 board)
	public static Piece hasWon1(Piece[][] board) {

		for (int i = 0; i < board.length; i++) {
			// 检查行
			if (board[i][0] != Piece.EMPTY && board[i][0] == board[i][1]
					&& board[i][0] == board[i][2]) {
				return board[i][0];
			}
			// 检查列
			if (board[0][i] != Piece.EMPTY && board[0][i] == board[1][i]
					&& board[0][i] == board[2][i]) {
				return board[0][i];
			}
		}

		// 检查对角戏
		if (board[0][0] != Piece.EMPTY && board[0][0] == board[1][1]
				&& board[0][0] == board[2][2]) {
			return board[0][0];
		}

		// 检查逆对角线
		if (board[2][0] != Piece.EMPTY && board[2][0] == board[1][1]
				&& board[2][0] == board[0][2]) {
			return board[2][0];
		}

		return Piece.EMPTY;
	}

	// 解法3 (For NxN board)
	public static Piece hasWon2(Piece[][] board) {
		int N = board.length;
		int row = 0;
		int col = 0;

		// 检查行
		for (row = 0; row < N; row++) {
			if (board[row][0] == Piece.EMPTY) {
				continue;
			}
			for (col = 1; col < N; col++) {
				if (board[row][col] != board[row][col - 1]) {
					break;
				}
			}
			if (col == N) {
				return board[row][0];
			}
		}

		// 检查列
		for (col = 0; col < N; col++) {
			if (board[0][col] == Piece.EMPTY) {
				continue;
			}
			for (row = 1; row < N; row++) {
				if (board[row][col] != board[row - 1][col]) {
					break;
				}
			}
			if (row == N) {
				return board[0][col];
			}
		}

		// 检查对角戏
		if (board[0][0] != Piece.EMPTY) {
			for (row = 1; row < N; row++) {
				if (board[row][row] != board[row - 1][row - 1]) {
					break;
				}
			}
			if (row == N) {
				return board[0][0];
			}
		}

		// 检查逆对角线
		if (board[N - 1][0] != Piece.EMPTY) {
			for (row = 1; row < N; row++) {
				if (board[N - 1][0] != board[N - row][row - 1]) {
					break;
				}
			}
			if (row == N) {
				return board[N - 1][0];
			}
		}

		return Piece.EMPTY;
	}

}
