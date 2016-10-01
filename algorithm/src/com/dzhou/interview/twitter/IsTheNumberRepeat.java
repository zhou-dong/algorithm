package com.dzhou.interview.twitter;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, print 2 bitstrings, one if number has occurred
 * before in the array, the other if the number has occurred after the array.
 * 
 * Example:
 * 
 * input：1 3 2 3 4 1
 * 
 * output：000101 110000
 * 
 * @author zhoudong
 *
 */
public class IsTheNumberRepeat {

	public String[] isTheNumberRepeat(int[] nums) {
		if (nums == null || nums.length == 0)
			return new String[0];
		return new String[] { leftToRight(nums), rightToLeft(nums) };
	}

	private String leftToRight(int[] nums) {
		char[] mark = new char[nums.length];
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				mark[i] = '1';
			} else {
				set.add(nums[i]);
				mark[i] = '0';
			}
		}
		return new String(mark);
	}

	private String rightToLeft(int[] nums) {
		char[] mark = new char[nums.length];
		Set<Integer> set = new HashSet<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			if (set.contains(nums[i])) {
				mark[i] = '1';
			} else {
				set.add(nums[i]);
				mark[i] = '0';
			}
		}
		return new String(mark);
	}

}