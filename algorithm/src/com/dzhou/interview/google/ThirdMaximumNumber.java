package com.dzhou.interview.google;

/**
 * 414. Third Maximum Number
 * 
 * Difficulty: Easy
 * 
 * Given a non-empty array of integers, return the third maximum number in this
 * array. If it does not exist, return the maximum number. The time complexity
 * must be in O(n).
 * 
 * Example 1: Input: [3, 2, 1]
 * 
 * Output: 1
 * 
 * Explanation: The third maximum is 1.
 * 
 * Example 2: Input: [1, 2]
 * 
 * Output: 2
 * 
 * Explanation: The third maximum does not exist, so the maximum (2) is returned
 * instead.
 * 
 * Example 3: Input: [2, 2, 3, 1]
 * 
 * Output: 1
 * 
 * Explanation: Note that the third maximum here means the third maximum
 * distinct number. Both numbers with value 2 are both considered as second
 * maximum.
 * 
 * 
 * @author zhoudong
 *
 */
public class ThirdMaximumNumber {

	public int thirdMax(int[] nums) {
		double max = Double.NEGATIVE_INFINITY, second = max, third = max;
		for (int num : nums) {
			if (num == max || num == second || num == third) {
				continue;
			}
			if (num > max) {
				third = second;
				second = max;
				max = num;
			} else if (num > second) {
				third = second;
				second = num;
			} else if (num > third) {
				third = num;
			}
		}
		return third == Double.NEGATIVE_INFINITY ? (int) max : (int) third;
	}

}
