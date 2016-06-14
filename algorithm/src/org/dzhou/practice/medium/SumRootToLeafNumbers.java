package org.dzhou.practice.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * --1<br>
 * -/-\<br>
 * 2---3
 * 
 * The root-to-leaf path 1->2 represents the number 12.<br>
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 * @author zhoudong
 *
 */
public class SumRootToLeafNumbers {

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

		public int sumNumbers(TreeNode root) {

			if (root == null)
				return 0;

			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);

			int sum = 0, parent = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();
				parent *= 10;
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					sum += (node.val + parent);
					if (node.left != null)
						queue.add(node.left);
					if (node.right != null)
						queue.add(node.right);
				}
				parent = sum;
				sum = 0;
			}

			return parent;
		}

	}

}
