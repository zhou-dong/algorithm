package org.dzhou.practice.medium;

import java.util.Stack;

/**
 * A sequence of numbers is called a wiggle sequence if the differences between
 * successive numbers strictly alternate between positive and negative. The
 * first difference (if one exists) may be either positive or negative. A
 * sequence with fewer than two elements is trivially a wiggle sequence.
 * 
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences
 * (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5]
 * and [1,7,4,5,5] are not wiggle sequences, the first because its first two
 * differences are positive and the second because its last difference is zero.
 * 
 * Given a sequence of integers, return the length of the longest subsequence
 * that is a wiggle sequence. A subsequence is obtained by deleting some number
 * of elements (eventually, also zero) from the original sequence, leaving the
 * remaining elements in their original order.
 * 
 * Input: [1,7,4,9,2,5] <br>
 * Output: 6 The entire sequence is a wiggle sequence.
 * 
 * Input: [1,17,5,10,13,15,10,5,16,8] <br>
 * Output: 7 There are several subsequences that achieve this length. One is
 * [1,17,10,13,10,16,8].
 * 
 * Input: [1,2,3,4,5,6,7,8,9] Output: 2
 * 
 * @author zhoudong
 *
 */
public class WiggleSubsequence {

	enum Mark {
		POSITIVE, NEGATIVE, ZERO;
		static Mark getMark(int value) {
			return value == 0 ? ZERO : value > 0 ? POSITIVE : NEGATIVE;
		}
	}

	public class Solution {

		public int wiggleMaxLength(int[] nums) {
			if (nums == null)
				return 0;
			if (nums.length < 2)
				return nums.length;
			Mark[] marks = new Mark[nums.length - 1];
			for (int i = 1; i < nums.length; i++) {
				marks[i - 1] = Mark.getMark(nums[i] - nums[i - 1]);
			}
			Stack<Mark> stack = new Stack<>();
			for (int i = 0; i < marks.length; i++) {
				if (marks[i] == Mark.ZERO)
					continue;
				if (stack.isEmpty() || marks[i] != stack.peek()) {
					stack.add(marks[i]);
				}
			}
			return stack.size() + 1;
		}
	}

}
