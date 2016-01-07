package org.dzhou.interview.treeandgraph;

import java.util.LinkedList;

import org.dzhou.interview.treeandgraph.Node.State;

/**
 * Practice of "cracking the code interview"
 * 
 * Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 * 
 * @author DONG ZHOU
 *
 */
public class HasRouterOrNot {

	public static boolean search(Graph graph, Node start, Node end) {
		if (start == end)
			return true;
		initNodesStateToUnvisited(graph);
		LinkedList<Node> queue = new LinkedList<>();
		addToQueue(queue, start);
		Node node;
		while (!queue.isEmpty()) {
			node = queue.removeFirst();
			if (node != null)
				for (Node adjacent : node.children) {
					if (adjacent.state != State.Unvisited)
						continue;
					if (adjacent == end)
						return true;
					else 
						addToQueue(queue, adjacent);
				}
			node.state = State.Visited;
		}
		return false;
	}

	public static boolean search2(Graph graph, Node start, Node end) {
		initNodesStateToUnvisited(graph);
		LinkedList<Node> queue = new LinkedList<>();
		addToQueue(queue, start);
		Node node;
		while (true) {
			node = queue.removeFirst();
			if (node == null)
				return false;
			if (node == end)
				return true;
			for (Node adjacent : node.children)
				if (adjacent.state == State.Unvisited)
					addToQueue(queue, adjacent);
			node.state = State.Visited;
		}
	}

	private static void initNodesStateToUnvisited(Graph graph) {
		for (Node node : graph.nodes)
			node.state = State.Unvisited;
	}

	private static void addToQueue(LinkedList<Node> queue, Node node) {
		node.state = State.Visiting;
		queue.add(node);
	}

}
