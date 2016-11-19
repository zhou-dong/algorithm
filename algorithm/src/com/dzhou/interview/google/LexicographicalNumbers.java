package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.List;

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

	public List<Integer> lexicalOrder(int n) {
		List<Integer> result = new ArrayList<>();
		backtrack(result, 1, n);
		return result;
	}

	private void backtrack(List<Integer> result, int start, int n) {
		if (start > n)
			return;
		result.add(start);
		backtrack(result, start * 10, n);
		if (start % 10 == 9)
			return;
		backtrack(result, start + 1, n);
	}

}
