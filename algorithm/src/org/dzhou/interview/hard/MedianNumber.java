package org.dzhou.interview.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Practice of "cracking the code interview"
 * 
 * 
 * @author DONG ZHOU
 *
 */
public class MedianNumber {

	Comparator<Integer> maxHeapComparatpr;
	Comparator<Integer> minHeapComparator;
	private PriorityQueue<Integer> maxHeap, minHeap;

	public void addNewNumber(int randomNumber) {
		if (maxHeap.size() == minHeap.size()) {
			if (minHeap.peek() != null && randomNumber > minHeap.peek()) {
				maxHeap.offer(minHeap.poll());
				minHeap.offer(randomNumber);
			} else {
				maxHeap.offer(randomNumber);
			}
		} else {
			if (randomNumber < maxHeap.peek()) {
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(randomNumber);
			} else {
				minHeap.offer(randomNumber);
			}
		}
	}

	public double getMedian() {
		if (maxHeap.isEmpty()) {
			return 0;
		}
		if (maxHeap.size() == minHeap.size()) {
			return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
		} else {
			return maxHeap.peek();
		}
	}

}
