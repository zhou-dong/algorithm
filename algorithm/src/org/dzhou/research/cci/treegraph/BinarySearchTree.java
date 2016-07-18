package org.dzhou.research.cci.treegraph;

/**
 * Implement of Binary Search Tree
 * 
 * @author zhoudong
 *
 */
public class BinarySearchTree<T extends Comparable<T>> {

	class TreeNode {
		T data;
		TreeNode left;
		TreeNode right;
		int size;

		TreeNode(T data) {
			this.data = data;
		}

		public void insert(T data) {
			if (data.compareTo(this.data) <= 0) {
				if (this.left == null) {
					this.left = new TreeNode(data);
				} else {
					this.left.insert(data);
				}
			} else {
				if (this.right == null) {
					this.right = new TreeNode(data);
				} else {
					this.right.insert(data);
				}
			}
			this.size++;
		}

		public TreeNode find(T data) {
			if (data == this.data) {
				return this;
			} else if (data.compareTo(this.data) < 0) {
				return (this.left == null) ? null : this.left.find(data);
			} else {
				return (this.right == null) ? null : this.right.find(data);
			}
		}

		public TreeNode getIthNode(int i) {
			if (i < 0 || i >= size)
				return null;
			int leftSize = (left == null) ? 0 : left.size;
			if (i == leftSize)
				return this;
			else if (i < leftSize) {
				return this.left.getIthNode(i);
			} else {
				return this.right.getIthNode(i - (leftSize + 1));
			}
		}
	}

	private TreeNode root;

	public boolean insert(T data) {
		if (root == null) {
			root = new TreeNode(data);
			return true;
		}
		TreeNode current = root;
		TreeNode parent = null;
		int compare = 0;
		if (current != null) {
			parent = current;
			compare = data.compareTo(current.data);
			if (compare == 0) {
				return false;
			} else if (compare < 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (compare < 0) {
			parent.left = new TreeNode(data);
		} else {
			parent.right = new TreeNode(data);
		}
		return true;
	}

	public TreeNode find(T data) {
		TreeNode current = root;
		while (current != null) {
			int compare = data.compareTo(current.data);
			if (compare == 0) {
				return current;
			} else if (compare < 0) {
				current = current.left;
			} else
				current = current.right;
		}
		return null;
	}

	public boolean contains(T data) {
		return find(data) == null ? false : true;
	}

	public void insert(TreeNode node, T data) {
		if (node == null)
			return;
		node.insert(data);
	}

	public TreeNode find(TreeNode node, T data) {
		return node == null ? null : node.find(data);
	}

}
