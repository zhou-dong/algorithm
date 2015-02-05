package org.dzhou.research.algorithm.tree;

public class BTree<T extends Comparable<? super T>> {

	private static final int NODE_SIZE = 2;

	protected static class Node<T> {

		protected int[] keys = new int[2 * NODE_SIZE - 1];
	}

	public Node<T> root;

	protected void spiltChildNode() {
	}

	private void todo() {
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}