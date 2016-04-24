package org.dzhou.review.tree;

/**
 * @author DONG ZHOU
 */
public class AvlTree<T extends Comparable<T>> {

	class AvlNode {
		T element;
		AvlNode left;
		AvlNode right;
		int height;

		public AvlNode(T element) {
			this(element, null, null);
		}

		public AvlNode(T element, AvlNode left, AvlNode right) {
			this.element = element;
			this.left = left;
			this.right = right;
			this.height = 0;
		}
	}

	private AvlNode root = null;

	private AvlNode findMin(AvlNode node) {
		if (node == null)
			return node;
		while (node.left != null)
			node = node.left;
		return node;
	}

	private AvlNode findMax(AvlNode node) {
		if (node == null)
			return node;
		while (node.right != null)
			node = node.right;
		return node;
	}

	private AvlNode rotateWithLeftChild(AvlNode node) {
		return null;
	}

	private AvlNode rotateWithRightChild(AvlNode node) {
		return null;
	}

	private AvlNode doubleRotateWithLeftChild(AvlNode node) {
		return null;
	}

	private AvlNode doubleRotateWithRightChild(AvlNode node) {
		return null;
	}

}
