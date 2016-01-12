package org.dzhou.interview.treeandgraph;

/**
 * Practice of "cracking the code interview"
 * 
 * Given a stored (increasing order) array with unique integer element, write an
 * algorithm to create a binary search tree with minimal height;
 * 
 * @author DONG ZHOU
 *
 */
public class BinarySearchTree {

	public TreeNode<Integer> createBySortedArray(int[] array) {
		return createBySortedArray(array);
	}

	public TreeNode<Integer> createBySortedArray(int[] array, int start, int end) {
		if (end < start)
			return null;
		int middle = (start + end) / 2;
		TreeNode<Integer> node = new TreeNode<Integer>(middle);
		node.setLeft(createBySortedArray(array, start, middle - 1));
		node.setRight(createBySortedArray(array, middle + 1, end));
		return node;
	}

}
