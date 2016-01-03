package org.dzhou.interview.stackandqueue.test;

import org.dzhou.interview.stackandqueue.FixedMultiStack;
import org.junit.Assert;
import org.junit.Test;

public class TestFixedMultiStack {

	int stackSize = 10;
	FixedMultiStack stack = new FixedMultiStack(stackSize);

	@Test
	public void testPush() {
		for (int x = 0; x < 3; x++) {
			for (int i = 0; i < stackSize; i++) {
				int value = i * 2;
				stack.push(x, value);
				Assert.assertEquals(value, stack.peek(x));
			}
		}
	}

	@Test
	public void testPop() {
		for (int x = 0; x < 3; x++) {
			for (int i = 0; i < stackSize; i++) {
				int value = i * 2;
				stack.push(x, value);
				Assert.assertEquals(value, stack.pop(x));
			}
		}
	}

}
