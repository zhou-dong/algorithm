package org.dzhou.interview.treeandgraph;

/**
 * Practice of "cracking the code interview"
 * 
 * T1 and T2 are two very large binary trees ,with T1 much bigger than T2.
 * Create an algorithm to determine if T2 is a subtree of T1.
 * 
 * A tree of T2 is a subtree of T1 if there exits a node in T1 such that the
 * subtree of n is identical to T2. That is, if you cut off the tree at node n,
 * the two trees would be identical.
 * 
 * @author DONG ZHOU
 *
 */
public class Subtree2<T> {

	boolean containsTree(TreeNode<T> t1, TreeNode<T> t2) {
		if (t2 == null)
			return true;
		return subTree(t1, t2);
	}

	boolean subTree(TreeNode<T> t1, TreeNode<T> t2) {
		if (t1 == null)
			return false;
		else if (t1.getData() == t2.getData() || matchTree(t1, t2))
			return true;
		return subTree(t1.getLeft(), t2) || subTree(t1.getRight(), t2);
	}

	boolean matchTree(TreeNode<T> t1, TreeNode<T> t2) {
		if (t1 == null && t2 == null)
			return true;
		else if (t1 == null || t2 == null)
			return false;
		else if (t1.getData() != t2.getData())
			return false;
		else
			return matchTree(t1.getLeft(), t2.getLeft()) && matchTree(t1.getRight(), t2.getRight());
	}

}
