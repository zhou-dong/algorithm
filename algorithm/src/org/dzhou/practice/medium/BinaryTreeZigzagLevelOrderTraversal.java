package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * For example:
 * 
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ----3<br>
 * ---/-\<br>
 * --9--20<br>
 * ----/--\<br>
 * ---15---7<br>
 * 
 * return its zigzag level order traversal as:
 * 
 * [<br>
 * [3],<br>
 * [20,9],<br>
 * [15,7]<br>
 * ]<br>
 * 
 * @author zhoudong
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {

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

		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			if (root == null)
				return Collections.emptyList();

			List<List<Integer>> result = new ArrayList<>();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);

			boolean reverse = false;
			while (!queue.isEmpty()) {
				List<Integer> item = new ArrayList<>();
				int size = queue.size();

				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					item.add(node.val);
					if (node.left != null)
						queue.add(node.left);
					if (node.right != null)
						queue.add(node.right);
				}

				if (reverse) {
					Collections.reverse(item);
					reverse = false;
				} else {
					reverse = true;
				}
				result.add(item);
			}
			return result;
		}

	}

}
