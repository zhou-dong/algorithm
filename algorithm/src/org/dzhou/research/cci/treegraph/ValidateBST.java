package org.dzhou.research.cci.treegraph;

import java.util.LinkedList;
import java.util.List;

/**
 * Practice of "cracking the code interview"
 * 
 * Implement a function to check if a binary tree is a binary search tree.
 * 
 * @author DONG ZHOU
 *
 *         1. in order traversal to copy all node into a array, then check<br>
 *         如果有相同value的两个node的话，这种方法结果可能会错误。<br>
 * 
 *         2. Optimize first solution
 * 
 *         3. current node data bigger than left children data, so it is max
 *         than children; current node data should less than right children
 *         data, so it is minimum data than right children.
 * 
 */
public class ValidateBST {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public class Solution {
		boolean checkBST(TreeNode root) {
			List<Integer> values = new LinkedList<>();
			copyValues(root, values);
			for (int i = 1; i < values.size(); i++) {
				if (values.get(i) <= values.get(i - 1))
					return false;
			}
			return true;
		}

		private void copyValues(TreeNode root, List<Integer> values) {
			if (root != null) {
				copyValues(root.left, values);
				values.add(root.val);
				copyValues(root.right, values);
			}
		}
	}

	public class Solution1 {
		Integer lastValue = null;

		boolean checkBST(TreeNode root) {
			if (root == null)
				return true;
			if (!checkBST(root.left))
				return false;
			if (lastValue != null && root.val <= lastValue)
				return false;
			lastValue = root.val;
			if (!checkBST(root.right))
				return false;
			return true;
		}
	}

	public class Solution2 {
		boolean checkBST(TreeNode root) {
			return checkBST(root, null, null);
		}

		boolean checkBST(TreeNode root, Integer min, Integer max) {
			if (root == null)
				return true;
			if ((min != null && root.val <= min) || (max != null && root.val > max))
				return false;
			return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
		}
	}

}
