package org.dzhou.interview.treeandgraph;

import java.util.List;

public abstract class Graph2 {

	private int numEdges;
	private int numVertices;

	public Graph2() {
		this.numEdges = 0;
		this.numVertices = 0;
	}

	public abstract void addvertex();

	public abstract void addEdges(int vertex1, int vertex2, int weight);

	public abstract List<Integer> getNeighbors(int vertex);

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

}
