package org.dzhou.interview.treeandgraph;

/**
 * Practice of "cracking the code interview"
 * 
 * Design an algorithm and write code find the first common ancestor of two
 * nodes in binary tree. Avoid storing additional nodes in a data structure.
 * NOTE: This is not necessarily a binary search tree.
 * 
 * @author DONG ZHOU
 * 
 *         Without links to parents
 */
public class CommonAncestor4<T> {

	class Result {
		public TreeNode<T> node;
		public boolean isAncestor;

		public Result(TreeNode<T> node, boolean isAncestor) {
			this.node = node;
			this.isAncestor = isAncestor;
		}
	}

}
