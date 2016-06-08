package org.dzhou.practice.medium;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.<br>
 * [1,3,5,6], 5 → 2<br>
 * [1,3,5,6], 2 → 1<br>
 * [1,3,5,6], 7 → 4<br>
 * [1,3,5,6], 0 → 0<br>
 * 
 * @author zhoudong
 *
 */
public class SearchInsertPosition {

	public class Solution {
		public int searchInsert(int[] nums, int target) {
			if (nums == null || nums.length == 0)
				return 0;
			int low = 0, high = nums.length - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (target > nums[mid])
					low = mid + 1;
				else if (target < nums[mid])
					high = mid - 1;
				else
					return mid;
			}
			return low;
		}
	}

}
