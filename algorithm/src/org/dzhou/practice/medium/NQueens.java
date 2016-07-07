package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * For example, There exist two distinct solutions to the 4-queens puzzle:
 * 
 * // Solution 1
 * 
 * [<br>
 * [".Q..", <br>
 * "...Q",<br>
 * "Q...",<br>
 * "..Q."],<br>
 * 
 * // Solution 2<br>
 * ["..Q.", <br>
 * "Q...",<br>
 * "...Q",<br>
 * ".Q.."]<br>
 * ]<br>
 * 
 * @author zhoudong
 *
 *         用一个一维数组来表示二维棋盘上皇后的位置。一维数组中每一个值的下标代表着对应棋盘的列，每一个值则是那一列中皇后所在的行。
 */
public class NQueens {

	public static void main(String[] args) {
		NQueens instance = new NQueens();
		instance.test();
	}

	private void test() {
		Solution s = new Solution();
		System.out.println(s.solveNQueens(5));
	}

	enum Role {
		QUEUE("Q"), OTHER(".");

		String sign;

		Role(String sign) {
			this.sign = sign;
		}
	}

	public class Solution {

		public List<List<String>> solveNQueens(int n) {
			if (n < 1)
				return Collections.emptyList();
			List<List<String>> result = new ArrayList<>();
			if (n == 1) {
				List<String> item = new ArrayList<>();
				item.add("Q");
				result.add(item);
				return result;
			}

			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {
					Role[][] chessboard = createChessboard(n);
					chessboard[x][y] = Role.QUEUE;
					helper(result, chessboard, 0, 0);
				}
			}
			return result;
		}

		private Role[][] createChessboard(int n) {
			Role[][] chessboard = new Role[n][n];
			for (Role[] row : chessboard)
				Arrays.fill(row, Role.OTHER);
			return chessboard;
		}

		private void showBoard(Role[][] board) {
			for (Role[] row : board) {
				for (Role role : row) {
					System.out.print(role.sign);
				}
				System.out.println();
			}
			System.out.println("------------------------");
		}

		private void helper(List<List<String>> result, Role[][] chessboard, int i, int j) {
			showBoard(chessboard);
			if (j == chessboard[0].length)
				return;
			if (i == chessboard.length) {
				List<String> board = drawChessboard(chessboard);
				if (board != null)
					result.add(board);
				return;
			}

			if (!isValid(chessboard, i, j))
				return;

			chessboard[i][j] = Role.QUEUE;
			helper(result, chessboard, i, j + 1);
			helper(result, chessboard, i + 1, 0);
			chessboard[i][j] = Role.OTHER;

		}

		Set<String> set = new HashSet<>();

		private List<String> drawChessboard(Role[][] chessboard) {
			StringBuilder sb = new StringBuilder();
			List<String> result = new ArrayList<>();
			for (int i = 0; i < chessboard.length; i++) {
				StringBuilder temp = new StringBuilder();
				boolean atLeastOne = false;
				for (int j = 0; j < chessboard[0].length; j++) {
					if (chessboard[i][j] == Role.QUEUE)
						atLeastOne = true;
					temp.append(chessboard[i][j].sign);
				}
				if (atLeastOne == false)
					return null;
				sb.append(temp.toString());
				result.add(temp.toString());
			}

			if (set.contains(sb.toString()))
				return null;
			set.add(sb.toString());
			return result;
		}

		private boolean isValid(Role[][] chessboard, int i, int j) {
			// check row
			for (int y = 0; y < chessboard[0].length; y++) {
				if (chessboard[i][y] == Role.QUEUE)
					return false;
			}
			// check column
			for (int x = 0; x < chessboard.length; x++) {
				if (chessboard[x][j] == Role.QUEUE)
					return false;
			}
			// check left-top to right-bottom
			int x = i, y = j;
			while (x < chessboard.length && y < chessboard[0].length) {
				if (chessboard[x++][y++] == Role.QUEUE)
					return false;
			}

			// check right-bottom to left-top
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
			while (x >= 0 && y < chessboard.length) {
				if (chessboard[x--][y++] == Role.QUEUE)
					return false;
			}
			return true;
		}

	}

}
