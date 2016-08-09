package org.dzhou.practice.easy.premium;

/**
 * Given a non-empty binary search tree and a target value, find the value in
 * the BST that is closest to the target.
 * 
 * Note: <br>
 * Given target value is a floating point. <br>
 * You are guaranteed to have only one unique value in the BST that is closest
 * to the target.
 * 
 * @author zhoudong
 *
 */
public class ClosestBinarySearchTreeValue {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// traversal binary search tree
	public class Solution {

		public int closestValue(TreeNode root, double target) {
			if (root.val == target)
				return root.val;
			TreeNode child = target < root.val ? root.left : root.right;
			if (child == null)
				return root.val;
			int childDistance = closestValue(child, target);
			return Math.abs(root.val - target) > Math.abs(childDistance - target) ? childDistance : root.val;
		}

	}

	// traversal binary tree
	public class Solution1 {

		private double min;
		private int result;

		public int closestValue(TreeNode root, double target) {
			min = Math.abs(root.val - target);
			result = root.val;
			helper(root, target);
			return result;
		}

		private void helper(TreeNode root, double target) {
			if (root == null)
				return;
			execute(target, root.val);
			helper(root.left, target);
			helper(root.right, target);
		}

		private void execute(double target, int val) {
			double distance = Math.abs(target - val);
			if (distance < min) {
				min = distance;
				result = val;
			}
		}

	}

}
