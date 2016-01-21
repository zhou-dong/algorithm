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
public class Subtree<T> {

	boolean containsTree(TreeNode<T> t1, TreeNode<T> t2) {
		StringBuffer string1 = new StringBuffer();
		StringBuffer string2 = new StringBuffer();
		getOrderString(t1, string1);
		getOrderString(t2, string2);
		return string1.indexOf(string2.toString()) != -1;
	}

	void getOrderString(TreeNode<T> node, StringBuffer stringBuffer) {
		if (node == null) {
			stringBuffer.append("X");
			return;
		}
		stringBuffer.append(node.getData());
		getOrderString(node.getLeft(), stringBuffer);
		getOrderString(node.getRight(), stringBuffer);
	}

}
