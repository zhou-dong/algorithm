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
		if (node.right != null)
			return leftMostChild(node.right);
		else {
			TreeNode<?> parent = node;
			TreeNode<?> successor = node.parent;
			while (successor != null && successor.left != parent) {
				parent = successor;
				successor = successor.parent;
			}
			return successor;
		}
	}

	TreeNode<?> leftMostChild(TreeNode<?> node) {
		if (node == null)
			return null;
		while (node.left != null)
			node = node.left;
		return node;
	}

}
