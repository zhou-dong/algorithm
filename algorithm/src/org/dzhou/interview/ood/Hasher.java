package org.dzhou.interview.ood;

import java.util.ArrayList;

public class Hasher<K, V> {

	private static class LinkedListNode<K, V> {
		public LinkedListNode<K, V> next;
		public LinkedListNode<K, V> prev;
		public K key;
		public V value;

		public LinkedListNode(K k, V v) {
			key = k;
			value = v;
		}
	}

	private ArrayList<LinkedListNode<K, V>> arrayList;

	public Hasher(int capacity) {
		arrayList = new ArrayList<>();
		arrayList.ensureCapacity(capacity);
		for (int i = 0; i < capacity; i++) {
			arrayList.add(null);
		}
	}

	public void put(K key, V value) {
		LinkedListNode<K, V> node = getNodeForKey(key);
		if (node != null) {
			node.value = value;
			return;
		}
		node = new LinkedListNode<>(key, value);
		int index = getIndexForKey(key);
		if (arrayList.get(index) != null) {
			node.next = arrayList.get(index);
			node.next.prev = node;
		}
		arrayList.set(index, node);
	}

	public void remove(K key) {
		LinkedListNode<K, V> node = getNodeForKey(key);
		if (node == null)
			return;
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			int hashKey = getIndexForKey(key);
			arrayList.set(hashKey, node.next);
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
	}

	public V get(K key) {
		LinkedListNode<K, V> node = getNodeForKey(key);
		return node == null ? null : node.value;
	}

	private LinkedListNode<K, V> getNodeForKey(K key) {
		int index = getIndexForKey(key);
		LinkedListNode<K, V> current = arrayList.get(index);
		while (current != null) {
			if (current.key == key)
				return current;
			current = current.next;
		}
		return null;
	}

	public int getIndexForKey(K key) {
		return Math.abs(key.hashCode() % arrayList.size());
	}

}
