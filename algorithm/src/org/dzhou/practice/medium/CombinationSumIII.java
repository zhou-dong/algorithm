package org.dzhou.practice.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * Example 1:
 * 
 * Input: k = 3, n = 7
 * 
 * Output:
 * 
 * [[1,2,4]]
 * 
 * Example 2:
 * 
 * Input: k = 3, n = 9
 * 
 * Output:
 * 
 * [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * @author zhoudong
 *
 */
public class CombinationSumIII {

	public List<List<Integer>> combinationSum3(int k, int n) {
		if (k < 0 || k > 9)
			return Collections.emptyList();
		List<List<Integer>> result = new LinkedList<>();
		helper(k, 1, n, 0, new LinkedList<>(), result);
		return result;
	}

	private void helper(int k, int cur, int remainder, int prevVal, List<Integer> list, List<List<Integer>> result) {
		if (cur == k) {
			if (remainder > prevVal && remainder <= 9) {
				list.add(remainder);
				result.add(new LinkedList<>(list));
				list.remove(list.size() - 1);
			}
		} else if (cur < k) {
			for (int i = prevVal + 1; i <= 9 - (k - cur); i++) {
				list.add(i);
				helper(k, cur + 1, remainder - i, i, list, result);
				list.remove(list.size() - 1);
			}
		}
	}

}
