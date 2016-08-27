package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 386. Lexicographical Numbers QuestionEditorial Solution My Submissions
 * 
 * Difficulty: Medium
 * 
 * Given an integer n, return 1 - n in lexicographical order.
 * 
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * 
 * Please optimize your algorithm to use less time and space. The input size may
 * be as large as 5,000,000.
 * 
 * @author zhoudong
 *
 */
public class LexicographicalNumbers {

	public class Solution {

		public List<Integer> lexicalOrder(int n) {
			List<Integer> result = new ArrayList<Integer>();
			solve(result, n, 1);
			return result;
		}

		private void solve(List<Integer> result, int n, int m) {
			result.add(m);
			if (m * 10 <= n) {
				solve(result, n, m * 10);
			}
			if (m < n && m % 10 < 9) {
				solve(result, n, m + 1);
			}
		}
	}
}
