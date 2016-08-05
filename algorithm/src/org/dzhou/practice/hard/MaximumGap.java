package org.dzhou.practice.hard;

import java.util.Arrays;

/**
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in
 * the 32-bit signed integer range.
 * 
 * @author zhoudong
 *
 *         给定一个未排序的数组，返回其排序后的数组中 相邻元素之差 最大的值。
 */
public class MaximumGap {

	public class Solution {

		class Bucket {
			int low;
			int high;

			public Bucket() {
				low = -1;
				high = -1;
			}

			public void insert(int num) {
				if (this.low == -1) {
					this.low = num;
					this.high = num;
				} else {
					this.low = Math.min(low, num);
					this.high = Math.max(high, num);
				}
			}
		}

		public int maximumGap(int[] nums) {
			if (nums.length < 2)
				return 0;
			Bucket[] buckets = createBuckets(nums.length + 1); // (0 - n)
			insertNumsIntoBuckets(buckets, nums);
			return findMaxGap(buckets);
		}

		private Bucket[] createBuckets(int length) {
			Bucket[] buckets = new Bucket[length];
			for (int i = 0; i < buckets.length; i++)
				buckets[i] = new Bucket();
			return buckets;
		}

		private void insertNumsIntoBuckets(Bucket[] buckets, int[] nums) {
			int min = findMin(nums);
			int max = findMax(nums);
			double interval = calculateInterval(nums.length, max, min);
			for (int num : nums) {
				int index = bucketIndex(num, min, interval);
				buckets[index].insert(num);
			}
		}

		private double calculateInterval(int num, int max, int min) {
			return ((double) num) / (max - min);
		}

		private int bucketIndex(int num, int min, double interval) {
			return (int) ((num - min) * interval);
		}

		// 差异的平均值: double interval = ((double) nums.length) / (max - min);
		// max gap的值，一定要比平均值大，所以 max gap 一定在两个相邻的bucket之间。
		private int findMaxGap(Bucket[] buckets) {
			int result = 0, index = 0, prevHigh = -1;
			for (index = 0; index < buckets.length; index++) {
				if (buckets[index].high != -1) {
					prevHigh = buckets[index].high;
					break;
				}
			}
			for (++index; index < buckets.length; index++) {
				if (buckets[index].low == -1)
					continue;
				result = Math.max(result, buckets[index].low - prevHigh);
				prevHigh = buckets[index].high;
			}
			return result;
		}

		private int findMin(int[] nums) {
			int min = nums[0];
			for (int i = 1; i < nums.length; i++)
				min = Math.min(min, nums[i]);
			return min;
		}

		private int findMax(int[] nums) {
			int max = nums[0];
			for (int i = 1; i < nums.length; i++)
				max = Math.max(max, nums[i]);
			return max;
		}
	}

	// O(NLogN)
	public class Solution1 {
		public int maximumGap(int[] nums) {
			Arrays.sort(nums);
			int max = 0;
			for (int i = 1; i < nums.length; i++) {
				max = Math.max(nums[i] - nums[i - 1], max);
			}
			return max;
		}
	}

}
