package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 323. Number of Connected Components in an Undirected Graph
 * 
 * Difficulty: Medium
 * 
 * Contributors: Admin
 * 
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
 * edge is a pair of nodes), write a function to find the number of connected
 * components in an undirected graph.
 * 
 * @author zhoudong
 *
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {

	public int countComponents(int n, int[][] edges) {
		Map<Integer, Set<Integer>> graph = createUndirectedGraph(edges);
		boolean[] visited = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			count++;
			dfs(graph, visited, i);
		}
		return count;
	}

	private void dfs(Map<Integer, Set<Integer>> graph, boolean[] visited, int start) {
		if (visited[start]) {
			return;
		}
		if (!graph.containsKey(start)) {
			return;
		}
		visited[start] = true;
		for (int connect : graph.get(start)) {
			dfs(graph, visited, connect);
		}
	}

	private Map<Integer, Set<Integer>> createUndirectedGraph(int[][] edges) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int[] edge : edges) {
			addPairToMap(graph, edge[0], edge[1]);
			addPairToMap(graph, edge[1], edge[0]);
		}
		return graph;
	}

	private void addPairToMap(Map<Integer, Set<Integer>> map, int key, int value) {
		if (!map.containsKey(key))
			map.put(key, new HashSet<>());
		map.get(key).add(value);
	}

}
