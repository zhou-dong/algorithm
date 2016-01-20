package org.dzhou.interview.treeandgraph;

/**
 * Practice of "cracking the code interview"
 * 
 * Design an algorithm and write code find the first common ancestor of two
 * nodes in binary tree. Avoid storing additional nodes in a data structure.
 * NOTE: This is not necessarily a binary search tree.
 * 
 * @author DONG ZHOU
 */
public class CommonAncestor2<T> {

	TreeNode<T> commonAncestor(TreeNode<T> root, TreeNode<T> p, TreeNode<T> q) {
		if (!covers(root, p) || !covers(root, q))
			return null;
		else if (covers(p, q))
			return p;
		else if (covers(q, p))
			return q;
		TreeNode<T> sibling = getSibling(p);
		TreeNode<T> parent = p.getParent();
		while (!covers(sibling, q)) {
			sibling = getSibling(parent);
			parent = parent.getParent();
		}
		return parent;
	}

	TreeNode<T> getSibling(TreeNode<T> node) {
		if (node == null || node.getParent() == null) {
			return null;
		}
		TreeNode<T> parent = node.getParent();
		return parent.getLeft() == node ? parent.getRight() : parent.getLeft();
	}

	boolean covers(TreeNode<T> root, TreeNode<T> p) {
		if (root == null)
			return false;
		if (root == p)
			return true;
		return covers(root.getLeft(), p) || covers(root.getRight(), p);
	}

}
