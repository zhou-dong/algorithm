package org.dzhou.research.cci.treegraph;

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

	class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		TreeNode(int value) {
			this.value = value;
		}
	}

	public class Solution {
		TreeNode inorderSucc(TreeNode node) {
			if (node == null)
				return null;
			if (node.right != null) {
				return leftMostChild(node.right);
			} else {
				TreeNode parent = node.parent;
				while (parent != null && parent.left != node) {
					node = node.parent;
					parent = node.parent;
				}
				return parent;
			}
		}

		TreeNode leftMostChild(TreeNode node) {
			if (node == null)
				return null;
			while (node.left != null)
				node = node.left;
			return node;
		}
	}

}
