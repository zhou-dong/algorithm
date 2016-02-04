package org.dzhou.interview.recursiondynamicprogramming;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         Imagine a robot on the upper left corner of grid with r rows and c
 *         columns. The robot can only move in two directions, right and down,
 *         but certain cells are "off limits" such that the robot can not step
 *         on them. Design an algorithm to find a path for the robot from the
 *         top left to the bottom right.
 *
 */
public class RobotInGrid {

	public boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
		if (col < 0 || row < 0 || !maze[row][col])
			return false;
		boolean isAtOrigin = (row == 0) && (col == 0);
		if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
			Point p = new Point(row, col);
			path.add(p);
			return true;
		}
		return false;
	}

}
