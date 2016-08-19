package org.dzhou.practice.medium.premium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	public class Solution {
		int DFS(boolean vis[], int[][] skip, int cur, int remain) {
			if (remain < 0)
				return 0;
			if (remain == 0)
				return 1;
			vis[cur] = true;
			int rst = 0;
			for (int i = 1; i <= 9; ++i) {
				// If vis[i] is not visited and (two numbers are adjacent or
				// skip number is already visited)
				if (!vis[i] && (skip[i][cur] == 0 || (vis[skip[i][cur]]))) {
					rst += DFS(vis, skip, i, remain - 1);
				}
			}
			vis[cur] = false;
			return rst;
		}

		public int numberOfPatterns(int m, int n) {
			// Skip array represents number to skip between two pairs
			int skip[][] = new int[10][10];
			skip[1][3] = skip[3][1] = 2;
			skip[1][7] = skip[7][1] = 4;
			skip[3][9] = skip[9][3] = 6;
			skip[7][9] = skip[9][7] = 8;
			skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
			boolean vis[] = new boolean[10];
			int rst = 0;
			// DFS search each length from m to n
			for (int i = m; i <= n; ++i) {
				rst += DFS(vis, skip, 1, i - 1) * 4; // 1, 3, 7, 9 are symmetric
				rst += DFS(vis, skip, 2, i - 1) * 4; // 2, 4, 6, 8 are symmetric
				rst += DFS(vis, skip, 5, i - 1); // 5
			}
			return rst;
		}
	}

	// Time Limit Exceeded
	public class Solution1 {

		Set<String> results = new HashSet<>();

		public int numberOfPatterns(int m, int n) {
			for (int i = 1; i <= 9; i++) {
				for (int j = m; j <= n; j++) {
					dfs(j, new ArrayList<>(), i, new HashSet<>());
				}
			}
			return results.size();
		}

		private String listToString(List<Integer> visited) {
			StringBuilder sb = new StringBuilder();
			for (int i : visited)
				sb.append(i);
			return sb.toString();
		}

		private void dfs(int length, List<Integer> item, int previous, Set<Integer> visited) {
			if (item.size() == length) {
				String result = listToString(item);
				if (!results.contains(item)) {
					results.add(result);
				}
				return;
			}
			for (int i = 1; i <= 9; i++) {
				if (isValid(item, previous, i)) {
					item.add(i);
					visited.add(i);
					dfs(length, item, i, visited);
					item.remove(item.size() - 1);
					visited.remove(i);
				}
			}
		}

		private boolean isValid(List<Integer> visited, int current, int next) {
			if (visited.contains(next))
				return false;
			switch (current) {
			case 1:
				switch (next) {
				case 3:
					return visited.contains(2);
				case 7:
					return visited.contains(4);
				case 9:
					return visited.contains(5);
				}
				break;
			case 2:
				switch (next) {
				case 8:
					return visited.contains(5);
				}
				break;
			case 3:
				switch (next) {
				case 1:
					return visited.contains(2);
				case 7:
					return visited.contains(5);
				case 9:
					return visited.contains(6);
				}
				break;
			case 4:
				switch (next) {
				case 6:
					return visited.contains(5);
				}
				break;
			case 5:
				return true;
			case 6:
				switch (next) {
				case 4:
					return visited.contains(5);
				}
				break;
			case 7:
				switch (next) {
				case 1:
					return visited.contains(4);
				case 3:
					return visited.contains(5);
				case 9:
					return visited.contains(8);
				}
				break;
			case 8:
				switch (next) {
				case 2:
					return visited.contains(5);
				}
				break;
			case 9:
				switch (next) {
				case 1:
					return visited.contains(5);
				case 3:
					return visited.contains(6);
				case 7:
					return visited.contains(8);
				}
				break;
			}
			return true;
		}
	}

}