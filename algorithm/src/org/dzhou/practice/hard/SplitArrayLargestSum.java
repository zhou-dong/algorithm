package org.dzhou.practice.hard;

/**
 * 410. Split Array Largest Sum
 * 
 * Difficulty: Hard
 * 
 * Given an array which consists of non-negative integers and an integer m, you
 * can split the array into m non-empty continuous subarrays. Write an algorithm
 * to minimize the largest sum among these m subarrays.
 * 
 * Note: Given m satisfies the following constraint: 1 ≤ m ≤ length(nums) ≤
 * 14,000.
 * 
 * Examples:
 * 
 * Input: nums = [7,2,5,10,8] m = 2
 * 
 * Output: 18
 * 
 * Explanation: There are four ways to split nums into two subarrays. The best
 * way is to split it into [7,2,5] and [10,8], where the largest sum among the
 * two subarrays is only 18.
 * 
 * @author zhoudong
 *
 *         reference: http://blog.csdn.net/mebiuw/article/details/52724293
 */
public class SplitArrayLargestSum {

	// 这个数肯定介于最大的那一个单值和所有元素之和的中间
	public int splitArray(int[] nums, int m) {
		long sum = 0;
		int max = 0;
		for (int num : nums) {
			max = Math.max(max, num);
			sum += num;
		}
		return (int) binarySearch(nums, m, sum, max);
	}

	// 二分查找
	private long binarySearch(int[] nums, int m, long high, long low) {
		long mid = 0;
		while (low < high) {
			mid = (high + low) / 2;
			// 验证是否满足,也就是这么大的值有可能出现么
			if (valid(nums, m, mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return high;
	}

	// 验证这个值是否合法
	private boolean valid(int[] nums, int m, long max) {
		int cur = 0, count = 1;
		// 是否有多余m个片段or区间，大于给定值的max的，如果有了，那么就不合法了，因为这样划分就不止m个，及max太小
		for (int num : nums) {
			cur += num;
			if (cur > max) {
				cur = num;
				count++;
				if (count > m) {
					return false;
				}
			}
		}
		return true;
	}
}
