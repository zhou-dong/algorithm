package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * For example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * ------5<br>
 * -----/-\<br>
 * ----4---8<br>
 * ---/---/-\<br>
 * --11--13--4<br>
 * -/--\----/-\<br>
 * 7----2--5---1<br>
 * 
 * return [ [5,4,11,2], [5,8,4,5] ]
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

	public class Solution {

		public List<List<Integer>> pathSum(TreeNode root, int sum) {
			if (root == null)
				return Collections.emptyList();
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			dfs(root, result, new ArrayList<>(), sum, 0);
			return result;
		}

		private void dfs(TreeNode root, List<List<Integer>> result, List<Integer> item, int sum, int val) {
			if (root == null)
				return;
			item.add(root.val);
			val += root.val;
			if (root.right == null && root.left == null && val == sum)
				result.add(new ArrayList<>(item));
			if (root.left != null) {
				dfs(root.left, result, item, sum, val);
				item.remove(item.size() - 1);
			}
			if (root.right != null) {
				dfs(root.right, result, item, sum, val);
				item.remove(item.size() - 1);
			}
		}

	}

}
