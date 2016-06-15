package org.dzhou.practice.medium;

/**
 * The thief has found himself a new place for his thievery again. There is only
 * one entrance to this area, called the "root." Besides the root, each house
 * has one and only one parent house. After a tour, the smart thief realized
 * that "all houses in this place forms a binary tree". It will automatically
 * contact the police if two directly-linked houses were broken into on the same
 * night.
 * 
 * Determine the maximum amount of money the thief can rob tonight without
 * alerting the police.
 * 
 * Example 1:<br>
 * -----3<br>
 * ----/-\<br>
 * ---2---3<br>
 * ----\---\ <br>
 * -----3---1<br>
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.<br>
 * 
 * Example 2:<br>
 * -----3<br>
 * ----/-\<br>
 * ---4---5<br>
 * --/-\---\ <br>
 * -1---3---1<br>
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 * 
 * @author zhoudong
 *
 */
public class HouseRobberIII {

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

		public int rob(TreeNode root) {
			return robHelper(root)[1];
		}

		private int[] robHelper(TreeNode root) {
			int[] rob = { 0, 0 };
			if (root != null) {
				int[] robLeft = robHelper(root.left);
				int[] robRight = robHelper(root.right);
				rob[0] = robLeft[1] + robRight[1];
				rob[1] = Math.max(robLeft[0] + robRight[0] + root.val, rob[0]);
			}
			return rob;
		}

	}

}
