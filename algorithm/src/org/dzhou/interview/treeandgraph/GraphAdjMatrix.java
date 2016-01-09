package org.dzhou.interview.treeandgraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphAdjMatrix extends Graph2 {

	private int[][] adjMatrix;

	@Override
	public List<Integer> getNeighbors(int vertex) {
		List<Integer> result = new LinkedList<>();
		int[] rows = adjMatrix[vertex];
		for (int j = 0; j < rows.length; j++) {
			if (rows[j] != 0) {
				result.add(j);
			}
		}
		return result;
	}

	public List<Integer> getDistance2(int vertex) {
		List<Integer> result = new ArrayList<>();
		List<Integer> neighbors = getNeighbors(vertex);
		for (int neighbor : neighbors) {
			for (int j = 0; j < adjMatrix.length; j++) {
				if (adjMatrix[neighbor][j] != 0) {
					result.add(j);
				}
			}
		}
		return result;
	}

	@Override
	public void addvertex() {
		int numVertices = getNumVertices();
		if (numVertices > adjMatrix.length) {
			int[][] newAdjMatrix = new int[2 * numVertices][2 * numVertices];
			for (int i = 0; i < adjMatrix.length; i++) {
				for (int j = 0; j < adjMatrix.length; j++) {
					newAdjMatrix[i][j] = adjMatrix[i][j];
				}
			}
			adjMatrix = newAdjMatrix;
		}
	}

	@Override
	public void addEdge(int vertex1, int vertex2, int weight) {
		adjMatrix[vertex1][vertex2] = weight;
	}

}
