package org.dzhou.practice.medium;

/**
 * Follow up for H-Index: What if the citations array is sorted in ascending
 * order? Could you optimize your algorithm?
 * 
 * Hint: Expected runtime complexity is in O(log n) and the input is sorted.
 * 
 * @author zhoudong
 *
 */
public class HIndexII {

	public class Solution {

		public int hIndex(int[] citations) {

			if (citations == null || citations.length == 0)
				return 0;

			// 计算H指数
			int result = 0;
			for (int i = citations.length - 1; i >= 0; i--) {
				if (result >= citations[i]) {
					return result;
				}
				result++;
			}

			return result;
		}

	}

}
