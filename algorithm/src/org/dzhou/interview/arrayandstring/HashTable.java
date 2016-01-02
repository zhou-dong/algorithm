package org.dzhou.interview.arrayandstring;

import java.util.Iterator;
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
		Entity<K, V> entity = getEntity(key);
		if (entity == null)
			return null;
		return entity.value;
	}

	private Entity<K, V> getEntity(K key) {
		if (key == null)
			return null;
		int hash = hash(key);
		List<Entity<K, V>> list = table[hash];
		if (list == null || list.size() == 0)
			return null;
		for (Entity<K, V> entity : list)
			if (key.equals(entity.key))
				return entity;
		return null;
	}

	public void update(K key, V value) {
		Entity<K, V> entity = getEntity(key);
		if (entity != null)
			entity.value = value;
	}

	public void delete(K key) {
		if (key == null)
			return;
		int hash = hash(key);
		List<Entity<K, V>> list = table[hash];
		if (list == null || list.size() == 0)
			return;
		Iterator<Entity<K, V>> iterator = list.iterator();
		while (iterator.hasNext()) {
			Entity<K, V> entity = iterator.next();
			if (key.equals(entity.key)) {
				iterator.remove();
			}
		}
	}

	public static void main(String[] args) {
		String key = "dongzhou";
		HashTable<String, String> test = new HashTable<>();
		test.put(key, "first");
		System.out.println(test.get(key));
		test.update(key, "second");
		System.out.println(test.get(key));
		test.delete(key);
		System.out.println(test.get(key));
	}

}
