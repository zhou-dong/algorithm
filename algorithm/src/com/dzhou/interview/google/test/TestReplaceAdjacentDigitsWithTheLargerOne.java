package com.dzhou.interview.google.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dzhou.interview.google.ReplaceAdjacentDigitsWithTheLargerOne;

public class TestReplaceAdjacentDigitsWithTheLargerOne {

	ReplaceAdjacentDigitsWithTheLargerOne instance = null;

	@Before
	public void init() {
		instance = new ReplaceAdjacentDigitsWithTheLargerOne();
	}

	@Test
	public void testIntegerToList() {
		testIntegerToList(1, new Integer[] { 1 });
		testIntegerToList(110, new Integer[] { 1, 1, 0 });
		testIntegerToList(12345, new Integer[] { 1, 2, 3, 4, 5 });
		testIntegerToList(233614, new Integer[] { 2, 3, 3, 6, 1, 4 });
	}

	private void testIntegerToList(int x, Integer[] expected) {
		List<Integer> actual = instance.convertIntegerToList(x);
		Assert.assertEquals(Arrays.asList(expected), actual);
	}

	@Test
	public void testListToInteger() {
		testListToInteger(1, new Integer[] { 1 });
		testListToInteger(110, new Integer[] { 1, 1, 0 });
		testListToInteger(12345, new Integer[] { 1, 2, 3, 4, 5 });
		testListToInteger(233614, new Integer[] { 2, 3, 3, 6, 1, 4 });
		testListToInteger(233614, new Integer[] { 2, 3, 3, 6, -1, 1, 4 });
	}

	private void testListToInteger(int expected, Integer[] input) {
		int actual = instance.convertListToInteger(Arrays.asList(input));
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test() {
		test(23364, 233614);
		test(100, 1000);
		test(1, 10);
		test(17763, 177763);
	}

	private void test(int expected, int x) {
		Assert.assertEquals(expected, instance.Solution(x));
	}

}
