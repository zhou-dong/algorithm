package org.dzhou.practice.hard.premium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A group of two or more people wants to meet and minimize the total travel
 * distance. You are given a 2D grid of values 0 or 1, where each 1 marks the
 * home of someone in the group. The distance is calculated using Manhattan
 * Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * 
 * @author zhoudong
 *
 */
public class BestMeetingPoint {

	// 题目中已经给出了一个暗示:如果是一维的, 选取哪个点作为见面地点才能使距离最短呢?
	public class Solution {
		public int minTotalDistance(int[][] grid) {
			List<Integer> rows = collectRows(grid);
			List<Integer> cols = collectCols(grid);
			return minDistance1D(rows) + minDistance1D(cols);
		}

		public int minDistance1D(List<Integer> positions) {
			int sum = 0;
			for (int i = 0, j = positions.size() - 1; i < j; i++, j--)
				sum += positions.get(j) - positions.get(i);
			return sum;
		}

		private List<Integer> collectRows(int[][] grid) {
			List<Integer> rows = new ArrayList<>();
			for (int row = 0; row < grid.length; row++) {
				for (int col = 0; col < grid[0].length; col++) {
					if (grid[row][col] == 1) {
						rows.add(row);
					}
				}
			}
			return rows;
		}

		private List<Integer> collectCols(int[][] grid) {
			List<Integer> cols = new ArrayList<Integer>();
			for (int col = 0; col < grid[0].length; col++) {
				for (int row = 0; row < grid.length; row++) {
					if (grid[row][col] == 1) {
						cols.add(col);
					}
				}
			}
			return cols;
		}
	}

	// Time Limit Exceeded
	public class Solution1 {
		int[][] directions = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
		int[][] count = null, grid = null;

		public int minTotalDistance(int[][] grid) {
			this.grid = grid;
			this.count = new int[grid.length][grid[0].length];
			for (int row = 0; row < grid.length; row++) {
				for (int col = 0; col < grid[row].length; col++) {
					if (grid[row][col] == 1) {
						bfs(row, col, new boolean[grid.length][grid[row].length]);
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for (int row = 0; row < grid.length; row++) {
				for (int col = 0; col < grid[row].length; col++) {
					min = Math.min(min, count[row][col]);
				}
			}
			return min;
		}

		private void bfs(int row, int col, boolean[][] visited) {
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] { row, col });
			visited[row][col] = true;
			int level = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					int[] indices = queue.poll();
					for (int[] direction : directions) {
						int nextRow = indices[0] + direction[0];
						int nextCol = indices[1] + direction[1];
						if (!valid(nextRow, nextCol, grid, visited))
							continue;
						visited[nextRow][nextCol] = true;
						count[nextRow][nextCol] += (level + 1);
						queue.offer(new int[] { nextRow, nextCol });
					}
				}
				level++;
			}
		}

		private boolean valid(int row, int col, int[][] grid, boolean[][] visited) {
			return validLocation(row, col, grid) && !visited[row][col];
		}

		private boolean validLocation(int row, int col, int[][] grid) {
			return row >= 0 && col >= 0 && row < grid.length && col < grid[row].length;
		}
	}

}
