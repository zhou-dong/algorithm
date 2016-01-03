package org.dzhou.interview.stackandqueue.test;

import org.dzhou.interview.stackandqueue.Stack;
import org.junit.Assert;
import org.junit.Test;

public class TestStack {

	Stack<Integer> stack = new Stack<>();

	@Test
	public void testPush() {
		for (int i = 0; i < 10; i++) {
			stack.push(i * 2);
			Assert.assertEquals(i * 2, stack.peek().intValue());
		}
	}

	@Test
	public void testPop() {
		for (int i = 0; i < 10; i++)
			stack.push(i * 2);
		for (int i = 9; i > -1; i--) {
			Assert.assertEquals(stack.pop().intValue(), i * 2);
		}
	}

	@Test
	public void testPeek() {
		for (int i = 0; i < 10; i++)
			stack.push(i * 2);
		Assert.assertEquals(stack.pop().intValue(), 18);
	}

}
