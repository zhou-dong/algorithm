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
	private int[] dis = row0.clone();
	private int[] book = new int[6];

	public void execute() {
		int nearest = 0;
		for (int i = 0; i < map.length; i++) {
			int min = max;
			for (int j = 0; j < map.length; j++) {
				if (isBooked(j))
					continue;
				if (dis[j] >= min)
					continue;
				min = dis[j];
				nearest = j;
			}
			book(nearest);
			for (int j = 0; j < map.length; j++) {
				if (map[nearest][j] == max)
					continue;
				if (dis[j] > dis[nearest] + map[nearest][j])
					dis[j] = dis[nearest] + map[nearest][j];
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
		for (int i : dis)
			System.out.print(i + " ");
	}

	public static void main(String[] args) {
		Dijkstra instance = new Dijkstra();
		instance.execute();
		instance.display();
	}

}