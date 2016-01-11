package org.dzhou.interview.treeandgraph;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 */
public class Traversal {

	public void inOrderTraversal(TreeNode<?> node) {
		if (node == null)
			return;
		inOrderTraversal(node.left);
		visit(node);
		inOrderTraversal(node.right);
	}

	public void preOrderTraversal(TreeNode<?> node) {
		if (node == null)
			return;
		visit(node);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	public void postOrderTraversal(TreeNode<?> node) {
		if (node == null)
			return;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		visit(node);
	}

	public void visit(TreeNode<?> node) {

	}

}
