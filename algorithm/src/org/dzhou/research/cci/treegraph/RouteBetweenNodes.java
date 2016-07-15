package org.dzhou.research.cci.treegraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Practice of "cracking the code interview"
 * 
 * Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 * 
 * @author DONG ZHOU
 *
 */
public class RouteBetweenNodes {

	class Node {
		public State state;
		public String name;
		public Node[] children;
	}

	class Graph {
		public Node[] nodes;
	}

	enum State {
		Unvisited, Visited, Visiting;
	}

	// breadth-first search
	public class Solution {
		boolean search(Graph g, Node start, Node end) {
			if (end == start)
				return true;
			setAllNodesToUnvisited(g);
			return bfs(start, end);
		}

		private boolean bfs(Node start, Node end) {
			Queue<Node> queue = new LinkedList<>();
			addNodeToQueue(start, queue);
			while (!queue.isEmpty()) {
				Node current = queue.poll();
				if (current == end) {
					return true;
				}
				for (Node child : current.children) {
					if (child != null && child.state == State.Unvisited) {
						addNodeToQueue(child, queue);
					}
				}
				current.state = State.Visited;
			}
			return false;
		}

		private void addNodeToQueue(Node node, Queue<Node> queue) {
			node.state = State.Visiting;
			queue.add(node);
		}
	}

	// DFS
	public class Solution1 {
		boolean search(Graph g, Node start, Node end) {
			if (end == start)
				return true;
			setAllNodesToUnvisited(g);
			return dfs(start, end);
		}

		private boolean dfs(Node node, Node end) {
			node.state = State.Visiting;
			for (Node child : node.children) {
				if (child == null)
					continue;
				if (child == end)
					return true;
				if (child.state == State.Unvisited) {
					if (dfs(child, end))
						return true;
				}
			}
			node.state = State.Visited;
			return false;
		}
	}

	private void setAllNodesToUnvisited(Graph g) {
		for (Node node : g.nodes) {
			node.state = State.Unvisited;
		}
	}

}
