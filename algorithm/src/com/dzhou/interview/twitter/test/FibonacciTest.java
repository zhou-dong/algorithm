package com.dzhou.interview.twitter.test;

import org.junit.Assert;
import org.junit.Test;

import com.dzhou.interview.twitter.Fibonacci;

public class FibonacciTest {

	@Test
	public void test0() {
		int[] expecteds = { 0, 1, 1, 2 };
		int[] actuals = new Fibonacci().numbers(4);
		Assert.assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test1() {
		int[] expecteds = { 0 };
		int[] actuals = new Fibonacci().numbers(1);
		Assert.assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test2() {
		int[] expecteds = { 0, 1 };
		int[] actuals = new Fibonacci().numbers(2);
		Assert.assertArrayEquals(expecteds, actuals);
	}

}
