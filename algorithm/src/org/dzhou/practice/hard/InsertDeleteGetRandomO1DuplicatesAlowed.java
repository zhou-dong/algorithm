package org.dzhou.practice.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Design a data structure that supports all following operations in average
 * O(1) time.
 * 
 * Note: Duplicate elements are allowed. <br>
 * 
 * 1.insert(val): Inserts an item val to the collection. <br>
 * 2.remove(val): Removes an item val from the collection if present. <br>
 * 3.getRandom: Returns a random element from current collection of elements.
 * The probability of each element being returned is linearly related to the
 * number of same value the collection contains.
 * 
 * @author zhoudong
 *
 */
public class InsertDeleteGetRandomO1DuplicatesAlowed {

	public class RandomizedCollection {

		Map<Integer, Set<Integer>> map = null;
		List<Integer> list = null;
		Random random = null;

		/** Initialize your data structure here. */
		public RandomizedCollection() {
			map = new HashMap<>();
			list = new ArrayList<>();
			random = new Random();
		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did
		 * not already contain the specified element.
		 */
		public boolean insert(int val) {
			int index = list.size();
			list.add(val);
			if (map.containsKey(val)) {
				map.get(val).add(index);
				return false;
			} else {
				map.put(val, new HashSet<>());
				map.get(val).add(index);
				return true;
			}
		}

		/**
		 * Removes a value from the collection. Returns true if the collection
		 * contained the specified element.
		 */
		public boolean remove(int val) {
			if (!map.containsKey(val)) {
				return false;
			}
			Set<Integer> indices = map.get(val);
			int index = indices.iterator().next();
			indices.remove(index);
			if (indices.isEmpty()) {
				map.remove(val);
			}
			if (index == list.size() - 1) {
				list.remove(list.size() - 1);
				return true;
			}
			int last = list.get(list.size() - 1);
			swap(index, list.size() - 1);
			list.remove(list.size() - 1);
			map.get(last).add(index);
			map.get(last).remove(list.size());
			return true;
		}

		private void swap(int x, int y) {
			int temp = list.get(x);
			list.set(x, list.get(y));
			list.set(y, temp);
		}

		/** Get a random element from the collection. */
		public int getRandom() {
			return list.get(random.nextInt(list.size()));
		}
	}

	// Your RandomizedCollection object will be instantiated and called as such:
	// RandomizedCollection obj = new RandomizedCollection();
	// boolean param_1 = obj.insert(val);
	// boolean param_2 = obj.remove(val);
	// int param_3 = obj.getRandom();
}
