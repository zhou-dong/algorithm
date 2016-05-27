package org.dzhou.practice.medium;

/**
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * For example:
 * 
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Note:
 * 
 * The order of the result is not important. So in the above example, [5, 3] is
 * also correct.
 * 
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant space complexity?
 * 
 * @author zhoudong
 *
 *         一个整数有32位bit，对于b和c，除非两者是相同的数，否则一定存在第K位bit，两者是不同的。
 *
 *         当找到这个K以后，就可以按照第K位bit是否等于1，将A数组划分成两个子数组，而这两个子数组分别包含了b和c，
 *         那么剩下的就只需要把single number的算法直接应用到这两个子数组上，就可以得到b和c了。
 */
public class SingleNumberIII {

	public int[] singleNumber(int[] nums) {

		int i = 0, count = 0;

		for (i = 0; i < 32; i++) {
			for (int j = 0; j < nums.length; j++)
				count ^= ((nums[j] >> i) & 1);
			if (count != 0)
				break;
		}

		int[] result = new int[2];

		for (int j = 0; j < nums.length; j++) {
			if ((nums[j] >> i & 1) == 1)
				result[0] ^= nums[j];
			else
				result[1] ^= nums[j];
		}

		return result;

	}

}
