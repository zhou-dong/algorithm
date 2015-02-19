package org.dzhou.research.algorithm.tree;

/**
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
public class SegmentTree<Key extends Comparable<Key>, Value> {

	public void put(Key low, Key high, Value val) {
	}

	public void get(Key low, Key gigh) {
	}

	public void delete(Key low, Key high) {
	}

	public Iterable<Value> intersects(Key low, Key high) {
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
