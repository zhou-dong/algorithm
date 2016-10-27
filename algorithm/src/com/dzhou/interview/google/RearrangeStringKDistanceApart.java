package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 358. Rearrange String k Distance Apart
 * 
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

	public String rearrangeString(String str, int k) {
		if (k == 0)
			return str;
		StringBuilder sb = new StringBuilder();
		PriorityQueue<HeapNode> heap = createHeap(countMap(str));
		int i = 0;
		while (i < str.length()) {
			Queue<HeapNode> queue = new LinkedList<>();
			int j = 0;
			while (j < k && !heap.isEmpty()) {
				HeapNode current = heap.poll();
				sb.append(current.ch);
				if (--current.count > 0) {
					queue.add(current);
				}
				i++;
				j++;
			}
			if (j < k && i < str.length()) {
				return "";
			}
			while (!queue.isEmpty()) {
				heap.offer(queue.poll());
			}
		}
		return sb.toString();
	}

	class HeapNode implements Comparable<HeapNode> {
		int count;
		char ch;

		HeapNode(char ch, int count) {
			this.ch = ch;
			this.count = count;
		}

		@Override
		public int compareTo(HeapNode o) {
			return (o.count != this.count) ? (o.count - this.count) : this.ch - o.ch;
		}
	}

	private PriorityQueue<HeapNode> createHeap(Map<Character, Integer> map) {
		PriorityQueue<HeapNode> heap = new PriorityQueue<>();
		for (char ch : map.keySet())
			heap.offer(new HeapNode(ch, map.get(ch)));
		return heap;
	}

	private Map<Character, Integer> countMap(String str) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : str.toCharArray()) {
			int value = map.containsKey(ch) ? map.get(ch) + 1 : 1;
			map.put(ch, value);
		}
		return map;
	}

}
