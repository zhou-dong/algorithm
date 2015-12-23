package org.dzhou.interview.arrays;

import java.util.LinkedList;
import java.util.List;

/**
 * Use an array of linked lists and hash code function to insert a key or value
 * 
 * @author DONG ZHOU
 *
 */
public class HashTable<K, V> {

	static final int CAPACITY = 1 << 4;

	public static class Entity<K, V> {
		K key = null;
		V value = null;

		public Entity(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	List<Entity<K, V>>[] table = null;

	@SuppressWarnings("unchecked")
	public HashTable() {
		table = new LinkedList[CAPACITY];
	}

	static final int hash(Object key) {
		return (key == null) ? 0 : (key.hashCode()) % CAPACITY;
	}

	public void put(K key, V value) {
		int hash = hash(key);
		Entity<K, V> entity = new Entity<K, V>(key, value);
		if (table[hash] == null)
			table[hash] = new LinkedList<>();
		table[hash].add(entity);
	}

	public V get(K key) {
		if (key == null)
			return null;
		int hash = hash(key);
		List<Entity<K, V>> list = table[hash];
		if (list == null || list.size() == 0)
			return null;
		for (Entity<K, V> entity : list)
			if (key.equals(entity.key))
				return entity.value;
		return null;
	}

	public static void main(String[] args) {
		HashTable<String, Integer> test = new HashTable<>();
		test.put("Dong Zhou", 6666);
		int value = test.get("Dong Zhou");
		System.out.println(value);
	}

}
