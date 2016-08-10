package org.dzhou.practice.easy.premium;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following
 * operations: add and find.
 * 
 * add - Add the number to an internal data structure. find - Find if there
 * exists any pair of numbers which sum is equal to the value.
 * 
 * For example,<br>
 * add(1); add(3); add(5); <br>
 * find(4) -> true <br>
 * find(7) -> false <br>
 * 
 * @author zhoudong
 *
 */
public class TwoSumIIIDataStructureDesign {

	public class TwoSum {

		Map<Integer, Integer> map = new HashMap<>();

		// Add the number to an internal data structure.
		public void add(int number) {
			if (map.containsKey(number)) {
				map.put(number, map.get(number) + 1);
			} else {
				map.put(number, 1);
			}
		}

		// Find if there exists any pair of numbers which sum is equal to the
		// value.
		public boolean find(int value) {
			for (int key : map.keySet()) {
				int val = value - key;
				if (key != val && map.containsKey(val))
					return true;
				if (key == val && map.get(key) > 1)
					return true;
			}
			return false;
		}

	}

	// Your TwoSum object will be instantiated and called as such:
	// TwoSum twoSum = new TwoSum();
	// twoSum.add(number);
	// twoSum.find(value);

}
