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
public class CommonAncestor<T> {

	TreeNode<T> commonAncestor(TreeNode<T> p, TreeNode<T> q) {
		if (p == q)
			return p;
		int delta = depth(p) - depth(q);
		TreeNode<T> first = delta > 0 ? q : p;
		TreeNode<T> second = delta > 0 ? p : q;
		second = goUpBy(second, Math.abs(delta));
		while (first != null && second != null && first != second) {
			first = first.getParent();
			second = second.getParent();
		}
		return (first == null || second == null) ? null : first;
	}

	TreeNode<T> goUpBy(TreeNode<T> node, int delta) {
		while (delta > 0 && node != null) {
			node = node.getParent();
			delta--;
		}
		return node;
	}

	int depth(TreeNode<T> node) {
		int depth = 0;
		while (node != null) {
			node = node.getParent();
			depth++;
		}
		return depth;
	}

}
