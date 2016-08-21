package org.dzhou.practice.medium.premium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Numbers can be regarded as product of its factors. For example,
 * 
 * 8 = 2 x 2 x 2; = 2 x 4.
 * 
 * Write a function that takes an integer n and return all possible combinations
 * of its factors.
 * 
 * Note:<br>
 * You may assume that n is always positive. <br>
 * Factors should be greater than 1 and less than n. <br>
 * 
 * @author zhoudong
 *
 */
public class FactorCombinations {

	public class Solution {
		public List<List<Integer>> getFactors(int n) {
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> list = new ArrayList<>();
			helper(n, 2, list, result);
			return result;
		}

		public void helper(int n, int start, List<Integer> list, List<List<Integer>> result) {
			if (n == 1) {
				if (list.size() > 1)
					result.add(new ArrayList<Integer>(list));
				return;
			}
			for (int i = start; i <= Math.sqrt(n); i++) { // 这里只要到根号n就好了
				if (n % i == 0) {
					list.add(i);
					helper(n / i, i, list, result);
					list.remove(list.size() - 1);
				}
			}
			list.add(n); // 把n加进去
			helper(1, n, list, result);
			list.remove(list.size() - 1);
		}

	}

}
