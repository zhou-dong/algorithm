package org.dzhou.research.cci.treegraph;

/**
 * Practice of "cracking the code interview"
 * 
 * Given a stored (increasing order) array with unique integer element, write an
 * algorithm to create a binary search tree with minimal height;
 * 
 * @author DONG ZHOU
 *
 */
public class MinimalTree {

	class TreeNode<T> {
		T value;
		TreeNode<T> left;
		TreeNode<T> right;

		TreeNode(T value) {
			this.value = value;
		}
	}

	public class Solution<T> {

		TreeNode<T> createMinimalBST(T[] array) {
			return createMinimalBST(array, 0, array.length - 1);
		}

		TreeNode<T> createMinimalBST(T[] array, int start, int end) {
			if (start > end)
				return null;
			int mid = (start + end) / 2;
			TreeNode<T> node = new TreeNode<>(array[mid]);
			node.left = createMinimalBST(array, start, mid - 1);
			node.right = createMinimalBST(array, mid + 1, end);
			return node;
		}

	}

}
