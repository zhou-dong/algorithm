package org.dzhou.interview.stackandqueue.test;

import org.dzhou.interview.stackandqueue.Queue;
import org.junit.Assert;
import org.junit.Test;

public class TestQueue {

	Queue<Integer> queue = new Queue<>();

	@Test
	public void testAddAndRemove() {
		for (int i = 0; i < 10; i++) {
			queue.add(i * 3);
			Assert.assertEquals(i * 3, queue.remove().intValue());
		}
	}

	@Test
	public void testPeek() {
		for (int i = 0; i < 10; i++) {
			queue.add(i * 3);
			Assert.assertEquals(0, queue.peek().intValue());
		}
	}

}
