package org.dzhou.practice.medium;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * Example:
 * 
 * matrix = [ <br>
 * ---[ 1, 5, 9], <br>
 * ---[10, 11, 13], <br>
 * ---[12, 13, 15] <br>
 * ], <br>
 * 
 * k = 8, <br>
 * 
 * return 13.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ n2.
 * 
 * @author zhoudong
 *
 *         给定一个每一行每一列都排好序的矩阵，求其中第k大的元素
 */
public class KthSmallestElementInASortedMatrix {

	// Maximum Heap
	// 1. Create Maximum Heap
	// 2. Add k elements into Heap
	// 3. if heap.size() == k
	// 3.1 if element < heap.peek(): heap.add(element)
	// 3.2 else ignore
	// 4. if heap.size() > k: heap.poll();
	public class HeapSolution0 {
		public int kthSmallest(int[][] matrix, int k) {
			if (k < 1)
				return -1;
			PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
			for (int[] row : matrix) {
				for (int element : row) {
					if (heap.size() < k)
						heap.add(element);
					else if (heap.peek() > element)
						heap.add(element);
					if (heap.size() > k)
						heap.poll();
				}
			}
			return heap.peek();
		}
	}

	// Maximum Heap
	// 1. Create Max Heap
	// 2. Add element to Heap
	// 3. If heap.size() > k, heap.poll()
	public class HeapSolution1 {
		public int kthSmallest(int[][] matrix, int k) {
			if (k < 1)
				return -1;
			PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
			for (int[] row : matrix) {
				for (int element : row) {
					heap.add(element);
					if (heap.size() > k)
						heap.poll();
				}
			}
			return heap.peek();
		}
	}

	// Simple Heap Solution
	// 1. 把所有元素都加入heap
	// 2. poll() k次
	public class HeapSolution2 {
		public int kthSmallest(int[][] matrix, int k) {
			if (k < 1)
				return -1;
			PriorityQueue<Integer> heap = new PriorityQueue<>();
			int size = 0;
			for (int[] row : matrix) {
				for (int element : row) {
					heap.add(element);
					size++;
				}
			}
			if (k > size)
				return -1;
			for (int i = 0; i < k - 1; i++)
				heap.poll();
			return heap.peek();
		}
	}

}
