package org.dzhou.research.algorithm.graph.path.shortest;

/**
 * 单源最短路径
 * 
 * @author DONG ZHOU
 */
public class Dijkstra {

	private int max = Integer.MAX_VALUE;

	private int[] row0 = { 0, 1, 12, max, max, max };
	private int[] row1 = { max, 0, 9, 3, max, max };
	private int[] row2 = { max, max, 0, max, 5, max };
	private int[] row3 = { max, max, 4, 0, 13, 15 };
	private int[] row4 = { max, max, max, max, 0, 4 };
	private int[] row5 = { max, max, max, max, max, 0 };

	private int[][] map = { row0, row1, row2, row3, row4, row5 };
	private int[] distance = row0.clone();
	private int[] book = new int[6];

	private int shortest = 0;

	public void execute() {
		for (int i = 0; i < map.length; i++) {
			int min = max;
			for (int j = 0; j < map.length; j++) {
				if (isBooked(j))
					continue;
				if (distance[j] >= min)
					continue;
				min = distance[j];
				shortest = j;
			}
			book(shortest);
			for (int j = 0; j < map.length; j++) {
				if (map[shortest][j] == max)
					continue;
				if (distance[j] > distance[shortest] + map[shortest][j])
					distance[j] = distance[shortest] + map[shortest][j];
			}
		}
	}

	private void book(int i) {
		book[i] = 1;
	}

	private boolean isBooked(int i) {
		return book[i] == 1;
	}

	public void display() {
		for (int i : distance)
			System.out.print(i + " ");
	}

	public static void main(String[] args) {
		Dijkstra instance = new Dijkstra();
		instance.execute();
		instance.display();
	}

}