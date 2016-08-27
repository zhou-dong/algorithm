package org.dzhou.practice.hard.premium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a non-empty string str and an integer k, rearrange the string such that
 * the same characters are at least distance k from each other.
 * 
 * All input strings are given in lowercase letters. If it is not possible to
 * rearrange the string, return an empty string "".
 * 
 * Example 1: <br>
 * str = "aabbcc", k = 3 <br>
 * Result: "abcabc" <br>
 * The same letters are at least distance 3 from each other.*
 * 
 * Example 2: <br>
 * str = "aaabc", k = 3 <br>
 * Answer: ""<br>
 * It is not possible to rearrange the string.
 * 
 * Example 3: <br>
 * str = "aaadbbcc", k = 2<br>
 * Answer: "abacabcd"<br>
 * Another possible answer is: "abcabcda"
 * 
 * The same letters are at least distance 2 from each other.
 * 
 * @author zhoudong
 *
 */
public class RearrangeStringKDistanceApart {

	public class Solution {

		class HeapNode implements Comparable<HeapNode> {
			int frequency;
			char c;

			HeapNode(char c, int frequency) {
				this.c = c;
				this.frequency = frequency;
			}

			@Override
			public int compareTo(HeapNode o) {
				if (this.frequency > o.frequency)
					return -1;
				if (this.frequency < o.frequency)
					return 1;
				if (this.c > o.c)
					return 1;
				if (this.c < o.c)
					return -1;
				return 0;
			}
		}

		public String rearrangeString(String str, int k) {
			if (k == 0)
				return str;
			StringBuilder sb = new StringBuilder();
			PriorityQueue<HeapNode> heap = createHeap(str);

			for (int i = 0; i < str.length();) {
				Queue<HeapNode> queue = new LinkedList<>();
				int j = 0;
				for (; j < k && !heap.isEmpty(); j++) {
					HeapNode temp = heap.poll();
					sb.append(temp.c);
					temp.frequency--;
					if (temp.frequency != 0) {
						queue.add(temp);
					}
				}
				i += j;
				if (j < k && i < str.length())
					return "";
				while (!queue.isEmpty()) {
					heap.add(queue.poll());
				}
			}

			return sb.toString();
		}

		private PriorityQueue<HeapNode> createHeap(String str) {
			Map<Character, Integer> map = charCount(str);
			return createHeap(map);
		}

		private PriorityQueue<HeapNode> createHeap(Map<Character, Integer> map) {
			PriorityQueue<HeapNode> heap = new PriorityQueue<>();
			for (char c : map.keySet())
				heap.add(new HeapNode(c, map.get(c)));
			return heap;
		}

		private Map<Character, Integer> charCount(String str) {
			Map<Character, Integer> map = new HashMap<>();
			for (char c : str.toCharArray()) {
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			}
			return map;
		}
	}
}
