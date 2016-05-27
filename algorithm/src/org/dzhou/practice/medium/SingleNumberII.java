package org.dzhou.practice.medium;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author zhoudong
 *
 *         这题也用位运算
 * 
 */
public class SingleNumberII {

	// 按照每一位对所有数字计算count
	public class Solution {

		public int singleNumber(int[] nums) {
			int count = 0, result = 0;
			for (int i = 0; i < 32; i++) {
				for (int j = 0; j < nums.length; j++)
					count += (nums[j] >> i) & 1;
				result |= (count % 3) << i;
				count = 0;
			}
			return result;
		}

	}

	public class Solution1 {

		public int singleNumber(int[] nums) {
			int[] count = new int[32];

			for (int i = 0; i < nums.length; i++) {
				int num = nums[i];
				for (int j = 0; j < 32; j++) {
					if (((num >> j) & 1) == 1)
						count[j]++;
				}
			}

			int result = 0;
			for (int i = 0; i < 32; i++) {
				result += ((count[i] % 3) << i);
			}
			return result;
		}

	}

}
