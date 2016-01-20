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
public class CommonAncestor3<T> {

	TreeNode<T> commonAncestor(TreeNode<T> root, TreeNode<T> p, TreeNode<T> q) {
		if (!covers(root, p) || !covers(root, q))
			return null;
		return ancestorHelper(root, p, q);
	}

	TreeNode<T> ancestorHelper(TreeNode<T> root, TreeNode<T> p, TreeNode<T> q) {
		if (root == null || p == null || q == null)
			return root;
		boolean pIsOnLeft = covers(root.getLeft(), p);
		boolean qIsOnLeft = covers(root.getLeft(), q);
		if (pIsOnLeft != qIsOnLeft) {
			return root;
		}
		TreeNode<T> childSide = pIsOnLeft ? root.getLeft() : root.getRight();
		return ancestorHelper(childSide, p, q);
	}

	boolean covers(TreeNode<T> root, TreeNode<T> p) {
		if (root == null)
			return false;
		if (root == p)
			return true;
		return covers(root.getLeft(), p) || covers(root.getRight(), p);
	}

}
