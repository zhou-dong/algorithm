package org.dzhou.interview.treeandgraph;

public class BinarySearchTree {

	public TreeNode<Integer> createBySortedArray(int[] array) {
		return createBySortedArray(array);
	}

	public TreeNode<Integer> createBySortedArray(int[] array, int start, int end) {
		if (end < start)
			return null;
		int middle = (start + end) / 2;
		TreeNode<Integer> node = new TreeNode<Integer>(middle);
		node.left = createBySortedArray(array, start, middle - 1);
		node.right = createBySortedArray(array, middle + 1, end);
		return node;
	}

}
