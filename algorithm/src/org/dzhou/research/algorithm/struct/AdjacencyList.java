package org.dzhou.research.algorithm.struct;

/**
 * 邻接表
 * 
 * Data:
 * 
 * 4 5
 * 
 * 1 4 9
 * 
 * 2 4 6
 * 
 * 1 2 5
 * 
 * 4 3 8
 * 
 * 1 3 7
 * 
 * @author DONG ZHOU
 * 
 */
public class AdjacencyList {

	int pointNum = 4;
	int lineNum = 5;

	int[] first = new int[pointNum];
	int[] next = new int[lineNum];

	int[] lineStart = new int[lineNum];
	int[] lineEnd = new int[lineNum];
	int[] lineWeight = new int[lineNum];

	private void initLines() {
		addLine(0, 1, 4, 9);
		addLine(1, 2, 4, 6);
		addLine(2, 1, 2, 5);
		addLine(3, 4, 3, 8);
		addLine(4, 1, 3, 7);
	}

	private void addLine(int index, int i, int j, int k) {
		lineStart[index] = i;
		lineEnd[index] = j;
		lineWeight[index] = k;
	}

	public void creatList() {
		initFirst();
		initLines();
		for (int i = 0; i < lineNum; i++) {
			next[i] = first[lineStart[i] - 1];
			first[lineStart[i] - 1] = i;
		}
	}

	private void displayLines() {
		for (int i = 0; i < lineNum; i++)
			System.out.println(lineStart[i] + " " + lineEnd[i] + " "
					+ lineWeight[i]);
	}

	private void initFirst() {
		for (int i = 0; i < pointNum; i++)
			first[i] = -1;
	}

	public static void main(String[] args) {
		AdjacencyList instance = new AdjacencyList();
		instance.creatList();
		instance.displayLines();
	}

}