package org.dzhou.practice.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
		for (int i = 0; i < result.length; i++) {
			if (i == 0 || i == rowIndex)
				result[i] = 1;
			else
				result[i] = 0;
		}
		for (int i = 1; i < rowIndex + 1; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == rowIndex)
					continue;
				result[j] = result[j - 1] + result[j];
			}
		}
		return Arrays.asList(result);
	}

	public static void main(String[] args) {
		PascalTriangleII instance = new PascalTriangleII();
		System.out.println(instance.getRow(3));
	}
}
