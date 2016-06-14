package org.dzhou.practice.medium;

import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * @author zhoudong
 *
 */
public class KthLargestElementInAnArray {

	public class Solution {
		public int findKthLargest(int[] nums, int k) {
			PriorityQueue<Integer> queue = new PriorityQueue<>();
			for (int i = 0; i < k; i++) {
				queue.add(nums[i]);
			}
			for (int i = k; i < nums.length; i++) {
				queue.add(nums[i]);
				queue.poll();
			}
			return queue.peek();
		}
	}

}
