package org.dzhou.interview.treeandgraph;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 */
public class Traversal {

	public void inOrderTraversal(TreeNode<?> node) {
		if (node != null) {
			inOrderTraversal(node.getLeft());
			visit(node);
			inOrderTraversal(node.getRight());
		}
	}

	public void preOrderTraversal(TreeNode<?> node) {
		if (node != null) {
			visit(node);
			preOrderTraversal(node.getLeft());
			preOrderTraversal(node.getRight());
		}
	}

	public void postOrderTraversal(TreeNode<?> node) {
		if (node != null) {
			postOrderTraversal(node.getLeft());
			postOrderTraversal(node.getRight());
			visit(node);
		}
	}

	public void visit(TreeNode<?> node) {

	}

}
