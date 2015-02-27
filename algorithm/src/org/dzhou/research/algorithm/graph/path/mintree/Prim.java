package org.dzhou.research.algorithm.graph.path.mintree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DONG ZHOU
 */
public class Prim {

	int sum = 0;
	int count = 0;
	int max = 1000;
	int pointNum = 6;
	int lineNum = 9;
	int[] lineStart = new int[lineNum];
	int[] lineEnd = new int[lineNum];
	int[] lineWeight = new int[lineNum];
	List<Line> lines = new ArrayList<Prim.Line>();
	int[] book = new int[pointNum + 1];
	int[] distance = new int[pointNum + 1];

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

	private void initDistance() {
		for (int i = 0; i < distance.length; i++)
			distance[i] = max;
		for (Line line : lines)
			if (line.start == 1)
				distance[line.end] = line.weight;
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

	public Prim() {
		initLines();
		initLinesList();
		initDistance();
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

	void dispalyDistance() {
		for (int i : distance)
			System.out.print(i + " ");
	}

	public void execute() {
		int first = lines.get(0).start;
		book[first] = 1;
		count++;
		int nearest = 0;
		while (count < pointNum) {
			int min = max;
			// 正向检查
			for (Line line : lines) {
				int start = line.start;
				if (start != first)
					continue;
				int end = line.end;
				if (book[end] == 1)
					continue;
				int weight = line.weight;
				if (weight == max)
					continue;
				if (weight >= min)
					continue;
				min = weight;
				nearest = end;
			}
			// 逆向检查
			for (Line line : lines) {
				int end = line.end;
				if (end != first)
					continue;
				int start = line.start;
				if (book[start] == 1)
					continue;
				int weight = line.weight;
				if (weight == max)
					continue;
				if (weight >= min)
					continue;
				min = weight;
				nearest = start;
			}
			book[nearest] = 1;
			count++;
			sum += min;
			min = max;
			first = nearest;
		}
	}

	public static void main(String args[]) {
		Prim instance = new Prim();
		instance.execute();
		System.out.println(instance.sum);
	}

}