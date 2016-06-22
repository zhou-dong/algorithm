package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * 
 * 1. "123"<br>
 * 2. "132"<br>
 * 3. "213"<br>
 * 4. "231"<br>
 * 5. "312"<br>
 * 6. "321"<br>
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * @author zhoudong
 *
 *         有两种方法：<br>
 *         1：使用DFS做全排列，然后找到第K个组合，然后返回。（会超时） <br>
 *         2：数学解法:(reference: http://www.cnblogs.com/springfor/p/3896201.html)
 * 
 */
public class PermutationSequence {

	/*
	 * 数学解法。
	 * 
	 * 对于n个数可以有n!种排列；那么n-1个数就有(n-1)!种排列。
	 * 
	 * 那么对于n位数来说，如果除去最高位不看，后面的n-1位就有 (n-1)!种排列。
	 * 
	 * 所以，还是对于n位数来说，每一个不同的最高位数，后面可以拼接(n-1)!种排列。
	 * 
	 * 利用 k/(n-1)! 可以取得最高位在数列中的index。这样第k个排列的最高位就能从数列中的index位取得，此时还要把这个数从数列中删除。
	 * 
	 * 然后，新的k就可以有k%(n-1)!获得。循环n次即可。
	 * 
	 */
	public class Solution {

		public String getPermutation(int n, int k) {
			k--;// to transfer it as begin from 0 rather than 1

			List<Integer> numList = new ArrayList<Integer>();
			for (int i = 1; i <= n; i++)
				numList.add(i);

			// 求阶乘
			int factorial = 1;
			for (int i = 2; i < n; i++)
				factorial *= i;

			StringBuilder res = new StringBuilder();
			int times = n - 1;
			while (times >= 0) {
				int indexInList = k / factorial;
				res.append(numList.get(indexInList));
				numList.remove(indexInList);

				k = k % factorial;// new k for next turn
				if (times != 0)
					factorial = factorial / times;// new (n-1)!
				times--;
			}

			return res.toString();
		}

	}

	// DFS Time Limit Exceeded
	public class Solution1 {

		String result = null;

		public String getPermutation(int n, int k) {
			dfs(n, k, 0, new StringBuilder());
			return result;
		}

		private void dfs(int n, int k, int count, StringBuilder sb) {
			if (sb.length() == n)
				count++;
			if (count == k) {
				result = sb.toString();
				return;
			}
			for (int i = 1; i <= n; i++) {
				if (sb.length() > 0 && sb.charAt(sb.length() - 1) == i)
					continue;
				sb.append(i);
				dfs(i, k, count, sb);
				sb.deleteCharAt(sb.length() - 1);
			}
		}

	}

}
