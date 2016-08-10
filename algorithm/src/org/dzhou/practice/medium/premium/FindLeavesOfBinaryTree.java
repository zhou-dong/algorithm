package org.dzhou.practice.medium.premium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this:
 * Collect and remove all leaves, repeat until the tree is empty.
 * 
 * Example: <br>
 * Given binary tree <br>
 * ----------1 <br>
 * ---------/-\ <br>
 * --------2---3 <br>
 * -------/-\ <br>
 * ------4---5 <br>
 * Returns [4, 5, 3], [2], [1].
 * 
 * Explanation:<br>
 * 1. Removing the leaves [4, 5, 3] would result in this tree: <br>
 * ----------1 <br>
 * ---------/ <br>
 * --------2 <br>
 * 
 * 2. Now removing the leaf [2] would result in this tree: <br>
 * ---------1 <br>
 * 
 * 3. Now removing the leaf [1] would result in the empty tree: <br>
 * [] <br>
 * Returns [4, 5, 3], [2], [1].
 * 
 * @author zhoudong
 *
 */
public class FindLeavesOfBinaryTree {

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

		public List<List<Integer>> findLeaves(TreeNode root) {
			if (root == null)
				return Collections.emptyList();
			List<List<Integer>> result = new ArrayList<>();
			traversal(root, result);
			return result;
		}

		private int traversal(TreeNode root, List<List<Integer>> result) {
			if (root == null) {
				return -1;
			}
			int levelLeft = traversal(root.left, result);
			int levelRight = traversal(root.right, result);
			int level = Math.max(levelLeft, levelRight) + 1;
			if (result.size() <= level)
				result.add(level, new ArrayList<>());
			result.get(level).add(root.val);
			return level;
		}

	}

}
