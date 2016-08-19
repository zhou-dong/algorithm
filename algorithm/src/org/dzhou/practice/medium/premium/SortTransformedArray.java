package org.dzhou.practice.medium.premium;

import java.util.PriorityQueue;

/**
 * Given a sorted array of integers nums and integer values a, b and c. Apply a
 * function of the form f(x) = ax2 + bx + c to each element x in the array.
 * 
 * The returned array must be in sorted order.
 * 
 * Expected time complexity: O(n)
 * 
 * Example:
 * 
 * nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
 * 
 * Result: [3, 9, 15, 33]
 * 
 * nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
 * 
 * Result: [-23, -5, 1, 7]
 * 
 * @author zhoudong
 *
 *         reference: http://www.cnblogs.com/grandyang/p/5595614.html
 * 
 *         用到了高中关于抛物线的知识，不在晚上看别人的答案，我觉得我是真想不出来！
 * 
 *         当a>0，说明两端的值比中间的值大，那么此时我们从结果res后往前填数，用两个指针分别指向nums数组的开头和结尾，
 *         指向的两个数就是抛物线两端的数，将它们之中较大的数先存入res的末尾，然后指针向中间移，重复比较过程，直到把res都填满。
 * 
 *         当a<0，说明两端的值比中间的小，那么我们从res的前面往后填，用两个指针分别指向nums数组的开头和结尾，
 *         指向的两个数就是抛物线两端的数，将它们之中较小的数先存入res的开头，然后指针向中间移，重复比较过程，直到把res都填满。
 * 
 *         当a=0，函数是单调递增或递减的，那么从前往后填和从后往前填都可以，我们可以将这种情况和a>0合并。
 * 
 *         抛物线中点: -b/2a <br>
 *         分这么几种情况： <br>
 *         a > 0，<br>
 *         a < 0, <br>
 *         a == 0 && b >= 0, <br>
 *         a == 0 && b < 0 <br>
 *         给的x数组是排序的，搞两个指针从两边比较 <br>
 * 
 */
public class SortTransformedArray {

	// solution with time complexity O(N)
	public class Solution {
		public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
			int[] result = new int[nums.length];
			int start = 0, end = nums.length - 1;
			int nextIndex = 0;
			if (a > 0 || (a == 0 && b >= 0))
				nextIndex = nums.length - 1;
			if (a < 0 || (a == 0 && b < 0))
				nextIndex = 0;
			double mid = -1 * ((b * 1.0) / (2.0 * a));
			while (start <= end) {
				if (a > 0 || (a == 0 && b >= 0)) {
					if (Math.abs(mid - nums[start]) > Math.abs(nums[end] - mid)) {
						int x = nums[start++];
						result[nextIndex--] = a * x * x + b * x + c;
					} else {
						int x = nums[end--];
						result[nextIndex--] = a * x * x + b * x + c;
					}
				} else if (a < 0 || (a == 0 && b < 0)) {
					if (Math.abs(mid - nums[start]) > Math.abs(nums[end] - mid)) {
						int x = nums[start++];
						result[nextIndex++] = a * x * x + b * x + c;
					} else {
						int x = nums[end--];
						result[nextIndex++] = a * x * x + b * x + c;
					}
				}
			}
			return result;
		}
	}

	// solution with time complexity N(log(N))
	public class Solution1 {
		public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
			PriorityQueue<Integer> heap = new PriorityQueue<>();
			for (int num : nums) {
				heap.add(calcuate(num, a, b, c));
			}
			int[] sorted = new int[nums.length];
			for (int i = 0; i < nums.length; i++) {
				sorted[i] = heap.poll();
			}
			return sorted;
		}

		private int calcuate(int num, int a, int b, int c) {
			return a * num * num + b * num + c;
		}
	}

}
