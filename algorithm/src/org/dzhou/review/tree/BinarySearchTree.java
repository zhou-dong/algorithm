package org.dzhou.review.tree;

public class BinarySearchTree<T extends Comparable<T>> {

	class Node {
		T object;
		Node left;
		Node right;

		public Node(T object) {
			this.object = object;
		}
	}

	Node root;

	public T searchNode(T object) {
		Node current = root;
		while (current != null) {
			int compare = current.object.compareTo(object);
			if (compare == 0)
				return current.object;
			else if (compare < 0)
				current = current.left;
			else
				current = current.right;
		}
		return null;
	}

	public void insert(T object) {
		if (root == null) {
			root = new Node(object);
			return;
		}
		Node current = root;
		Node parent = null;
		int compare = 0;
		while (current != null) {
			compare = current.object.compareTo(object);
			if (compare == 0)
				throw new IllegalArgumentException();
			parent = current;
			if (compare < 0)
				current = current.left;
			else
				current = current.right;
		}
		if (compare < 0)
			parent.left = new Node(object);
		else
			parent.right = new Node(object);
	}

	public void remove(T object) {
		if (root == null)
			throw new NullPointerException();
		Node current = root;
		Node parent = null;
		boolean isLeft = false;
		while (current != null) {
			int compare = current.object.compareTo(object);
			if (compare == 0)
				break;
			parent = current;
			if (compare < 0) {
				current = current.left;
				isLeft = true;
			} else {
				current = current.right;
				isLeft = false;
			}
		}
		if (current == null) {
			throw new IllegalArgumentException();
		}
		int childrenNumber = countChildren(current);
		if (childrenNumber == 0) {
			if (parent != null)
				removeLeaf(parent, isLeft);
		} else if (childrenNumber == 1) {
			if (parent != null)
				removeOneChildNode(parent, current, isLeft);
		} else {
		}
	}

	private int countChildren(Node current) {
		if (current.left == null && current.right == null)
			return 0;
		if (current.left != null && current.right != null)
			return 2;
		return 1;
	}

	private void removeLeaf(Node parent, boolean isLeft) {
		if (isLeft)
			parent.left = null;
		else
			parent.right = null;
	}

	private void removeOneChildNode(Node parent, Node current, boolean isLeft) {
		if (isLeft)
			parent.left = getOnlyChild(current);
		else
			parent.right = getOnlyChild(current);
	}

	private Node getOnlyChild(Node node) {
		return node.left != null ? node.left : node.right;
	}

	private void swapData(Node x, Node y) {
		T temp = x.object;
		x.object = y.object;
		y.object = temp;
	}

	private Node findBiggest(Node node) {
		Node current = node;
		while (current.right != null)
			current = current.right;
		return current;
	}

	private Node findSmallest(Node node) {
		Node current = node;
		while (current.left != null)
			current = current.left;
		return current;
	}

}
