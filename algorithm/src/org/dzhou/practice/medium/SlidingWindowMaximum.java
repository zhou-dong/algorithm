package org.dzhou.practice.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Given an array nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers
 * in the window. Each time the sliding window moves right by one position.
 * 
 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * Window position -----Max<br>
 * --------------- ------- <br>
 * [1 3 -1] -3 5 3 6 7 | 3 <br>
 * 1 [3 -1 -3] 5 3 6 7 | 3 <br>
 * 1 3 [-1 -3 5] 3 6 7 | 5 <br>
 * 1 3 -1 [-3 5 3] 6 7 | 5 <br>
 * 1 3 -1 -3 [5 3 6] 7 | 6 <br>
 * 1 3 -1 -3 5 [3 6 7] | 7 <br>
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * 
 * Note: <br>
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for
 * non-empty array.
 * 
 * Follow up: <br>
 * Could you solve it in linear time?
 * 
 * Hint: <br>
 * 1. How about using a data structure such as deque (double-ended queue)? <br>
 * 2. The queue size need not be the same as the window’s size. 3. Remove
 * redundant elements and the queue should store only elements that need to be
 * considered. <br>
 * 
 * @author zhoudong
 *
 */
public class SlidingWindowMaximum {

	public static void main(String[] args) {
		SlidingWindowMaximum s = new SlidingWindowMaximum();
		s.test();
	}

	private void test() {
		Solution s = new Solution();
		for (int n : s.maxSlidingWindow(new int[] { 1, -1 }, 1)) {
			System.out.print(n + " ");
		}
	}

	// double-ended queue
	public class Solution {
		public int[] maxSlidingWindow(int[] nums, int k) {
			if (nums == null || nums.length == 0 || k > nums.length)
				return new int[0];

			LinkedList<Integer> queue = new LinkedList<>();
			int[] result = new int[nums.length + 1 - k];

			for (int i = 0; i < nums.length; i++) {
				if (!queue.isEmpty() && queue.peekFirst() == i - k)
					queue.poll();
				while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
					queue.removeLast();
				queue.offerLast(i);
				if ((i + 1) >= k)
					result[i + 1 - k] = nums[queue.peek()];
			}
			return result;
		}
	}

	// Heap Solution
	public class Solution1 {
		public int[] maxSlidingWindow(int[] nums, int k) {
			if (nums == null || nums.length == 0 || k > nums.length)
				return new int[0];

			PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
			for (int i = 0; i < k; i++)
				heap.add(nums[i]);

			int[] result = new int[nums.length + 1 - k];
			result[0] = heap.peek();

			for (int i = k; i < nums.length; i++) {
				heap.remove(nums[i - k]);
				heap.add(nums[i]);
				result[i + 1 - k] = heap.peek();
			}
			return result;
		}
	}

	// Heap Solution
	public class Solution2 {
		public int[] maxSlidingWindow(int[] nums, int k) {
			if (nums == null || nums.length == 0 || k > nums.length)
				return new int[0];

			PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
			int[] result = new int[nums.length + 1 - k];

			for (int i = 0; i < nums.length; i++) {
				if (i >= k) {
					heap.remove(nums[i - k]);
				}
				heap.add(nums[i]);
				if (i + 1 >= k) {
					result[i + 1 - k] = heap.peek();
				}
			}
			return result;
		}
	}

}
