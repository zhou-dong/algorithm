package org.dzhou.practice.easy.premium;

import java.util.HashMap;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Write a function to determine if a number is strobogrammatic. The number is
 * represented as a string.
 * 
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 * 
 * @author zhoudong
 *
 */
public class StrobogrammaticNumber {

	public class Solution {

		public boolean isStrobogrammatic(String num) {
			Map<Character, Character> map = new HashMap<Character, Character>();
			map.put('1', '1');
			map.put('0', '0');
			map.put('6', '9');
			map.put('9', '6');
			map.put('8', '8');
			for (int low = 0, high = num.length() - 1; low <= high; low++, high--) {
				if (!map.containsKey(num.charAt(low)) || map.get(num.charAt(low)) != num.charAt(high)) {
					return false;
				}
			}
			return true;
		}

	}

}
