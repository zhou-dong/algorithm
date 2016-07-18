package org.dzhou.research.cci.treegraph;

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
public class CheckSubtree {

	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	// pre-order traversal
	public class Solution {
		boolean containsTree(TreeNode t1, TreeNode t2) {
			String s1 = preOrderTraversal(t1);
			String s2 = preOrderTraversal(t2);
			return s1.indexOf(s2) != -1;
		}

		String preOrderTraversal(TreeNode node) {
			StringBuilder sb = new StringBuilder();
			preOrderTraversal(node, sb);
			return sb.toString();
		}

		void preOrderTraversal(TreeNode node, StringBuilder sb) {
			if (node == null) {
				sb.append("x");
				return;
			}
			sb.append(node.data);
			preOrderTraversal(node.left, sb);
			preOrderTraversal(node.right, sb);
		}
	}

	public class Solution1 {
		boolean containsTree(TreeNode t1, TreeNode t2) {
			if (t2 == null)
				return true;
			return subTree(t1, t2);
		}

		boolean subTree(TreeNode t1, TreeNode t2) {
			if (t1 == null)
				return false;
			else if (t1.data == t2.data && matchTree(t1, t2))
				return true;
			return subTree(t1.left, t2) || subTree(t1.right, t2);
		}

		boolean matchTree(TreeNode t1, TreeNode t2) {
			if (t1 == null || t2 == null)
				return true;
			else if (t1 == null || t2 == null)
				return false;
			else if (t1.data != t2.data)
				return false;
			else
				return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
		}
	}

}
