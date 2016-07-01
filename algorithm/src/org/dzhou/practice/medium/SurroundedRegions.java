package org.dzhou.practice.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by
 * 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * For example,
 * 
 * X X X X<br>
 * X O O X<br>
 * X X O X<br>
 * X O X X<br>
 * 
 * After running your function, the board should be:
 * 
 * X X X X<br>
 * X X X X<br>
 * X X X X<br>
 * X O X X<br>
 * 
 * @author zhoudong
 *
 *         reference: http://blog.csdn.net/linhuanmars/article/details/22904855
 * 
 *         1.对上下左右边缘做Flood Fill算法，把所有边缘上的'O'都替换成另一个字符，比如'#'。
 * 
 *         2.接下来我们知道除去被我们换成'#'的那些顶点，剩下的所有'O'都应该被替换成'X'，而'#'那些最终应该是还原成'O'，
 *         如此我们可以做最后一次遍历，然后做相应的字符替换就可以了。
 */
public class SurroundedRegions {

	public class Solution {

		private int len = 0;

		public void solve(char[][] board) {
			if (board == null || board.length == 0 || board[0].length == 0)
				return;
			len = board[0].length;
			// 第一行和最后一行进行(Flood Fill)
			for (int j = 0; j < board[0].length; j++) {
				fill(board, 0, j);
				fill(board, board.length - 1, j);
			}
			// 第一列和最后一列进行(Flood Fill)
			for (int i = 0; i < board.length; i++) {
				fill(board, i, 0);
				fill(board, i, board[0].length - 1);
			}
			// 对于当前格子中，所有O变成X说明符合要求，没有被变成#),所有#变成O
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == 'O')
						board[i][j] = 'X';
					else if (board[i][j] == '#')
						board[i][j] = 'O';
				}
			}
		}

		private void fill(char[][] board, int i, int j) {
			if (board[i][j] != 'O')
				return;
			Queue<Integer> queue = new LinkedList<>();
			setTempAddToQueue(board, queue, i, j);
			while (!queue.isEmpty()) {
				int code = queue.poll();
				int row = getRow(code);
				int col = getCol(code);
				if (row >= 1 && board[row - 1][col] == 'O') // 当前元素上边是否为0
					setTempAddToQueue(board, queue, row - 1, col);
				if (row < board.length - 1 && board[row + 1][col] == 'O') // 当前元素下面是否为0
					setTempAddToQueue(board, queue, row + 1, col);
				if (col >= 1 && board[row][col - 1] == 'O') // 当前元素左边是否为0
					setTempAddToQueue(board, queue, row, col - 1);
				if (col <= board[0].length - 2 && board[row][col + 1] == 'O') // 当前元素右边是否为0
					setTempAddToQueue(board, queue, row, col + 1);
			}

		}

		private void setTempAddToQueue(char[][] board, Queue<Integer> queue, int i, int j) {
			setTemp(board, i, j);
			addQueue(queue, i, j);
		}

		private void addQueue(Queue<Integer> queue, int i, int j) {
			queue.add(codeIndex(i, j));
		}

		// set board[i][j] = '#'
		private void setTemp(char[][] board, int i, int j) {
			board[i][j] = '#';
		}

		// 将矩阵的横纵坐标编码
		private int codeIndex(int i, int j) {
			return i * len + j;
		}

		// decode row index
		private int getRow(int code) {
			return code / len;
		}

		// decode column index
		private int getCol(int code) {
			return code % len;
		}

	}

}
