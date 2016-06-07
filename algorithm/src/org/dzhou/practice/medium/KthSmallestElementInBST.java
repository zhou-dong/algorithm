package org.dzhou.practice.medium;

import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note:<br>
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up:<br>
 * What if the BST is modified (insert/delete operations) often and you need to
 * find the kth smallest frequently? How would you optimize the kthSmallest
 * routine?
 * 
 * Hint:<br>
 * Try to utilize the property of a BST.<br>
 * What if you could modify the BST node's structure?<br>
 * The optimal runtime complexity is O(height of BST).<br>
 * 
 * @author zhoudong
 *
 */
public class KthSmallestElementInBST {

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

		public int kthSmallest(TreeNode root, int k) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			TreeNode p = root;
			int result = 0;
			while (p != null || !stack.isEmpty()) {
				if (p != null) {
					stack.push(p);
					p = p.left;
				} else {
					TreeNode temp = stack.pop();
					k--;
					if (k == 0) {
						result = temp.val;
					}
					p = temp.right;
				}
			}
			return result;
		}

	}

}
