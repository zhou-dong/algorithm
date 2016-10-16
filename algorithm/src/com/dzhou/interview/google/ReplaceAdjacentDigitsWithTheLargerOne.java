package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer X. You must choose two adjacent digits and replace
 * them with the larger of these two digits.
 * 
 * For example, from the integer X = 233614, you can obtain:
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
 * 第一题 给一个 int，范围是从10 到 100000000（减少了很多corner case的考虑）。
 * 要做的是选两个相邻的数，把这两个数换成它们平均值的round（四舍五入）使得到的新的int 的值最大。. From 1point 3acres bbs
 * 要注意的是 Math.round 输入是double 输出是long.
 * 
 * @author zhoudong
 *
 *
 *
 */
public class ReplaceAdjacentDigitsWithTheLargerOne {

	public int Solution(int x) {

		List<Integer> list = new ArrayList<>();

		return 0;
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
