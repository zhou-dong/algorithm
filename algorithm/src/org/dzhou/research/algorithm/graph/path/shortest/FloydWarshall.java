package org.dzhou.research.algorithm.graph.path.shortest;

/**
 * Dynamic Programming
 * 
 * @author DONG ZHOU
 */
public class FloydWarshall {

	private int max = Integer.MAX_VALUE;
	private int[] row0 = { 0, 2, 6, 4 };
	private int[] row1 = { max, 0, 3, max };
	private int[] row2 = { 7, max, 0, 1 };
	private int[] row3 = { 5, max, 12, 0 };
	private int[][] map = { row0, row1, row2, row3 };

	public void execute() {
		for (int k = 0; k < map.length; k++)
			for (int i = 0; i < map.length; i++)
				for (int j = 0; j < map.length; j++)
					updateDistance(k, i, j);
	}

	private void updateDistance(int k, int i, int j) {
		int transferDistance = transferDinstance(i, j, k);
		if (map[i][j] > transferDistance)
			map[i][j] = transferDistance;
	}

	private int transferDinstance(int i, int j, int transferPoint) {
		if (map[i][transferPoint] == max)
			return max;
		if (map[transferPoint][j] == max)
			return max;
		return map[i][transferPoint] + map[transferPoint][j];
	}

	public void display() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++)
				System.out.print(map[i][j] + " ");
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		FloydWarshall instance = new FloydWarshall();
		instance.execute();
		instance.display();
	}

}