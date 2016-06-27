package org.dzhou.practice.medium;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * [<br>
 * -----[2], <br>
 * ----[3,4],<br>
 * ---[6,5,7],<br>
 * --[4,1,8,3]<br>
 * ]<br>
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 * 
 * @author zhoudong
 *
 */
public class Triangle {

	// 递推式是sum[i][j]=min(sum[i-1][j-1],sum[i-1][j])+triangle[i][j]
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() == 0)
			return 0;
		int[] res = new int[triangle.size()];
		for (int i = 0; i < triangle.size(); i++) {
			res[i] = triangle.get(triangle.size() - 1).get(i);
		}
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				res[j] = Math.min(res[j], res[j + 1]) + triangle.get(i).get(j);
			}
		}
		return res[0];
	}

}
