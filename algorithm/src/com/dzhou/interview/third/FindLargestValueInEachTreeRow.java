package com.dzhou.interview.third;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. Find Largest Value in Each Tree Row
 * 
 * You need to find the largest value in each row of a binary tree.
 * 
 * @author zhoudong
 *
 */
public class FindLargestValueInEachTreeRow {

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

		public List<Integer> largestValues(TreeNode root) {
			if (root == null) {
				return Collections.emptyList();
			}

			List<Integer> result = new LinkedList<>();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				int size = queue.size();
				int max = Integer.MIN_VALUE;
				for (int i = 0; i < size; i++) {
					TreeNode curr = queue.poll();
					if (curr.val > max) {
						max = curr.val;
					}
					if (curr.left != null) {
						queue.add(curr.left);
					}
					if (curr.right != null) {
						queue.add(curr.right);
					}
				}
				result.add(max);
			}

			return result;
		}

	}

}
