package org.dzhou.practice.medium.premium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 323. Number of Connected Components in an Undirected Graph
 * 
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
 * edge is a pair of nodes), write a function to find the number of connected
 * components in an undirected graph.
 * 
 * Example 1:
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 * 
 * Example 2:
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 * 
 * Note: You can assume that no duplicate edges will appear in edges. Since all
 * edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear
 * together in edges.
 * 
 * @author zhoudong
 *
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {

	public class Solution {

		public int countComponents(int n, int[][] edges) {
			Map<Integer, Set<Integer>> graph = createGraph(edges);
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
			visited[start] = true;
			if (!graph.containsKey(start))
				return;
			for (int end : graph.get(start)) {
				if (visited[end])
					continue;
				dfs(graph, visited, end);
			}
		}

		private Map<Integer, Set<Integer>> createGraph(int[][] edges) {
			Map<Integer, Set<Integer>> graph = new HashMap<>();
			for (int[] edge : edges) {
				addEdge(graph, edge[0], edge[1]);
				addEdge(graph, edge[1], edge[0]);
			}
			return graph;
		}

		private void addEdge(Map<Integer, Set<Integer>> graph, int start, int end) {
			if (!graph.containsKey(start))
				graph.put(start, new HashSet<>());
			graph.get(start).add(end);
		}

	}

}
