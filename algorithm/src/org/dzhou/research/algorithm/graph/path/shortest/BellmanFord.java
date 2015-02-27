package org.dzhou.research.algorithm.graph.path.shortest;

/**
 * @author DONG ZHOU
 */
public class BellmanFord {

	int max = 1000;
	int pointNum = 5;
	int lineNum = 5;

	int[] lineStart = new int[lineNum];
	int[] lineEnd = new int[lineNum];
	int[] lineWeight = new int[lineNum];

	private int[] distance = new int[5 + 1];

	public BellmanFord() {
		initLines();
		initDinstance();
	}

	private void initLines() {
		addLine(0, 2, 3, 2);
		addLine(1, 1, 2, -3);
		addLine(2, 1, 5, 5);
		addLine(3, 4, 5, 2);
		addLine(4, 3, 4, 3);
	}

	private void initDinstance() {
		for (int i = 0; i < distance.length; i++)
			distance[i] = max;
		distance[0] = 0;
		distance[1] = 0;
	}

	private void addLine(int index, int i, int j, int k) {
		lineStart[index] = i;
		lineEnd[index] = j;
		lineWeight[index] = k;
	}

	public void execute() {
		for (int k = 0; k < pointNum; k++)
			for (int i = 0; i < lineNum; i++)
				updateDistance(i);
	}

	private void updateDistance(int i) {
		if (distance[lineEnd[i]] > distance[lineStart[i]] + lineWeight[i])
			distance[lineEnd[i]] = distance[lineStart[i]] + lineWeight[i];
	}

	public void displayLines() {
		for (int i = 0; i < lineNum; i++)
			System.out.println(lineStart[i] + " " + lineEnd[i] + " "
					+ lineWeight[i]);
	}

	public void displayDistance() {
		for (int i : distance)
			System.out.print(i + " ");
	}

	public static void main(String[] args) {
		BellmanFord instance = new BellmanFord();
		instance.execute();
		instance.displayLines();
		instance.displayDistance();
	}

}