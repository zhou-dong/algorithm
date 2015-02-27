package org.dzhou.research.algorithm.graph;

/**
 * Not Finished..
 * 
 * @author DONG ZHOU
 *
 */
public class CutPoint {

	private void todo() {
	}

	private int[] row0 = { 0, 0, 1, 1, 0, 0 };
	private int[] row1 = { 0, 0, 0, 0, 1, 1 };
	private int[] row2 = { 0, 1, 0, 0, 0, 0 };
	private int[] row3 = { 0, 1, 0, 0, 0, 0 };
	private int[] row4 = { 0, 0, 0, 0, 0, 1 };
	private int[] row5 = { 0, 0, 0, 0, 0, 0 };

	private int[][] map = { row0, row1, row2, row3, row4, row5 };

	private int min(int i, int j) {
		return i < j ? i : j;
	}

	private int[] times = new int[map.length];
	private int[] lowPoints = new int[map.length];
	int[] flag = new int[map.length];
	private int time;
	private int root;

	public void execute(int current, int father) {
		time++;
		times[current] = time;
		lowPoints[current] = time;
		int childCount = 0;
		for (int i = 0; i < map.length; i++) {
			if (map[current][i] == 0)
				continue;
			if (i == father)
				continue;
			if (times[i] != 0)
				lowPoints[current] = min(lowPoints[current], times[i]);
			else {
				childCount++;
				execute(i, current);
				lowPoints[current] = min(lowPoints[current], lowPoints[i]);
				if (current != root && lowPoints[i] > times[current])
					flag[current] = 1;
				if (current == root && childCount == 2)
					flag[current] = 1;
			}
		}
	}

	void display() {
		for (int i : flag)
			System.out.print(i + " ");
		System.out.println("");
		for (int i : times)
			System.out.print(i + " ");
		System.out.println("");
		for (int i : lowPoints)
			System.out.print(i + " ");
	}

	void displayMap() {
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map.length; j++)
				if (map[i][j] != 0)
					System.out.println((i + 1) + " " + (j + 1));
	}

	public static void main(String[] args) {
		CutPoint instance = new CutPoint();
		instance.execute(0, 0);
		instance.display();
	}

}