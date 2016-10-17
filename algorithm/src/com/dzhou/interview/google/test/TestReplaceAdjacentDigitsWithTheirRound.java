package com.dzhou.interview.google.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dzhou.interview.google.ReplaceAdjacentDigitsWithTheirRound;

public class TestReplaceAdjacentDigitsWithTheirRound {

	ReplaceAdjacentDigitsWithTheirRound instance = null;

	@Before
	public void init() {
		instance = new ReplaceAdjacentDigitsWithTheirRound();
	}

	@Test
	public void test() {
		test(11, 1);
		test(112, 11);
		test(121, 11);
		test(131, 12);
		test(141, 12);
	}

	private void test(int input, int expected) {
		Assert.assertEquals(expected, instance.Solution(input));
	}

}
