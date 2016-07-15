package org.dzhou.research.cci.treegraph;

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
		public String name;
		public Node[] children;
	}

	class Graph {
		public Node[] nodes;
	}

}
