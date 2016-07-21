package org.dzhou.research.cci.dynamicprogramming;

import java.awt.Point;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Practice of "cracking the code interview"
 * 
 * Imagine a robot on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells
 * are "off limits" such that the robot can not step on them. Design an
 * algorithm to find a path for the robot from the top left to the bottom right.
 * 
 * @author DONG ZHOU
 *
 *
 */
public class RobotInGrid {

	class Solution {
		List<Point> getPath(boolean[][] maze) {
			if (maze == null || maze.length == 0 || maze[0].length == 0)
				return Collections.emptyList();
			List<Point> path = new LinkedList<>();
			Map<Point, Boolean> cache = new HashMap<>();
			if (getPath(maze, path, maze.length - 1, maze[0].length - 1, cache))
				return path;
			return Collections.emptyList();
		}

		private boolean getPath(boolean[][] maze, List<Point> path, int row, int col, Map<Point, Boolean> cache) {
			if (row < 0 || col < 0 || maze[row][col] == false)
				return false;
			Point p = new Point(row, col);
			if (cache.containsKey(p))
				return cache.get(p);
			boolean isAtOrigin = (row == 0) && (col == 0);
			boolean success = false;
			if (isAtOrigin || getPath(maze, path, row, col - 1, cache) || getPath(maze, path, row - 1, col, cache)) {
				path.add(new Point(row, col));
				success = true;
			}
			cache.put(p, success);
			return success;
		}
	}

	class Solution1 {
		List<Point> getPath(boolean[][] maze) {
			if (maze == null || maze.length == 0 || maze[0].length == 0)
				return Collections.emptyList();
			List<Point> path = new LinkedList<>();
			if (getPath(maze, path, maze.length - 1, maze[0].length - 1))
				return path;
			return Collections.emptyList();
		}

		private boolean getPath(boolean[][] maze, List<Point> path, int row, int col) {
			if (row < 0 || col < 0 || maze[row][col] == false)
				return false;
			boolean isAtOrigin = (row == 0) && (col == 0);
			// 1. 先add最后一个point(0,0)
			// 2. 回溯，如果是return true，则把point加入到path中
			if (isAtOrigin || getPath(maze, path, row, col - 1) || getPath(maze, path, row - 1, col)) {
				path.add(new Point(row, col));
				return true;
			}
			return false;
		}
	}

	class Solution2 {
		List<Point> getPath(boolean[][] maze) {
			if (maze == null || maze.length == 0 || maze[0].length == 0)
				return Collections.emptyList();
			List<List<Point>> paths = new LinkedList<>();
			getPaths(maze, new LinkedList<>(), paths, maze.length - 1, maze[0].length - 1);
			if (paths.size() == 0)
				return Collections.emptyList();
			return paths.get(0);
		}

		private void getPaths(boolean[][] maze, List<Point> path, List<List<Point>> paths, int row, int col) {
			if (row < 0 || col < 0 || maze[row][col] == false)
				return;
			if (row == 0 && col == 0) {
				paths.add(new LinkedList<>(path));
				return;
			}
			Point point = new Point(row, col);
			path.add(point);
			getPaths(maze, path, paths, row - 1, col);
			getPaths(maze, path, paths, row, col - 1);
			path.remove(point);
		}
	}

}
