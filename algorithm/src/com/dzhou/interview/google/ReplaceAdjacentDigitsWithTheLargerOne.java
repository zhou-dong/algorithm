package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer X. You must choose two adjacent digits and replace
 * them with the larger of these two digits. 给定一个integer X. For example, from
 * the integer X = 233614, you can obtain:
 * 
 * 33614 (by replacing 23 with 3); <br>
 * 23614 (by replacing 33 with 3 or 36 with 6); <br>
 * 23364 (by replacing 61 with 6 or 14 with 4); <br>
 * 
 * You want to find the smallest number that can be obtained from X by replacing
 * two adjacent digits with the larger of the two. In the above example, the
 * smallest such number is 23364.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int X); }
 * 
 * that, given a positive integer X, returns the smallest number that can be
 * obtained from X by replacing two adjacent digits with the larger of the two.
 * 
 * For example, given X = 233614, the function should return 23364, as explained
 * above.
 * 
 * Assume that:
 * 
 * X is an integer within the range[10..1,000,000,000].
 * 
 * In your solution, focus on correctness. The performance of your solution will
 * not be the focus of the assessment.
 * 
 * @author zhoudong
 *
 */
public class ReplaceAdjacentDigitsWithTheLargerOne {

	public int Solution(int x) {
		List<Integer> list = convertIntegerToList(x);
		int min = x;
		for (int i = 1; i < list.size(); i++) {
			int smallerIndex = findSmallerIndex(i, list);
			int smallerValue = list.get(smallerIndex);
			list.set(smallerIndex, -1);
			min = Math.min(min, convertListToInteger(list));
			list.set(smallerIndex, smallerValue);
		}
		return min;
	}

	private int findSmallerIndex(int index, List<Integer> list) {
		return list.get(index) < list.get(index - 1) ? index : index - 1;
	}

	public int convertListToInteger(List<Integer> list) {
		int result = 0;
		for (int num : list) {
			if (num != -1) {
				result = result * 10 + num;
			}
		}
		return result;
	}

	public List<Integer> convertIntegerToList(int x) {
		List<Integer> list = new ArrayList<>();
		while (x > 0) {
			list.add(0, x % 10);
			x /= 10;
		}
		return list;
	}

}
