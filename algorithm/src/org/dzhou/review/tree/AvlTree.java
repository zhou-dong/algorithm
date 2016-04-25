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

	public AvlNode findMin() {
		return findMin(root);
	}

	private AvlNode findMin(AvlNode node) {
		if (node == null)
			return node;
		while (node.left != null)
			node = node.left;
		return node;
	}

	public AvlNode findMax() {
		return findMax(root);
	}

	private AvlNode findMax(AvlNode node) {
		if (node == null)
			return node;
		while (node.right != null)
			node = node.right;
		return node;
	}

	public AvlNode find(T t) {
		return find(t, root);
	}

	private AvlNode find(T t, AvlNode node) {
		while (node != null) {
			int compare = t.compareTo(node.element);
			if (compare == 0)
				return node;
			else if (compare < 0)
				node = node.left;
			else
				node = node.right;
		}
		return null;
	}

	private AvlNode rotateWithLeftChild(AvlNode node) {
		AvlNode left = node.left;
		node.left = left.right;
		left.right = node;
		node.height = max(height(node.left), height(node.right)) + 1;
		left.height = max(height(left.left), node.height) + 1;
		return left;
	}

	private AvlNode rotateWithRightChild(AvlNode node) {
		AvlNode right = node.right;
		node.right = right.left;
		right.left = node;
		node.height = max(height(node.left), height(node.right)) + 1;
		right.height = max(node.height, height(right.right)) + 1;
		return right;
	}

	private AvlNode doubleRotateWithLeftChild(AvlNode node) {
		node.left = rotateWithRightChild(node.left);
		return rotateWithLeftChild(node);
	}

	private AvlNode doubleRotateWithRightChild(AvlNode node) {
		node.right = rotateWithLeftChild(node.right);
		return rotateWithRightChild(node);
	}

	private int height(AvlNode node) {
		return node == null ? -1 : node.height;
	}

	private int max(int x, int y) {
		return x > y ? x : y;
	}

	public void insert(T x) {
		root = insert(x, root);
	}

	private AvlNode insert(T x, AvlNode t) {
		if (t == null)
			t = new AvlNode(x, null, null);
		else if (x.compareTo(t.element) < 0) {
			t.left = insert(x, t.left);
			if (height(t.left) - height(t.right) == 2)
				if (x.compareTo(t.left.element) < 0)
					t = rotateWithLeftChild(t);
				else
					t = doubleRotateWithLeftChild(t);
		} else if (x.compareTo(t.element) > 0) {
			t.right = insert(x, t.right);
			if (height(t.right) - height(t.left) == 2)
				if (x.compareTo(t.right.element) > 0)
					t = rotateWithRightChild(t);
				else
					t = doubleRotateWithRightChild(t);
		} else
			; // Duplicate; do nothing
		t.height = max(height(t.left), height(t.right)) + 1;
		return t;
	}

}
