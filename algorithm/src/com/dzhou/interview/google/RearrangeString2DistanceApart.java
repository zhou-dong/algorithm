package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * re-order a string so that no adjecent characters are the same.e.g. caat -->
 * cata or acat or acta....
 * 
 * @author zhoudong
 *
 */
public class RearrangeString2DistanceApart {

	class QueueNode {
		int count;
		char ch;

		QueueNode(char ch, int count) {
			this.count = count;
			this.ch = ch;
		}
	}

	public String rearrangeString(String str) {
		StringBuilder sb = new StringBuilder();
		Queue<QueueNode> queue = createQueue(countMap(str));
		while (!queue.isEmpty()) {
			QueueNode current = queue.poll();
			sb.append(current.ch);
			if (--current.count > 0) {
				queue.add(current);
			}
		}
		return sb.toString();
	}

	private Queue<QueueNode> createQueue(Map<Character, Integer> map) {
		Queue<QueueNode> queue = new LinkedList<>();
		for (char ch : map.keySet())
			queue.offer(new QueueNode(ch, map.get(ch)));
		return queue;
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
