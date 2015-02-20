package org.dzhou.research.algorithm.tree;

/**
 * 
 * Not finish
 * 
 * 比较两个区间中的值
 * 
 * Also have the name of Interval Tree
 * 
 * Store:
 * 
 * 1. Use the left end-point as BST key
 * 
 * 2. Store the max end-point in subtree rooted at node
 * 
 * Search:
 * 
 * 1. If search goes right, then no intersection in left.
 * 
 * 2. If goes left, there is either an intersection in left or no intersections
 * in either.
 */
public class IntervalTree<Key extends Comparable<Key>, Value> {

	private Node root;

	public class Node {

		Key low;
		Key high;
		Key max;
		Value value;
		Node left;
		Node right;

		public Node(Key low, Key high, Key max, Value value, Node left,
				Node right) {
			this.low = low;
			this.high = high;
			this.max = max;
			this.value = value;
			this.left = left;
			this.right = right;
		}

	}

	public void put(Key low, Key high, Value val) {
		Node node = root;
		while (node != null) {
			node.max = (high.compareTo(node.max) > 0) ? high : node.max;
			if (low.compareTo(node.low) < 0) {// left
				if (node.left == null) {
					node.left = new Node(low, high, high, val, null, null);
					return;
				}
				node = node.left;
			} else {// right
				if (node.right == null) {
					node.right = new Node(low, high, high, val, null, null);
					return;
				}
				node = node.right;
			}
		}
		root = new Node(low, high, high, val, null, null);
	}

	public boolean isOverlap(Key low, Key high) {
		Node node = root;
		while (node != null) {
			if (iSIntersected(low, high, node))
				return true;
			if (goLeft(low, high, node))
				node = node.left;
			else
				node = node.right;
		}
		return false;
	}

	private boolean iSIntersected(Key low, Key high, Node node) {
		return low.compareTo(node.high) < 0 && high.compareTo(low) > 0;
	}

	private boolean goLeft(Key low, Key high, Node node) {
		return node != null && node.max.compareTo(low) > 0;
	}

	public void get(Key low, Key gigh) {
		// TODO
	}

	public void delete(Key low, Key high) {
		// TODO
	}

	public Iterable<Value> intersects(Key low, Key high) {
		// TODO
		return null;
	}

	public static void main(String[] args) {
		// TODO
	}

}
