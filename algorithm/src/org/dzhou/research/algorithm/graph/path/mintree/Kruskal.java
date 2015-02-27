package org.dzhou.research.algorithm.graph.path.mintree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * NOT FINISH THE PART OF UNION FIND
 * 
 * 重点是判断两个顶点是否已连通，可以使用深度优先、广度优先或者并查集
 * 
 * @author DONG ZHOU
 */
public class Kruskal {

	int pointNum = 6;
	int lineNum = 9;

	int[] lineStart = new int[lineNum];
	int[] lineEnd = new int[lineNum];
	int[] lineWeight = new int[lineNum];

	List<Line> lines = new ArrayList<Kruskal.Line>();

	public class Line implements Comparable<Line> {

		public int weight;
		public int start;
		public int end;

		public Line(int weight, int start, int end) {
			this.weight = weight;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Line line) {
			return this.weight - line.weight;
		}

		@Override
		public String toString() {
			return start + " " + end + " " + weight;
		}

	}

	private void initLines() {
		addLine(0, 2, 4, 11);
		addLine(1, 3, 5, 13);
		addLine(2, 4, 6, 3);
		addLine(3, 5, 6, 4);
		addLine(4, 2, 3, 6);
		addLine(5, 4, 5, 7);
		addLine(6, 1, 2, 1);
		addLine(7, 3, 4, 9);
		addLine(8, 1, 3, 2);
	}

	private void initLinesList() {
		for (int i = 0; i < lineNum; i++)
			lines.add(new Line(lineWeight[i], lineStart[i], lineEnd[i]));
	}

	private void sortLineList() {
		Collections.sort(lines);
	}

	public Kruskal() {
		initLines();
		initLinesList();
		sortLineList();
	}

	public void displayLines() {
		for (Line line : lines)
			System.out.println(line);
	}

	private void addLine(int index, int i, int j, int k) {
		lineStart[index] = i;
		lineEnd[index] = j;
		lineWeight[index] = k;
	}

	public int sum;

	public void execute() {
		int count = 0;
		for (Line line : lines) {
			if (!isConnected(line.start, line.end))
				continue;
			count++;
			sum += line.weight;
			if (count == pointNum - 1)
				break;
		}
	}

	private boolean isConnected(int start, int end) {
		return merge(start, end);
	}

	private boolean merge(int start, int end) {
		// TODO USE UNION FIND THE FINISH HERE
		return true;
	}

	public static void main(String args[]) {
		Kruskal instance = new Kruskal();
		instance.execute();
		System.out.println(instance.sum);
	}

}