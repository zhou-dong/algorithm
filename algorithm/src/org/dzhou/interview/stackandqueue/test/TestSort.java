package org.dzhou.interview.stackandqueue.test;

import org.dzhou.interview.stackandqueue.Stack;
import org.dzhou.interview.stackandqueue.StackSort;
import org.junit.Assert;
import org.junit.Test;

public class TestSort {

	@Test
	public void testSort() {
		Stack<Integer> stack = new Stack<>();
		int size = 15;
		for (int i = 0; i < size; i++) {
			int data = (int) (Math.random() * 30);
			System.out.print(data + " ");
			stack.push(data);
		}
		System.out.println();
		stack = StackSort.sort(stack);
		int tmp = stack.pop();
		System.out.print(tmp + " ");
		for (int i = 1; i < size; i++) {
			int result = stack.pop();
			System.out.print(result + " ");
			Assert.assertTrue(tmp <= result);
			tmp = result;
		}
	}

}
