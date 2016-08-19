package org.dzhou.practice.medium.premium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Design a Phone Directory which supports the following operations:
 * 
 * 1.get: Provide a number which is not assigned to anyone.
 * 
 * 2.check: Check if a number is available or not.
 * 
 * 3.release: Recycle or release a number.
 * 
 * Example:
 * 
 * // Init a phone directory containing a total of 3 numbers: 0, 1, and 2. <br>
 * PhoneDirectory directory = new PhoneDirectory(3);
 * 
 * // It can return any available phone number. Here we assume it returns 0.
 * <br>
 * directory.get();
 * 
 * // Assume it returns 1. <br>
 * directory.get();
 * 
 * // The number 2 is available, so return true. <br>
 * directory.check(2);
 * 
 * // It returns 2, the only number that is left. <br>
 * directory.get();
 * 
 * // The number 2 is no longer available, so return false. <br>
 * directory.check(2);
 * 
 * // Release number 2 back to the pool. <br>
 * directory.release(2);
 * 
 * // Number 2 is available again, return true. <br>
 * directory.check(2);
 * 
 * @author zhoudong
 *
 */
public class DesignPhoneDirectory {

	public class PhoneDirectory {

		int maxNumbers = 0;
		Queue<Integer> available = null;
		Set<Integer> inUse = null;

		/**
		 * Initialize your data structure here
		 * 
		 * @param maxNumbers
		 *            - The maximum numbers that can be stored in the phone
		 *            directory.
		 */
		public PhoneDirectory(int maxNumbers) {
			available = new LinkedList<>();
			inUse = new HashSet<>();
			this.maxNumbers = maxNumbers;
			for (int i = 0; i < maxNumbers; i++) {
				available.add(i);
			}
		}

		/**
		 * Provide a number which is not assigned to anyone.
		 * 
		 * @return - Return an available number. Return -1 if none is available.
		 */
		public int get() {
			if (available.isEmpty())
				return -1;
			int result = available.poll();
			inUse.add(result);
			return result;
		}

		/** Check if a number is available or not. */
		public boolean check(int number) {
			if (number < 0 || number >= maxNumbers)
				return false;
			return !inUse.contains(number);
		}

		/** Recycle or release a number. */
		public void release(int number) {
			if (inUse.contains(number)) {
				inUse.remove(number);
				available.add(number);
			}
		}
	}

	/**
	 * Your PhoneDirectory object will be instantiated and called as such:
	 * PhoneDirectory obj = new PhoneDirectory(maxNumbers); int param_1 =
	 * obj.get(); boolean param_2 = obj.check(number); obj.release(number);
	 */
}
