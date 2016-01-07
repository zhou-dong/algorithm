package org.dzhou.interview.treeandgraph;

public class Node {

	public enum State {
		Unvisited, Visited, Visiting
	}

	public State state;
	public String name;
	public Node[] children;

}
