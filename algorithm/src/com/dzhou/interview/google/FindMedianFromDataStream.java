package com.dzhou.interview.google;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 295. Find Median from Data Stream
 * 
 * Difficulty: Hard
 * 
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle value.
 * 
 * Examples: [2,3,4] , the median is 3
 * 
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addNum(int num) - Add a integer number from the data stream to the data
 * structure.
 * 
 * double findMedian() - Return the median of all elements so far.
 * 
 * For example:
 * 
 * add(1)
 * 
 * add(2)
 * 
 * findMedian() -> 1.5
 * 
 * add(3)
 * 
 * findMedian() -> 2
 * 
 * @author zhoudong
 *
 */
public class FindMedianFromDataStream {

	public class MedianFinder {

		PriorityQueue<Integer> minHeap;
		PriorityQueue<Integer> maxHeap;

		public MedianFinder() {
			minHeap = new PriorityQueue<>();
			maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		}

		// Adds a number into the data structure.
		public void addNum(int num) {
			minHeap.add(num);
			maxHeap.add(minHeap.poll());
			if (minHeap.size() < maxHeap.size()) {
				minHeap.add(maxHeap.poll());
			}
		}

		// Returns the median of current data stream
		public double findMedian() {
			return minHeap.size() > maxHeap.size() ? minHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0d;
		}

	};

	// Your MedianFinder object will be instantiated and called as such:
	// MedianFinder mf = new MedianFinder();
	// mf.addNum(1);
	// mf.findMedian();

	public static void main(String[] args) {

		PriorityQueue<Integer> heap = new PriorityQueue<>();

		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int e = random.nextInt(15);
			if (e == 0)
				continue;
			System.out.print(e + " ");
		}

	}

}
