package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. Sort Characters By Frequency
 * 
 * Total Accepted: 1403
 * 
 * Total Submissions: 3129
 * 
 * Difficulty: Medium
 * 
 * Contributors: stickypens
 * 
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Example 1:
 * 
 * Input: "tree"
 * 
 * Output: "eert"
 * 
 * Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e'
 * must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * 
 * Example 2:
 * 
 * Input: "cccaaa"
 * 
 * Output: "cccaaa"
 * 
 * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid
 * answer. Note that "cacaca" is incorrect, as the same characters must be
 * together.
 * 
 * Example 3:
 * 
 * Input: "Aabb"
 * 
 * Output: "bbAa"
 * 
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect. Note
 * that 'A' and 'a' are treated as two different characters.
 * 
 * @author zhoudong
 *
 */
public class SortCharactersByFrequency {

	public String frequencySort(String s) {
		if (s == null || s.length() == 0)
			return "";
		Map<Character, Integer> table = countCharacter(s);
		PriorityQueue<HeapNode> heap = buildHeap(table);
		return iteratorHeap(heap);
	}

	private String iteratorHeap(PriorityQueue<HeapNode> heap) {
		StringBuilder sb = new StringBuilder();
		while (!heap.isEmpty()) {
			HeapNode current = heap.poll();
			for (int i = 0; i < current.count; i++) {
				sb.append(current.ch);
			}
		}
		return sb.toString();
	}

	class HeapNode implements Comparable<HeapNode> {
		char ch;
		int count;

		HeapNode(char ch, int count) {
			this.ch = ch;
			this.count = count;
		}

		@Override
		public int compareTo(HeapNode o) {
			return (o.count != this.count) ? o.count - this.count : this.ch - o.ch;
		}
	}

	private PriorityQueue<HeapNode> buildHeap(Map<Character, Integer> map) {
		PriorityQueue<HeapNode> heap = new PriorityQueue<>();
		for (char ch : map.keySet())
			heap.offer(new HeapNode(ch, map.get(ch)));
		return heap;
	}

	private Map<Character, Integer> countCharacter(String str) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : str.toCharArray())
			map.put(ch, (map.containsKey(ch) ? map.get(ch) : 0) + 1);
		return map;
	}

}
