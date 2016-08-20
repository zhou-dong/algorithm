package org.dzhou.practice.hard.premium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You want to build a house on an empty land which reaches all buildings in the
 * shortest amount of distance. You can only move up, down, left and right. You
 * are given a 2D grid of values 0, 1 or 2, where:
 * 
 * Each 0 marks an empty land which you can pass by freely. Each 1 marks a
 * building which you cannot pass through. Each 2 marks an obstacle which you
 * cannot pass through. For example, given three buildings at (0,0), (0,4),
 * (2,2), and an obstacle at (0,2):
 * 
 * The point (1,2) is an ideal empty land to build a house, as the total travel
 * distance of 3+3+1=7 is minimal. So return 7.
 * 
 * Note: There will be at least one building. If it is not possible to build
 * such house according to the above rules, return -1.
 * 
 * @author zhoudong
 *
 */
public class ShortestDistanceFromAllBuildings {

	int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private boolean valid(int[][] grid, boolean[][] visited, int row, int col) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length)
			return false;
		return !visited[row][col] && grid[row][col] == 0;
	}

	public int shortestDistance(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return -1;

		int rowLength = grid.length, colLength = grid[0].length;

		int[][] distance = new int[rowLength][colLength];
		int[][] reach = new int[rowLength][colLength];

		int houseCount = 0;
		for (int row = 0; row < rowLength; row++) {
			for (int col = 0; col < colLength; col++) {
				if (grid[row][col] == 1) {
					houseCount++;
					bfs(grid, distance, reach, new boolean[rowLength][colLength], new int[] { row, col });
				}
			}
		}

		int minDist = Integer.MAX_VALUE;
		for (int row = 0; row < rowLength; row++) {
			for (int col = 0; col < colLength; col++) {
				if (grid[row][col] == 0 && reach[row][col] == houseCount) {
					minDist = Math.min(minDist, distance[row][col]);
				}
			}
		}
		return minDist == Integer.MAX_VALUE ? -1 : minDist;
	}

	private void bfs(int[][] grid, int[][] distance, int[][] reach, boolean[][] visited, int[] element) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(element);
		visited[element[0]][element[1]] = true;
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] indices = queue.poll();
				for (int[] dir : directions) {
					int row = indices[0] + dir[0];
					int col = indices[1] + dir[1];
					if (!valid(grid, visited, row, col))
						continue;
					queue.offer(new int[] { row, col });
					visited[row][col] = true;
					distance[row][col] += level + 1;
					reach[row][col]++;
				}
			}
			level++;
		}
	}

}
