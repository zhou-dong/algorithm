package com.dzhou.interview.third;

/**
 * 487. Max Consecutive Ones II
 * 
 * Difficulty: Medium
 * 
 * Given a binary array, find the maximum number of consecutive 1s in this array
 * if you can flip at most one 0.
 * 
 * Example 1: Input: [1,0,1,1,0] Output: 4
 * 
 * Explanation: Flip the first zero will get the the maximum number of
 * consecutive 1s. After flipping, the maximum number of consecutive 1s is 4.
 * 
 * Note:
 * 
 * The input array will only contain 0 and 1.
 * 
 * The length of input array is a positive integer and will not exceed 10,000
 * 
 * Follow up:
 * 
 * What if the input numbers come in one by one as an infinite stream? In other
 * words, you can't store all numbers coming from the stream as it's too large
 * to hold in memory. Could you solve it efficiently?
 * 
 * @author zhoudong
 *
 */
public class MaxConsecutiveOnesII {

	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0, prev = 0, curr = 0, hasZero = 0;

		for (int num : nums) {
			if (num == 0) {
				hasZero = 1;
				max = Math.max(max, curr + prev + hasZero);
				prev = curr;
				curr = 0;
			} else {
				curr++;
			}
		}

		return Math.max(max, curr + prev + hasZero);
	}

}
