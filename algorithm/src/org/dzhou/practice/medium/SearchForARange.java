package org.dzhou.practice.medium;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example:<br>
 * Given [5, 7, 7, 8, 8, 10] and target value 8<br>
 * return [3, 4].
 * 
 * @author zhoudong
 *
 *         参考自：http://www.cnblogs.com/springfor/p/3857704.html (写的太好了)
 * 
 */
public class SearchForARange {

	public class Solution {

		public int[] searchRange(int[] nums, int target) {

			int[] result = { -1, -1 };
			if (nums == null || nums.length == 0)
				return result;

			// find position
			int low = 0, high = nums.length - 1, position = -1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (nums[mid] == target) {
					position = mid;
					break;
				} else if (nums[mid] > target) {
					high = mid - 1;
				} else
					low = mid + 1;
			}

			if (position == -1)
				return result;

			// find left boundary
			low = 0;
			high = position;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (nums[mid] == target)
					high = mid - 1;
				else
					low = mid + 1;
			}
			result[0] = low;

			// find right boundary
			low = position;
			high = nums.length - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (nums[mid] == target)
					low = mid + 1;
				else
					high = mid - 1;
			}
			result[1] = high;

			return result;
		}

	}

}
