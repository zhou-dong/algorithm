package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 463. Island Perimeter
 * 
 * Difficulty: Easy
 * 
 * You are given a map in form of a two-dimensional integer grid where 1
 * represents land and 0 represents water. Grid cells are connected
 * horizontally/vertically (not diagonally). The grid is completely surrounded
 * by water, and there is exactly one island (i.e., one or more connected land
 * cells). The island doesn't have "lakes" (water inside that isn't connected to
 * the water around the island). One cell is a square with side length 1. The
 * grid is rectangular, width and height don't exceed 100. Determine the
 * perimeter of the island.
 * 
 * @author zhoudong
 *
 */
public class IslandPerimeter {

	public int islandPerimeter(int[][] grid) {
		Set<String> set = new HashSet<>();
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == 0)
					continue;
				for (String edge : cell(row, col)) {
					if (set.contains(edge)) {
						set.remove(edge);
					} else {
						set.add(edge);
					}
				}
			}
		}
		return set.size();
	}

	private List<String> cell(int row, int col) {
		List<String> edges = new ArrayList<>(4);
		edges.add(edge(row, col, row, col + 1));
		edges.add(edge(row, col + 1, row + 1, col + 1));
		edges.add(edge(row + 1, col + 1, row + 1, col));
		edges.add(edge(row + 1, col, row, col));
		return edges;
	}

	private String edge(int startRow, int startCol, int endRow, int endCol) {
		return startRow + "-" + startCol + "->" + endRow + "-" + endCol;
	}

}
