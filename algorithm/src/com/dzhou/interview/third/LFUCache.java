package com.dzhou.interview.third;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 460. LFU Cache
 * 
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * 
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reaches its capacity, it should invalidate the least
 * frequently used item before inserting a new item. For the purpose of this
 * problem, when there is a tie (i.e., two or more keys that have the same
 * frequency), the least recently used key would be evicted.
 * 
 * Follow up:
 * 
 * Could you do both operations in O(1) time complexity?
 * 
 * @author zhoudong
 *
 */
public class LFUCache {

	private Node head = null;
	private int capacity = 0;
	private HashMap<Integer, Node> nodeHash = null;
	private HashMap<Integer, Integer> valueHash = null;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.valueHash = new HashMap<Integer, Integer>();
		this.nodeHash = new HashMap<Integer, Node>();
	}

	public int get(int key) {
		if (!valueHash.containsKey(key))
			return -1;
		increaseCount(key);
		return valueHash.get(key);
	}

	public void put(int key, int value) {
		if (capacity == 0)
			return;
		if (valueHash.containsKey(key)) {
			valueHash.put(key, value);
		} else {
			if (valueHash.size() == capacity) {
				removeOld();
			}
			valueHash.put(key, value);
			addToHead(key);
		}
		increaseCount(key);
	}

	private void increaseCount(int key) {
		Node node = nodeHash.get(key);
		node.keys.remove(key);
		Node next = node.nextCount();
		next.keys.add(key);
		nodeHash.put(key, next);
		if (node.isEmpty()) {
			remove(node);
		}
	}

	private void addToHead(int key) {
		if (head == null) {
			head = new Node(0);
			head.keys.add(key);
		} else if (head.count > 0) {
			Node node = new Node(0);
			node.keys.add(key);
			node.next = head;
			head.prev = node;
			head = node;
		} else {
			head.keys.add(key);
		}
		nodeHash.put(key, head);
	}

	private void removeOld() {
		if (head == null)
			return;
		int old = 0;
		for (int n : head.keys) {
			old = n;
			break;
		}
		head.keys.remove(old);
		if (head.isEmpty()) {
			remove(head);
		}
		nodeHash.remove(old);
		valueHash.remove(old);
	}

	private void remove(Node node) {
		if (node.prev == null) {
			head = node.next;
		} else {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
	}

	class Node {
		public int count;
		public Node prev = null, next = null;
		private LinkedHashSet<Integer> keys = null;

		public Node(int count) {
			this.count = count;
			keys = new LinkedHashSet<Integer>();
			prev = next = null;
		}

		public Node nextCount() {
			if (next == null) {
				appendNextCount();
			} else if (this.next.count != this.count + 1) {
				insertNextCount();
			}
			return this.next;
		}

		private Node appendNextCount() {
			this.next = new Node(this.count + 1);
			this.next.prev = this;
			return this.next;
		}

		private Node insertNextCount() {
			Node temp = new Node(this.count + 1);
			temp.prev = this;
			temp.next = this.next;
			this.next.prev = temp;
			this.next = temp;
			return this.next;
		}

		public boolean isEmpty() {
			return keys.isEmpty();
		}
	}

}

// Your LFUCache object will be instantiated and called as such:
// LFUCache obj = new LFUCache(capacity);
// int param_1 = obj.get(key);
// obj.put(key,value);
