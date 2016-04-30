package org.dzhou.review.graph;

import java.util.List;

public abstract class Graph {

	private int numEdges = 0;
	private int numVertices = 0;

	public int getNumEdges() {
		return numEdges;
	}

	public void setNumEdges(int numEdges) {
		this.numEdges = numEdges;
	}

	public int getNumVertices() {
		return numVertices;
	}

	public void setNumVertices(int numVertices) {
		this.numVertices = numVertices;
	}

	public abstract void addvertex();

	public abstract void addEdge(int vertex1, int vertex2, int weight);

	public abstract List<Integer> getNeighbors(int vertex);

}
