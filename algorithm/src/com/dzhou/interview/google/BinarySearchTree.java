package com.dzhou.interview.google;

public class BinarySearchTree {

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int value;

		TreeNode(int value) {
			this.value = value;
		}
	}

	TreeNode root;

	public void insert(int value) {
		if (root == null) {
			root = new TreeNode(value);
		}
		insert(root, value);
	}

	private void insert(TreeNode node, int value) {
		if (node.value < value) {
			if (node.right == null) {
				node.right = new TreeNode(value);
			} else {
				insert(node.right, value);
			}
		} else {
			if (node.left == null) {
				node.left = new TreeNode(value);
			} else {
				insert(node.left, value);
			}
		}
	}

	public boolean find(int value) {
		return (root == null) ? false : find(root, value);
	}

	public boolean find(TreeNode node, int value) {
		if (node == null)
			return false;
		if (node.value == value)
			return true;
		if (node.value < value) {
			return find(node.right, value);
		} else {
			return find(node.left, value);
		}
	}

}
