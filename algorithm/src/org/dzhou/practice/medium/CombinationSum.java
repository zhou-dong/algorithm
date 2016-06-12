package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. The solution
 * set must not contain duplicate combinations. For example, given candidate set
 * 
 * [2, 3, 6, 7] and target 7, A solution set is: [ [7], [2, 2, 3] ]
 * 
 * @author zhoudong
 *
 *         参考：http://blog.csdn.net/linhuanmars/article/details/20828631
 *
 *         这个题是一个NP问题。基本思路是先排好序，然后每次递归中把剩下的元素一一加到结果集合中，并且把目标减去加入的元素，然后把剩下元素（
 *         包括当前加入的元素）放到下一层递归中解决子问题。算法复杂度因为是NP问题，所以自然是指数量级的。
 */
public class CombinationSum {

	public class Solution {
		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			if (candidates == null || candidates.length == 0)
				return Collections.emptyList();
			Arrays.sort(candidates);
			List<List<Integer>> result = new ArrayList<>();
			helper(candidates, 0, target, new ArrayList<>(), result);
			return result;
		}

		private void helper(int[] candidates, int start, int target, List<Integer> item, List<List<Integer>> res) {
			if (target < 0)
				return;
			if (target == 0) {
				res.add(new ArrayList<Integer>(item));
				return;
			}
			for (int i = start; i < candidates.length; i++) {
				if (i > 0 && candidates[i] == candidates[i - 1])
					continue;
				item.add(candidates[i]);
				helper(candidates, i, target - candidates[i], item, res);
				item.remove(item.size() - 1);
			}
		}

	}

}
