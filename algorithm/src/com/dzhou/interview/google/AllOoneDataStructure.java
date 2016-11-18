package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 432. All O`one Data Structure
 * 
 * Difficulty: Hard
 * 
 * Implement a data structure supporting the following operations:
 * 
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by
 * 1. Key is guaranteed to be a non-empty string.
 * 
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise
 * decrements an existing key by 1. If the key does not exist, this function
 * does nothing. Key is guaranteed to be a non-empty string.
 * 
 * GetMaxKey() - Returns one of the keys with maximal value. If no element
 * exists, return an empty string "".
 * 
 * GetMinKey() - Returns one of the keys with minimal value. If no element
 * exists, return an empty string "".
 * 
 * Challenge: Perform all these in O(1) time complexity.
 * 
 * @author zhoudong
 *
 */
public class AllOoneDataStructure {

	public class AllOne {

		class Node {
			int count;
			String key;
			Node prev;
			Node next;

			Node(String key, int count) {
				this.key = key;
				this.count = count;
				this.prev = null;
				this.next = null;
			}
		}

		Node head, tail;
		Map<String, Node> map;

		/** Initialize your data structure here. */
		public AllOne() {
			head = new Node("", 0);
			tail = new Node("", 0);
			map = new HashMap<>();
			head.next = tail;
			tail.prev = head;
		}

		/**
		 * Inserts a new key <Key> with value 1. Or increments an existing key
		 * by 1.
		 */
		public void inc(String key) {
			Node node = null;
			if (!map.containsKey(key)) {
				node = new Node(key, 1);
				map.put(key, node);
				insert(tail, node);
				return;
			}
			node = map.get(key);
			node.count++;
			Node prev = node.prev;
			while (prev != head && node.count > prev.count) {
				prev = prev.prev;
			}
			if (prev != node.prev) {
				remove(node);
				append(prev, node);
			}
		}

		private void remove(Node node) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}

		private void append(Node prev, Node node) {
			node.prev = prev;
			node.next = prev.next;
			node.prev.next = node;
			node.next.prev = node;
		}

		/**
		 * Decrements an existing key by 1. If Key's value is 1, remove it from
		 * the data structure.
		 */
		public void dec(String key) {
			if (!map.containsKey(key)) {
				return;
			}
			Node node = map.get(key);
			if (node.count == 1) {
				map.remove(key);
				remove(node);
				return;
			}
			node.count--;
			Node next = node.next;
			while (next != tail && node.count < next.count) {
				next = next.next;
			}
			if (next != node.next) {
				remove(node);
				insert(next, node);
			}
		}

		private void insert(Node next, Node node) {
			node.next = next;
			node.prev = next.prev;
			node.next.prev = node;
			node.prev.next = node;
		}

		/** Returns one of the keys with maximal value. */
		public String getMaxKey() {
			return head.next.key;
		}

		/** Returns one of the keys with Minimal value. */
		public String getMinKey() {
			return tail.prev.key;
		}

	}

	// Your AllOne object will be instantiated and called as such:
	// AllOne obj = new AllOne();
	// obj.inc(key);
	// obj.dec(key);
	// String param_3 = obj.getMaxKey();
	// String param_4 = obj.getMinKey();
}
