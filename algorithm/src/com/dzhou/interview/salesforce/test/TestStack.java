package com.dzhou.interview.salesforce.test;

import org.junit.Before;
import org.junit.Test;

import com.dzhou.interview.salesforce.ImplementStackUsingArray.Stack;

import junit.framework.Assert;

public class TestStack {

	Stack stack;

	@Before
	public void init() {
		stack = new Stack(10);
	}

	@Test
	public void testAdd() {
		stack.push(1);
		stack.push(2);
		Assert.assertEquals(2, stack.pop());
		Assert.assertEquals(1, stack.pop());
	}

	@Test
	public void testPop() {
		stack.push(1);
		stack.push(2);
		Assert.assertEquals(2, stack.pop());
		Assert.assertEquals(1, stack.pop());
		Assert.assertEquals(true, stack.isEmpty());
	}

	@Test
	public void testExpend() {
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		Assert.assertEquals(10, stack.capacity());
		stack.push(10);
		Assert.assertEquals(20, stack.capacity());
	}

	@Test
	public void testShorter() {
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		Assert.assertEquals(10, stack.capacity());
		stack.push(10);
		Assert.assertEquals(20, stack.capacity());
		for (int i = 0; i < 10; i++) {
			stack.pop();
		}
		Assert.assertEquals(10, stack.capacity());
	}

	@Test
	public void testForLoop() {
		int[] nums = { 1, 2, 3, 4, 5, 6 };
		int[] expected = { 6, 5, 4, 3, 2, 1 };
		int[] actual = new int[expected.length];
		for (int i = 0; i < nums.length; i++) {
			stack.push(nums[i]);
		}
		for (int i = 0; i < nums.length; i++) {
			actual[i] = stack.pop();
		}
		for (int i = 0; i < nums.length; i++) {
			Assert.assertEquals(expected[i], actual[i]);
		}
	}

}
