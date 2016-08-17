package org.dzhou.practice.medium.premium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Find all strobogrammatic numbers that are of length = n.
 * 
 * For example, Given n = 2, return ["11","69","88","96"].
 * 
 * Hint:
 * 
 * Try to use recursion and notice that it should recurse with n - 2 instead of
 * n - 1.
 * 
 * @author zhoudong
 *
 *         n = 0: none <br>
 *         n = 1: 0, 1, 8<br>
 *         n = 2: 11, 69, 88, 96<br>
 *         n = 3: 101, 609, 808, 906, 111, 619, 818, 916, 181, 689,888,986 <br>
 *         n = 4: 1001, 6009, 8008, 9006, 1111, 6119, 8118, 9116, 1691, 6699,
 *         8698, 9696, 1881, 6889, 8888, 9886, 1961, 6969, 8968, 9966
 */
public class StrobogrammaticNumberII {

	public class Solution {

		String[] one = new String[] { "0", "1", "8" };
		String[] two = new String[] { "11", "69", "88", "96" };
		char[] chars = new char[] { '0', '1', '8' };
		char[] more = new char[] { '6', '9' };

		public List<String> findStrobogrammatic(int n) {
			if (n < 1)
				return Collections.emptyList();
			if (n == 1)
				return Arrays.asList(one);
			if (n == 2)
				return Arrays.asList(two);
			return helper(n);
		}

		private List<String> helper(int n) {
			List<String> result = Arrays.asList(two);

			n -= 2;
			while (n > 0) {

				n--;
			}

			return result;

		}
	}

}
