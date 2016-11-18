package com.dzhou.interview.google.test;

import org.junit.Before;
import org.junit.Test;

import com.dzhou.interview.google.OneThreeTwoPattern.BruteForce_Solution;

import junit.framework.Assert;

public class TestOneThreeTwoPattern {

	BruteForce_Solution instance = null;

	@Before
	public void init() {
		instance = new BruteForce_Solution();
	}

	@Test
	public void test() {
		Assert.assertEquals(true, instance.find132pattern(new int[] { 3, 5, 0, 3, 4 }));
	}

}
