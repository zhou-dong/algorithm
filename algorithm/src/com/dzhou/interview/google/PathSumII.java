package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 113. Path Sum II
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * @author zhoudong
 *
 */
public class PathSumII {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class DFS_Solution {
		public List<List<Integer>> pathSum(TreeNode root, int sum) {
			if (root == null)
				return Collections.emptyList();
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> item = new ArrayList<>();
			item.add(root.val);
			dfs(root, sum - root.val, result, item);
			return result;
		}

		private void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> item) {
			if (root.left == null && root.right == null) {
				if (sum == 0) {
					result.add(new ArrayList<>(item));
				}
			}
			if (root.left != null) {
				item.add(root.left.val);
				dfs(root.left, sum - root.left.val, result, item);
				item.remove(item.size() - 1);
			}
			if (root.right != null) {
				item.add(root.right.val);
				dfs(root.right, sum - root.right.val, result, item);
				item.remove(item.size() - 1);
			}
		}
	}

}
