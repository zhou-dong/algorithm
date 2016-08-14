package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * For a undirected graph with tree characteristics, we can choose any node as
 * the root. The result graph is then a rooted tree. Among all possible rooted
 * trees, those with minimum height are called minimum height trees (MHTs).
 * Given such a graph, write a function to find all the MHTs and return a list
 * of their root labels.
 * 
 * Format <br>
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be
 * given the number n and a list of undirected edges (each edge is a pair of
 * labels).
 * 
 * You can assume that no duplicate edges will appear in edges. Since all edges
 * are undirected, [0, 1] is the same as [1, 0] and thus will not appear
 * together in edges.
 * 
 * Example 1:
 * 
 * Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * 
 * --------0 <br>
 * --------| <br>
 * --------1 <br>
 * -------/-\ <br>
 * ------2---3 <br>
 * 
 * return [1]
 * 
 * Example 2:
 * 
 * Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * 
 * -----0--1--2 <br>
 * ------\-|-/ <br>
 * --------3 <br>
 * --------| <br>
 * --------4 <br>
 * --------| <br>
 * --------5 <br>
 * 
 * return [3, 4]
 * 
 * graph: {0=[3], 1=[3], 2=[3], 3=[0, 1, 2, 4], 4=[3, 5], 5=[4]}
 * 
 * Hint:
 * 
 * How many MHTs can a graph have at most? Note:
 * 
 * (1) According to the definition of tree on Wikipedia: “a tree is an
 * undirected graph in which any two vertices are connected by exactly one path.
 * In other words, any connected graph without simple cycles is a tree.”
 * 
 * (2) The height of a rooted tree is the number of edges on the longest
 * downward path between the root and a leaf.
 * 
 * @author zhoudong
 *
 *         1.第一感觉是分别对每个结点（node），运行BFS，最后找出level最少的node集合。但是会超时。<br>
 *         2.google以后发现，可以从leaf结点，逐渐删除，直到只有最后一层，就是root结点了。
 */
public class MinimumHeightTrees {

	// 逐渐 remove leafs
	public class Solution {

		public List<Integer> findMinHeightTrees(int n, int[][] edges) {
			if (edges == null || edges.length == 0 || edges[0].length == 0)
				return zeroHeight();

			Map<Integer, Set<Integer>> graph = buildGraph(edges);
			Queue<Integer> queue = new LinkedList<>();
			addLeafs(graph, queue);

			while (n > 2) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					int leaf = queue.poll();
					for (int neighbor : graph.get(leaf)) {
						graph.get(neighbor).remove(leaf);
						if (isLeaf(graph, neighbor)) {
							queue.add(neighbor);
						}
					}
					n--;
					graph.remove(leaf);
				}
			}

			return new ArrayList<>(graph.keySet());
		}

		private void addLeafs(Map<Integer, Set<Integer>> graph, Queue<Integer> queue) {
			for (int node : graph.keySet()) {
				if (isLeaf(graph, node)) {
					queue.add(node);
				}
			}
		}

		private boolean isLeaf(Map<Integer, Set<Integer>> graph, int node) {
			return graph.get(node).size() == 1;
		}

		private Map<Integer, Set<Integer>> buildGraph(int[][] edges) {
			Map<Integer, Set<Integer>> graph = new HashMap<>();
			for (int[] edge : edges)
				addUndirectedEdge(graph, edge);
			return graph;
		}

		private void addUndirectedEdge(Map<Integer, Set<Integer>> graph, int[] edge) {
			addEdge(graph, edge[0], edge[1]);
			addEdge(graph, edge[1], edge[0]);
		}

		private void addEdge(Map<Integer, Set<Integer>> graph, int start, int end) {
			addItem(graph, start, end);
		}

		private void addItem(Map<Integer, Set<Integer>> map, int key, int val) {
			if (!map.containsKey(key))
				map.put(key, new HashSet<>());
			map.get(key).add(val);
		}

		private List<Integer> zeroHeight() {
			List<Integer> result = new ArrayList<>();
			result.add(0);
			return result;
		}
	}

	// Time Limit Exceeded
	public class Solution1 {

		public List<Integer> findMinHeightTrees(int n, int[][] edges) {
			List<Integer> result = new ArrayList<>();

			if (edges == null || edges.length == 0 || edges[0].length == 0) {
				result.add(0);
				return result;
			}

			Map<Integer, Set<Integer>> graph = buildGraph(edges);
			Map<Integer, Set<Integer>> depthMap = new HashMap<>();

			for (int i = 0; i < n; i++) {
				if (graph.containsKey(i)) {
					int level = bfsLevel(graph, i, new boolean[n]);
					addItem(depthMap, level, i);
				}
			}

			for (int i = 1; i < n; i++) {
				if (!graph.containsKey(i))
					continue;
				if (depthMap.containsKey(i))
					return new ArrayList<>(depthMap.get(i));
			}

			return result;
		}

		private int bfsLevel(Map<Integer, Set<Integer>> graph, int root, boolean[] visited) {
			Queue<Integer> queue = new LinkedList<>();
			queue.add(root);
			visited[root] = true;
			int level = -1;
			while (!queue.isEmpty()) {
				level++;
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					int node = queue.poll();
					for (int child : graph.get(node)) {
						if (!visited[child]) {
							visited[child] = true;
							queue.add(child);
						}
					}
				}
			}
			return level;
		}

		private Map<Integer, Set<Integer>> buildGraph(int[][] edges) {
			Map<Integer, Set<Integer>> graph = new HashMap<>();
			for (int[] edge : edges)
				addUndirectedEdge(graph, edge);
			return graph;
		}

		private void addUndirectedEdge(Map<Integer, Set<Integer>> graph, int[] edge) {
			addEdge(graph, edge[0], edge[1]);
			addEdge(graph, edge[1], edge[0]);
		}

		private void addEdge(Map<Integer, Set<Integer>> graph, int start, int end) {
			addItem(graph, start, end);
		}

		private void addItem(Map<Integer, Set<Integer>> map, int key, int val) {
			if (!map.containsKey(key))
				map.put(key, new HashSet<>());
			map.get(key).add(val);
		}
	}

}
