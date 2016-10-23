package com.dzhou.interview.google.test;

import org.junit.Before;
import org.junit.Test;

import com.dzhou.interview.google.SumTripletsLessThanK;

import junit.framework.Assert;

public class TestSumTripletsLessThanK {

	SumTripletsLessThanK instance = null;

	@Before
	public void init() {
		instance = new SumTripletsLessThanK();
	}

	@Test
	public void test() {
		int[] nums = { 5, 3, 6, 1, 8, 10 };
		int expected = 4;
		Assert.assertEquals(expected, instance.count(nums, 13));
	}

}
