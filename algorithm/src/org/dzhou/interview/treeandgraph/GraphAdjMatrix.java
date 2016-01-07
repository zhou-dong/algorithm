package org.dzhou.interview.treeandgraph;

import java.util.List;

public class GraphAdjMatrix extends Graph2 {

	private int[][] adjMatrix;

	@Override
	public List<Integer> getNeighbors(int vertex) {
		return null;
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
	public void addEdges(int vertex1, int vertex2, int weight) {
		adjMatrix[vertex1][vertex2] = weight;
	}

}
