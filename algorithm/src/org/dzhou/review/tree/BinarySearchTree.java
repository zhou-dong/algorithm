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

	public T search(T object) {
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

}
