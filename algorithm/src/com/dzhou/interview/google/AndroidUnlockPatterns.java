package com.dzhou.interview.google;

/**
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤
 * n ≤ 9, count the total number of unlock patterns of the Android lock screen,
 * which consist of minimum of m keys and maximum n keys.
 * 
 * Rules for a valid pattern:
 * 
 * 1.Each pattern must connect at least m keys and at most n keys.
 * 
 * 2.All the keys must be distinct.
 * 
 * 3.If the line connecting two consecutive keys in the pattern passes through
 * any other keys, the other keys must have previously selected in the pattern.
 * No jumps through non selected key is allowed.
 * 
 * 4.The order of keys used matters.
 * 
 * @author zhoudong
 *
 *         | 1 | 2 | 3 | <br>
 *         | 4 | 5 | 6 | <br>
 *         | 7 | 8 | 9 | <br>
 */
public class AndroidUnlockPatterns {

	public int numberOfPatterns(int m, int n) {
		int skip[][] = skipPattern();
		boolean visited[] = new boolean[10];
		int count = 0;
		for (int i = m; i <= n; i++) {
			count += dfs(skip, visited, 1, i - 1) * 4; // 1, 3, 7, 9 symmetric
			count += dfs(skip, visited, 2, i - 1) * 4; // 2, 4, 6, 8 symmetric
			count += dfs(skip, visited, 5, i - 1); // 5
		}
		return count;
	}

	private int dfs(int[][] skip, boolean[] visited, int current, int remain) {
		if (remain < 0)
			return 0;
		if (remain == 0)
			return 1;
		visited[current] = true;
		int result = 0;
		for (int i = 1; i < 10; i++) {
			if (visited[i])
				continue;
			int block = skip[current][i];
			if (block == 0 || visited[block]) {
				result += dfs(skip, visited, i, remain - 1);
			}
		}
		visited[current] = false;
		return result;
	}

	private int[][] skipPattern() {
		int skip[][] = new int[10][10];
		skip[1][3] = skip[3][1] = 2;
		skip[1][7] = skip[7][1] = 4;
		skip[3][9] = skip[9][3] = 6;
		skip[7][9] = skip[9][7] = 8;
		skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = 5;
		skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = 5;
		return skip;
	}

}
