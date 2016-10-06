package org.dzhou.practice.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 407. Trapping Rain Water II
 * 
 * Given an m x n matrix of positive integers representing the height of each
 * unit cell in a 2D elevation map, compute the volume of water it is able to
 * trap after raining.
 * 
 * Note: Both m and n are less than 110. The height of each unit cell is greater
 * than 0 and is less than 20,000.
 * 
 * @author zhoudong
 *
 */
public class TrappingRainWaterII {

	public class cell {
		int x, y, h;

		public cell(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}

	public int calWater(PriorityQueue<cell> heap, int[][] heightMap, boolean[][] visited, int x, int y, int h) {
		int row = heightMap.length, col = heightMap[0].length;
		if (x < 0 || x >= row || y < 0 || y >= col || visited[x][y])
			return 0;
		heap.add(new cell(x, y, Math.max(h, heightMap[x][y])));
		visited[x][y] = true;
		return Math.max(0, h - heightMap[x][y]);// can hold water
	}

	public int trapRainWater(int[][] heightMap) {
		if (heightMap == null || heightMap.length == 0)
			return 0;
		int row = heightMap.length, col = heightMap[0].length, result = 0;

		PriorityQueue<cell> heap = new PriorityQueue<cell>(10, new Comparator<cell>() {
			public int compare(cell a, cell b) {
				return a.h - b.h;
			}
		});
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			heap.add(new cell(i, 0, heightMap[i][0]));
			heap.add(new cell(i, col - 1, heightMap[i][col - 1]));
			visited[i][0] = true;// mark true when add to heap
			visited[i][col - 1] = true;
		}
		for (int j = 0; j < col; j++) {
			heap.add(new cell(0, j, heightMap[0][j]));
			heap.add(new cell(row - 1, j, heightMap[row - 1][j]));
			visited[0][j] = true;
			visited[row - 1][j] = true;
		}
		while (!heap.isEmpty()) {
			cell c = heap.poll();
			result += calWater(heap, heightMap, visited, c.x + 1, c.y, c.h);
			result += calWater(heap, heightMap, visited, c.x - 1, c.y, c.h);
			result += calWater(heap, heightMap, visited, c.x, c.y - 1, c.h);
			result += calWater(heap, heightMap, visited, c.x, c.y + 1, c.h);
		}
		return result;
	}

}
