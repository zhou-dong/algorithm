package org.dzhou.review.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphAdjList<T> extends Graph {

	private Map<Integer, ArrayList<Integer>> adjListsMap;

	@Override
	public void addvertex() {
		adjListsMap = new HashMap<>();
	}

	@Override
	public void addEdge(int vertex1, int vertex2, int weight) {
		adjListsMap.get(vertex1).add(vertex2);
	}

	@Override
	public List<Integer> getNeighbors(int vertex) {
		return new ArrayList<>(adjListsMap.get(vertex));
	}

	public Map<Integer, ArrayList<Integer>> getAdjListsMap() {
		return adjListsMap;
	}

}
