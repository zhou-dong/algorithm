package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order
 * and an integer k.
 * 
 * Define a pair (u,v) which consists of one element from the first array and
 * one element from the second array.
 * 
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * 
 * Example 1: <br>
 * Given nums1 = [1,7,11], nums2 = [2,4,6], k = 3 <br>
 * Return: [1,2],[1,4],[1,6] <br>
 * 
 * The first 3 pairs are returned from the sequence: <br>
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 
 * Example 2: <br>
 * Given nums1 = [1,1,2], nums2 = [1,2,3], k = 2 <br>
 * Return: [1,1],[1,1] <br>
 * 
 * The first 2 pairs are returned from the sequence: <br>
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 
 * Example 3: <br>
 * Given nums1 = [1,2], nums2 = [3], k = 3 <br>
 * Return: [1,3],[2,3] <br>
 * 
 * All possible pairs are returned from the sequence: <br>
 * [1,3],[2,3]
 * 
 * @author zhoudong
 *
 */
public class FindKPairsWithSmallestSums {

	public class Solution {

		class HeapNode implements Comparable<HeapNode> {
			int value;
			int[] data;

			HeapNode(int value, int[] data) {
				this.value = value;
				this.data = data;
			}

			@Override
			public int compareTo(HeapNode o) {
				return this.value - o.value;
			}
		}

		public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
			PriorityQueue<HeapNode> heap = new PriorityQueue<>();
			for (int num1 : nums1) {
				for (int num2 : nums2) {
					heap.add(new HeapNode(num1 + num2, new int[] { num1, num2 }));
				}
			}
			List<int[]> result = new ArrayList<>();
			for (int i = 0; i < k && !heap.isEmpty(); i++) {
				result.add(heap.poll().data);
			}
			return result;
		}

	}
}
