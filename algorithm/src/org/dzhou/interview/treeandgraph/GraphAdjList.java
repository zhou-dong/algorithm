package org.dzhou.interview.treeandgraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphAdjList extends Graph2 {

	private Map<Integer, ArrayList<Integer>> adjListsMap;

	@Override
	public void addvertex() {
		int length = getNumVertices();
		adjListsMap.put(length, new ArrayList<>());
	}

	@Override
	public void addEdge(int vertex1, int vertex2, int weight) {
		adjListsMap.get(vertex1).add(vertex2);
	}

	@Override
	public List<Integer> getNeighbors(int vertex) {
		return adjListsMap.get(vertex);
	}

}
