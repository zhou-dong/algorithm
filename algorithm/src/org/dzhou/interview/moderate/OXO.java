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

	public static Map<Integer, Boolean> recordMap = new HashMap<>();

	// 解法1
	public boolean hasWon(int board) {
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

	// 解法2

	// 解法3

}
