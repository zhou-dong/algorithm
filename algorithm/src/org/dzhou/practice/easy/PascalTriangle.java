package org.dzhou.practice.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 * 
 * @author zhoudong
 *
 */
public class PascalTriangle {

	public List<List<Integer>> generate(int numRows) {
		if (numRows < 1) {
			return Collections.emptyList();
		}
		List<List<Integer>> result = new LinkedList<>();
		// add first level
		List<Integer> zeroLevel = new LinkedList<>();
		zeroLevel.add(1);
		result.add(zeroLevel);
		// add other level
		for (int i = 1; i < numRows; i++) {
			List<Integer> pre = result.get(i - 1);
			List<Integer> cur = new LinkedList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i)
					cur.add(1);
				else
					cur.add(pre.get(j - 1) + pre.get(j));
			}
			result.add(cur);
		}
		return result;
	}

}
