package org.dzhou.interview.treeandgraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 */
public class Traversal {

	public void levelOrderTraversal(TreeNode<?> node) {
		Queue<TreeNode<?>> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			TreeNode<?> current = queue.poll();
			visit(current);
			if (current.getLeft() != null) {
				queue.add(current.getLeft());
			}
			if (current.getRight() != null) {
				queue.add(current.getRight());
			}
		}
	}

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
