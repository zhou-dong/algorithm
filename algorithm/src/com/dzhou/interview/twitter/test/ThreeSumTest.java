package com.dzhou.interview.twitter.test;

import java.util.Set;

import org.junit.Test;

import com.dzhou.interview.twitter.ThreeSum;

public class ThreeSumTest {

	@Test
	public void test() {
		int[] nums = { 2, 3, 1, -2, -1, 0, 2, -3, 0 };
		Set<Set<Integer>> expected = new ThreeSum().threeSum(nums);
		System.out.println(expected);
	}

}
