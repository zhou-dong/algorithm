package com.dzhou.interview.google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 317. Shortest Distance from All Buildings
 * 
 * Difficulty: Hard
 * 
 * You want to build a house on an empty land which reaches all buildings in the
 * shortest amount of distance. You can only move up, down, left and right. You
 * are given a 2D grid of values 0, 1 or 2, where:
 * 
 * Each 0 marks an empty land which you can pass by freely.
 * 
 * Each 1 marks a building which you cannot pass through.
 * 
 * Each 2 marks an obstacle which you cannot pass through.
 * 
 * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at
 * (0,2):
 * 
 * 1 - 0 - 2 - 0 - 1 <br>
 * | - | - | - | - | <br>
 * 0 - 0 - 0 - 0 - 0 <br>
 * | - | - | - | - | <br>
 * 0 - 0 - 1 - 0 - 0 <br>
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

	public int shortestDistance(int[][] grid) {
		int[][] distances = new int[grid.length][grid[0].length];
		int[][] reaches = new int[grid.length][grid[0].length];

		int houseCount = houseCount(grid);
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (isEmpty(grid, row, col)) {
					bfs(grid, row, col, distances, reaches);
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (reaches[row][col] == houseCount) {
					min = Math.min(min, distances[row][col]);
				}
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	private void bfs(int[][] grid, int row, int col, int[][] distances, int[][] reaches) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { row, col });
		visited[row][col] = true;
		int level = 0, reach = 0, distance = 0;
		while (!queue.isEmpty()) {
			level++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] point = queue.poll();
				for (int[] direction : directions) {
					int nextRow = point[0] + direction[0];
					int nextCol = point[1] + direction[1];
					if (!isInGrid(grid, nextRow, nextCol)) {
						continue;
					}
					if (visited[nextRow][nextCol]) {
						continue;
					}
					visited[nextRow][nextCol] = true;
					if (isHouse(grid, nextRow, nextCol)) {
						reach++;
						distance += level;
					} else if (isEmpty(grid, nextRow, nextCol)) {
						queue.add(new int[] { nextRow, nextCol });
					}
				}
			}
		}
		distances[row][col] = distance;
		reaches[row][col] = reach;
	}

	private int houseCount(int[][] grid) {
		int count = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (isHouse(grid, row, col)) {
					count++;
				}
			}
		}
		return count;
	}

	int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	private boolean isHouse(int[][] grid, int row, int col) {
		return grid[row][col] == 1;
	}

	private boolean isEmpty(int[][] grid, int row, int col) {
		return grid[row][col] == 0;
	}

	private boolean isInGrid(int[][] grid, int row, int col) {
		return row >= 0 && col >= 0 && row < grid.length && col < grid[row].length;
	}
}
