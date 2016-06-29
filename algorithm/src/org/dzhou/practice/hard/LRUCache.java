package org.dzhou.practice.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * 
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * @author zhoudong
 *
 *         解决这道题的方法是：双向链表+HashMap
 */
public class LRUCache {

	private class Node {
		Node prev;
		Node next;
		int key;
		int value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}

	private int capacity;
	private Map<Integer, Node> hs = new HashMap<Integer, Node>();
	private Node head = new Node(-1, -1);
	private Node tail = new Node(-1, -1);

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.head.next = tail;
		this.tail.prev = head;
	}

	public int get(int key) {
		if (!hs.containsKey(key)) {
			return -1;
		}
		// remove current
		Node current = hs.get(key);
		current.prev.next = current.next;
		current.next.prev = current.prev;
		// move current to tail
		move_to_tail(current);
		return hs.get(key).value;
	}

	private void move_to_tail(Node current) {
		current.next = tail;
		current.prev = tail.prev;
		current.prev.next = current;
		tail.prev = current;
	}

	public void set(int key, int value) {
		if (get(key) != -1) {
			hs.get(key).value = value;
			return;
		}
		// remove the first element
		if (hs.size() == capacity) {
			hs.remove(head.next.key);
			head.next = head.next.next;
			head.next.prev = head;
		}
		Node insert = new Node(key, value);
		hs.put(key, insert);
		move_to_tail(insert);
	}

}
