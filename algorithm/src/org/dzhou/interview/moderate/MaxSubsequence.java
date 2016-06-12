package org.dzhou.interview.moderate;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         给定一个整数数组（有正数有负数），找出总和最大的连续数列，并返回总和。
 * 
 */
public class MaxSubsequence {

	public static int getMaxSum(int[] array) {
		int maxSum = Integer.MIN_VALUE, sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (maxSum < sum)
				maxSum = sum;
			if (sum < 0)
				sum = 0;
		}
		return maxSum;
	}

}
