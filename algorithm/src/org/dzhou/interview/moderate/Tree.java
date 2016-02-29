package org.dzhou.interview.moderate;

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;

	public TreeNode(int value) {
		this.value = value;
	}
}

public class Tree {

	private TreeNode root;

	public void add(int item) {
		if (root == null) {
			root = new TreeNode(item);
			return;
		}
		TreeNode node = root;
		while (true) {
			if (item < node.value) {
				if (node.left == null) {
					node.left = new TreeNode(item);
					break;
				}
				node = node.left;
			} else {
				if (node.right == null) {
					node.right = new TreeNode(item);
					break;
				}
				node = node.right;
			}
		}
	}

	public void inOrderTraverse(TreeNode root) {
		if (root != null) {
			inOrderTraverse(root.left);
			System.out.println(root.value);
			inOrderTraverse(root.right);
		}
	}

	public void preOrderTraverse(TreeNode root) {
		if (root != null) {
			System.out.println(root.value);
			inOrderTraverse(root.left);
			inOrderTraverse(root.right);
		}
	}

	public void postOrderTraverse(TreeNode root) {
		if (root != null) {
			inOrderTraverse(root.left);
			inOrderTraverse(root.right);
			System.out.println(root.value);
		}
	}

}
