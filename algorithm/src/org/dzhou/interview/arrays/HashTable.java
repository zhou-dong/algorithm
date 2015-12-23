package org.dzhou.interview.arrays;

/**
 * Use an array of linked lists and hash code function to insert a key or value
 * 
 * @author DONG ZHOU
 *
 */
public class HashTable<K, V> {

	static final int CAPACITY = 1 << 4;

	public static class Entity<K, V> {
		int hash;
		K key = null;
		V value = null;

		public Entity(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	Entity<K, V>[] table = null;

	@SuppressWarnings("unchecked")
	public HashTable() {
		table = (Entity<K, V>[]) new Entity[CAPACITY];
	}

	static final int hash(Object key) {
		return (key == null) ? 0 : (key.hashCode()) % CAPACITY;
	}

	public void put(K key, V value) {

	}

	public static void main(String[] args) {
	}

}
