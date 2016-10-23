package com.dzhou.interview.google;

import java.util.Arrays;

/**
 * You are given a int[N] array num, count how many triplets (x, y, z) that
 * num[x] + num[y] + num[z] < K
 * 
 * assuming x < y < z
 * 
 * num[] = { , 3, 6, 1, 8, 10} K = 13
 * 
 * 5 + 3 + 1 = 9 < 13
 * 
 * 5 + 6 + 1 = 12 < 13
 * 
 * 3 + 6 + 1 = 10 < 13
 * 
 * 3 + 1 + 8 = 12 < 13
 * 
 * ans = 4
 * 
 * @author zhoudong
 *
 */
public class SumTripletsLessThanK {

	public int count(int[] nums, int k) {
		if (nums == null || nums.length < 3)
			return 0;
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int z = nums.length - 1; z > j; z--) {
					int sum = nums[i] + nums[j] + nums[z];
					if (sum < k) {
						count += (z - j);
						break;
					}
				}
			}
		}
		return count;
	}

}
