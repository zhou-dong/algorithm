package org.dzhou.practice.medium.premium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 * 
 * -1 - A wall or an obstacle. <br>
 * 0 - A gate. <br>
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to
 * represent INF as you may assume that the distance to a gate is less than
 * 2147483647. Fill each empty room with the distance to its nearest gate. If it
 * is impossible to reach a gate, it should be filled with INF.
 * 
 * For example, given the 2D grid: <br>
 * INF -1 0 INF <br>
 * INF INF INF -1 <br>
 * INF -1 INF -1 <br>
 * 0 -1 INF INF <br>
 * 
 * After running your function, the 2D grid should be:
 * 
 * 3 -1 0 1 <br>
 * 2 2 1 -1 <br>
 * 1 -1 2 -1 <br>
 * 0 -1 3 4 <br>
 * 
 * @author zhoudong
 *
 */
public class WallsAndGates {

	public class Solution {

		class Point {
			int row;
			int col;

			Point(int row, int col) {
				this.row = row;
				this.col = col;
			}
		}

		public void wallsAndGates(int[][] rooms) {
			for (int row = 0; row < rooms.length; row++) {
				for (int col = 0; col < rooms[row].length; col++) {
					if (rooms[row][col] == 0) {
						bfs(rooms, new Point(row, col));
					}
				}
			}
		}

		private void bfs(int[][] rooms, Point start) {
			Queue<Point> queue = new LinkedList<>();
			queue.add(start);

			int distance = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					Point point = queue.poll();
					int current = rooms[point.row][point.col];
					rooms[point.row][point.col] = Math.min(current, distance);
					if (isAvailable(rooms, point.row - 1, point.col, distance))
						queue.add(new Point(point.row - 1, point.col));
					if (isAvailable(rooms, point.row + 1, point.col, distance))
						queue.add(new Point(point.row + 1, point.col));
					if (isAvailable(rooms, point.row, point.col + 1, distance))
						queue.add(new Point(point.row, point.col + 1));
					if (isAvailable(rooms, point.row, point.col - 1, distance))
						queue.add(new Point(point.row, point.col - 1));
				}
				distance++;
			}

		}

		private boolean isAvailable(int[][] rooms, int row, int col, int distance) {
			if (row < 0 || col < 0 || row >= rooms.length || col >= rooms[row].length)
				return false;
			int value = rooms[row][col];
			return value != -1 && value != 0 && value > distance;
		}

	}

}
