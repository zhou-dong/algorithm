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

	// iterator binary search tree
	public class Solution1 {

		public int closestValue(TreeNode root, double target) {
			int closest = root.val;
			while (root != null) {
				if (root.val == target)
					return root.val;
				closest = Math.abs(closest - target) > Math.abs(root.val - target) ? root.val : closest;
				root = target < root.val ? root.left : root.right;
			}
			return closest;
		}

	}

	// traversal binary tree
	public class Solution2 {

		private double min;
		private int result;

		public int closestValue(TreeNode root, double target) {
			update(Math.abs(root.val - target), root.val);
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
				update(distance, val);
			}
		}

		private void update(double distance, int val) {
			this.min = distance;
			this.result = val;
		}
	}

}
