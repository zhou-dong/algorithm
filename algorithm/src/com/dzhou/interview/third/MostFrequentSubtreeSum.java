package com.dzhou.interview.third;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 508. Most Frequent Subtree Sum
 * 
 * @author zhoudong
 *
 */
public class MostFrequentSubtreeSum {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {

		public int[] findFrequentTreeSum(TreeNode root) {
			int[] max = { 0 };
			Map<Integer, Integer> map = new HashMap<>();
			subtreeSum(root, map, max);

			List<Integer> result = new LinkedList<>();
			for (int key : map.keySet()) {
				if (map.get(key) == max[0]) {
					result.add(key);
				}
			}
			return listToArray(result);
		}

		private int subtreeSum(TreeNode root, Map<Integer, Integer> map, int[] max) {
			if (root == null)
				return 0;
			int sum = root.val + subtreeSum(root.left, map, max) + subtreeSum(root.right, map, max);
			int count = map.getOrDefault(sum, 0) + 1;
			map.put(sum, count);
			if (count > max[0]) {
				max[0] = count;
			}
			return sum;
		}

		private int[] listToArray(List<Integer> list) {
			int[] result = new int[list.size()];
			for (int i = 0; i < result.length; i++)
				result[i] = list.get(i);
			return result;
		}

	}
}
