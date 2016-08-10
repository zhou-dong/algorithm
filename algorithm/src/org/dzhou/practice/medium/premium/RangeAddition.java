package org.dzhou.practice.medium.premium;

/**
 * Assume you have an array of length n initialized with all 0's and are given k
 * update operations.
 * 
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which
 * increments each element of subarray A[startIndex ... endIndex] (startIndex
 * and endIndex inclusive) with inc.
 * 
 * Return the modified array after all k operations were executed.
 * 
 * Example: <br>
 * Given: <br>
 * length = 5, <br>
 * 
 * updates = <br>
 * ----[ <br>
 * --------[1, 3, 2], <br>
 * --------[2, 4, 3], <br>
 * --------[0, 2, -2] <br>
 * ----]
 * 
 * Output:
 * 
 * [-2, 0, 3, 5, 3]<br>
 * Explanation:
 * 
 * Initial state: <br>
 * [ 0, 0, 0, 0, 0 ]
 * 
 * After applying operation [1, 3, 2]: <br>
 * [ 0, 2, 2, 2, 0 ]
 * 
 * After applying operation [2, 4, 3]: <br>
 * [ 0, 2, 5, 5, 3 ]
 * 
 * After applying operation [0, 2, -2]: <br>
 * [-2, 0, 3, 5, 3 ]
 * 
 * Hint:
 * 
 * 1. Thinking of using advanced data structures? You are thinking it too
 * complicated. <br>
 * 2. For each update operation, do you really need to update all elements
 * between i and j? <br>
 * 3. Update only the first and end element is sufficient. <br>
 * 4. The optimal time complexity is O(k + n) and uses O(1) extra space. <br>
 * 
 * @author zhoudong
 *
 *         reference:
 * 
 *         https://discuss.leetcode.com/topic/49691/java-o-k-n-time-complexity-
 *         solution
 */
public class RangeAddition {

	/**
	 * Just store every start index for each value and at end index plus one
	 * minus it <br>
	 * for example it will look like: <br>
	 * [1 , 3 , 2] , [2, 3, 3] (length = 5) <br>
	 * res[ 0, 2, ,0, 0 -2 ] <br>
	 * res[ 0 ,2, 3, 0, -5] <br>
	 * sum 0, 2, 5, 5, 0 <br>
	 * res[0, 2, 5, 5, 0] <br>
	 */
	public class Solution {

		public int[] getModifiedArray(int length, int[][] updates) {
			if (updates == null || updates.length == 0)
				return new int[length];

			int[] result = new int[length];

			for (int[] triplet : updates) {
				int start = triplet[0];
				int end = triplet[1];
				int value = triplet[2];
				result[start] += value;
				if (end + 1 < result.length) {
					result[end + 1] -= value;
				}
			}

			for (int i = 1; i < result.length; i++) {
				result[i] += result[i - 1];
			}
			return result;
		}

	}

	public class Solution1 {

		public int[] getModifiedArray(int length, int[][] updates) {
			int[] result = new int[length];
			if (updates == null || updates.length == 0)
				return result;
			for (int[] triplet : updates) {
				update(result, triplet[0], triplet[1], triplet[2]);
			}
			return result;
		}

		private void update(int[] result, int low, int high, int val) {
			for (int i = low; i <= high; i++) {
				result[i] += val;
			}
		}

	}

}
