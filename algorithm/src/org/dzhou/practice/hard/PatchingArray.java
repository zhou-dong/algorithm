package org.dzhou.practice.hard;

/**
 * Given a sorted positive integer array nums and an integer n, add/patch
 * elements to the array such that any number in range [1, n] inclusive can be
 * formed by the sum of some elements in the array. Return the minimum number of
 * patches required.
 * 
 * Example 1: <br>
 * nums = [1, 3], n = 6 <br>
 * Return 1.
 * 
 * Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3,
 * 4. Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3],
 * [2,3], [1,2,3]. Possible sums are 1, 2, 3, 4, 5, 6, which now covers the
 * range [1, 6]. So we only need 1 patch.
 * 
 * Example 2: <br>
 * nums = [1, 5, 10], n = 20 <br>
 * Return 2. <br>
 * The two patches can be [2, 4].
 * 
 * Example 3:<br>
 * nums = [1, 2, 2], n = 5<br>
 * Return 0.
 * 
 * @author zhoudong
 *
 *         reference: http://blog.csdn.net/liyuefeilong/article/details/50616268
 */
public class PatchingArray {

	public class Solution {

		public int minPatches(int[] nums, int n) {
			int count = 0, index = 0;

			// currSum标记了当前数组nums可累加到的最大范围[1, currSum)
			for (long currSum = 1; currSum <= n;) {

				// 数组内元素小于currSum时，可累加的sum上限增加为 currSum + nums[index]，然后数组索引值加1
				if (index < nums.length && nums[index] <= currSum) {
					currSum += nums[index++];
				} else {
					currSum <<= 1; // miss += miss;
					count += 1;
				}

			}

			return count;
		}

	}

}
