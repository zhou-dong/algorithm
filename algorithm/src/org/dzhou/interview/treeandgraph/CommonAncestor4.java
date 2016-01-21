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

	Result commonAncestorHelper(TreeNode<T> root, TreeNode<T> p, TreeNode<T> q) {
		if (root == null)
			return new Result(null, false);
		if (root == p && root == q)
			return new Result(root, true);
		Result rx = commonAncestorHelper(root.getLeft(), p, q);
		if (rx.isAncestor)
			return rx;
		Result ry = commonAncestorHelper(root.getRight(), p, q);
		if (ry.isAncestor)
			return ry;
		if (rx.node != null && ry.node != null)
			return new Result(root, true);
		else if (root == p || root == q) {
			boolean isAncesotr = rx.node != null || ry.node != null;
			return new Result(root, isAncesotr);
		} else
			return new Result(rx.node != null ? rx.node : ry.node, false);
	}

	TreeNode<T> commonAncestor(TreeNode<T> root, TreeNode<T> p, TreeNode<T> q) {
		Result r = commonAncestorHelper(root, p, q);
		if (r.isAncestor)
			return r.node;
		return null;
	}
}
