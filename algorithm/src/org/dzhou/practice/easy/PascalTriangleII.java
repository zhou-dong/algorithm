package org.dzhou.practice.easy;

import java.util.Arrays;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author zhoudong
 *
 */
public class PascalTriangleII {

	public List<Integer> getRow(int rowIndex) {
		Integer[] result = new Integer[rowIndex + 1];
		result[0] = 1;
		for (int i = 1; i < rowIndex + 1; i++) {
			result[i] = 1;
			for (int j = i - 1; j > 0; j--) {
				result[j] = result[j - 1] + result[j];
			}
		}
		return Arrays.asList(result);
	}

}
