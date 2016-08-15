package org.dzhou.practice.medium.premium;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 * 
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * 
 * For example:
 * 
 * Given binary tree,
 * 
 * --------------5 <br>
 * -------------/-\ <br>
 * ------------1---5 <br>
 * -----------/-\---\ <br>
 * ----------5---5---5 <br>
 * 
 * return 4.
 * 
 * @author zhoudong
 *
 */
public class CountUnivalueSubtrees {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Solution {

		int count = 0;

		public int countUnivalSubtrees(TreeNode root) {
			dfs(root);
			return count;
		}

		private boolean dfs(TreeNode root) {
			if (root == null)
				return true;
			if (root.left == null && root.right == null) {
				count++;
				return true;
			}
			boolean left = dfs(root.left);
			boolean right = dfs(root.right);
			if (left && right && (root.left == null || root.left.val == root.val)
					&& (root.right == null || root.right.val == root.val)) {
				count++;
				return true;
			}
			return false;
		}

	}

}
