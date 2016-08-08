package org.dzhou.practice.hard;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle value.
 * 
 * Examples: <br>
 * [2,3,4] , the median is 3 <br>
 * [2,3], the median is (2 + 3) / 2 = 2.5 <br>
 * 
 * Design a data structure that supports the following two operations: <br>
 * 
 * void addNum(int num) - Add a integer number from the data stream to the data
 * structure. <br>
 * double findMedian() - Return the median of all elements so far. <br>
 * For example: <br>
 * 
 * add(1)<br>
 * add(2)<br>
 * findMedian() -> 1.5<br>
 * add(3) <br>
 * findMedian() -> 2<br>
 * 
 * @author zhoudong
 *
 *         使用大小堆来解决问题，最大堆负责存储这些数左边的(small)，最小堆则负责右边的(large)。
 */
public class FindMedianFromDataStream {

	public class Solution {
		public class MedianFinder {
			PriorityQueue<Integer> small;
			PriorityQueue<Integer> large;

			public MedianFinder() {
				small = new PriorityQueue<>(Collections.reverseOrder());
				large = new PriorityQueue<>();
			}

			// Adds a number into the data structure.
			public void addNum(int num) {
				small.add(num);
				large.add(small.poll());
				if (small.size() < large.size()) {
					small.add(large.poll());
				}
			}

			// Returns the median of current data stream
			public double findMedian() {
				return small.size() == large.size() ? (small.peek() + large.peek()) / 2.0d : small.peek();
			}
		}

		// Your MedianFinder object will be instantiated and called as such:
		// MedianFinder mf = new MedianFinder();
		// mf.addNum(1);
		// mf.findMedian();
	}

	public class Solution1 {
		public class MedianFinder {
			PriorityQueue<Integer> small;
			PriorityQueue<Integer> large;

			public MedianFinder() {
				small = new PriorityQueue<>(Collections.reverseOrder());
				large = new PriorityQueue<>();
			}

			// Adds a number into the data structure.
			public void addNum(int num) {
				if (small.isEmpty() || num < small.peek())
					small.add(num);
				else
					large.add(num);

				if (small.size() > large.size() + 1)
					large.add(small.poll());
				else if (large.size() > small.size() + 1)
					small.add(large.poll());
			}

			// Returns the median of current data stream
			public double findMedian() {
				if (large.size() == small.size())
					return (large.peek() + small.peek()) / 2.0d;
				else if (small.size() > large.size())
					return (double) small.peek();
				else
					return (double) large.peek();
			}
		}

		// Your MedianFinder object will be instantiated and called as such:
		// MedianFinder mf = new MedianFinder();
		// mf.addNum(1);
		// mf.findMedian();
	}
}
