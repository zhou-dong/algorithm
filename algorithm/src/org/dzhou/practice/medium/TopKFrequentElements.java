package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example,
 * 
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note:
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * 
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 * 
 * @author zhoudong
 *
 */
public class TopKFrequentElements {

	class Pair implements Comparable<Pair> {
		int num;
		int count;

		public Pair(int num, int count) {
			this.num = num;
			this.count = count;
		}

		@Override
		public int compareTo(Pair o) {
			return this.count - o.count;
		}
	}

	public class Solution {
		public List<Integer> topKFrequent(int[] nums, int k) {

			Map<Integer, Integer> map = new HashMap<>();
			for (int num : nums) {
				if (map.containsKey(num))
					map.put(num, map.get(num) + 1);
				else
					map.put(num, 1);
			}

			PriorityQueue<Pair> queue = new PriorityQueue<>();

			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				Pair pair = new Pair(entry.getKey(), entry.getValue());
				queue.offer(pair);
				if (queue.size() > k)
					queue.poll();
			}

			List<Integer> result = new ArrayList<Integer>();
			while (queue.size() > 0) {
				result.add(queue.poll().num);
			}

			Collections.reverse(result);

			return result;
		}
	}

}
