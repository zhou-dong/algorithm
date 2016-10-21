package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache QuestionEditorial
 * 
 * Difficulty: Hard
 * 
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
 */
public class LRUCache {

	class Node {
		Node prev;
		Node next;
		int key;
		int value;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	int capacity;
	Map<Integer, Node> map;
	private Node head;
	private Node tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.head = new Node(-1, -1);
		this.tail = new Node(-1, -1);
		this.head.next = tail;
		this.tail.prev = head;
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;
		Node target = map.get(key);
		remove(target);
		append(target);
		return target.value;
	}

	private void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void append(Node node) {
		node.next = tail;
		node.prev = tail.prev;
		node.prev.next = node;
		tail.prev = node;
	}

	public void set(int key, int value) {
		if (get(key) != -1) {
			map.get(key).value = value;
			return;
		}
		if (map.size() == capacity) {
			map.remove(head.next.key);
			remove(head.next);
		}
		Node node = new Node(key, value);
		map.put(key, node);
		append(node);
	}

}
