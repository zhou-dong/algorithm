package org.dzhou.interview.treeandgraph;

/**
 * Practice of "cracking the code interview"
 * 
 * Write an algorithm to find the "next" node.(i.e. in-order successor) of a
 * given node in a binary search tree. You may assume that each node has a link
 * to its patent.
 * 
 * @author DONG ZHOU
 *
 */
public class Successor {

	public TreeNode<?> inOrderSuccessor(TreeNode<?> node) {
		if (node == null)
			return null;
		if (node.getRight() != null)
			return leftMostChild(node.getRight());
		else {
			TreeNode<?> parent = node;
			TreeNode<?> successor = node.getParent();
			while (successor != null && successor.getLeft() != parent) {
				parent = successor;
				successor = successor.getParent();
			}
			return successor;
		}
	}

	TreeNode<?> leftMostChild(TreeNode<?> node) {
		if (node == null)
			return null;
		while (node.getLeft() != null)
			node = node.getLeft();
		return node;
	}

}
