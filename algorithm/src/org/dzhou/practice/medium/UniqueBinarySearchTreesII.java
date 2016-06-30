package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1...n.
 * 
 * For example,
 * 
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 
 * @author zhoudong
 *
 *         以i为根节点的树，其左子树由[1, i-1]构成， 其右子树由[i+1, n]构成。
 */
public class UniqueBinarySearchTreesII {

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

		public List<TreeNode> generateTrees(int n) {
			if (n < 1)
				return Collections.emptyList();
			return generateTrees(1, n);
		}

		private List<TreeNode> generateTrees(int left, int right) {
			List<TreeNode> result = new ArrayList<TreeNode>();
			if (left > right) {
				result.add(null);
				return result;
			}
			for (int i = left; i <= right; i++) {
				// 以i作为根节点，左子树由[1,i-1]构成
				List<TreeNode> lefts = generateTrees(left, i - 1);
				// 右子树由[i+1, n]构成
				List<TreeNode> rights = generateTrees(i + 1, right);
				for (int j = 0; j < lefts.size(); j++) {
					for (int k = 0; k < rights.size(); k++) {
						TreeNode root = new TreeNode(i);
						root.left = lefts.get(j);
						root.right = rights.get(k);
						result.add(root);// 存储所有可能行
					}
				}
			}
			return result;
		}

	}

}
