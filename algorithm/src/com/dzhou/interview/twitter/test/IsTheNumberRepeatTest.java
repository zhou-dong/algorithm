package com.dzhou.interview.twitter.test;

import org.junit.Assert;
import org.junit.Test;

import com.dzhou.interview.twitter.IsTheNumberRepeat;

public class IsTheNumberRepeatTest {

	@Test
	public void test0() {
		int[] nums = { 1, 3, 2, 3, 4, 1 };
		String[] actuals = new IsTheNumberRepeat().isTheNumberRepeat(nums);
		String[] expecteds = { "000101", "110000" };
		Assert.assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test1() {
		int[] nums = {};
		String[] actuals = new IsTheNumberRepeat().isTheNumberRepeat(nums);
		Assert.assertArrayEquals(new String[0], actuals);
	}

}
