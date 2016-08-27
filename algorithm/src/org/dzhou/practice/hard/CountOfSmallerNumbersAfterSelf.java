package org.dzhou.practice.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts
 * array. The counts array has the property where counts[i] is the number of
 * smaller elements to the right of nums[i].
 * 
 * Example:
 * 
 * Given nums = [5, 2, 6, 1]
 * 
 * To the right of 5 there are 2 smaller elements (2 and 1). <br>
 * To the right of 2 there is only 1 smaller element (1).<br>
 * To the right of 6 there is 1 smaller element (1).<br>
 * To the right of 1 there is 0 smaller element.<br>
 * 
 * Return the array [2, 1, 1, 0].
 * 
 * @author zhoudong
 *
 */
public class CountOfSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		new CountOfSmallerNumbersAfterSelf().test();
	}

	void test() {
		// int[] nums = { 5, 2, 6, 1 };
		// int[] nums = { 2, 1, 0 };
		int[] nums = { -1, -1 };
		System.out.println(new Solution().countSmaller(nums));
	}

	// BST
	public class Solution {

		class Node {
			int val;
			Node left;
			Node right;
			int leftSize;

			Node(int value) {
				this.val = value;
				this.leftSize = 0;
			}
		}

		public List<Integer> countSmaller(int[] nums) {
			if (nums == null || nums.length == 0)
				return Collections.emptyList();
			return bst(nums);
		}

		private List<Integer> bst(int[] nums) {
			List<Integer> result = new ArrayList<>();
			result.add(0);
			if (nums.length == 1) {
				return result;
			}
			Node root = new Node(nums[nums.length - 1]);
			for (int i = nums.length - 2; i >= 0; i--) {
				int value = nums[i], count = 0;
				Node current = root, parent = null;
				boolean isLeft = false;
				while (current != null) {
					parent = current;
					if (value > current.val) {
						count += current.leftSize;
						count++;
						current = current.right;
						isLeft = false;
					} else {
						current.leftSize++;
						current = current.left;
						isLeft = true;
					}
				}
				result.add(count);
				if (isLeft)
					parent.left = new Node(value);
				else
					parent.right = new Node(value);

			}
			Collections.reverse(result);
			return result;
		}

	}

}
