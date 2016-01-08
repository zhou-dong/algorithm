package org.dzhou.interview.treeandgraph;

public class Node<T> {

	public enum State {
		Unvisited, Visited, Visiting
	}

	public Node(T data) {
		this.data = data;
	}

	public T data;
	public State state;
	public String name;
	public Node<T>[] children;

}
