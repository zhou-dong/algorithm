package org.dzhou.interview.recursiondynamicprogramming.test;

import org.dzhou.interview.recursiondynamicprogramming.Fibonacci;
import org.junit.Assert;
import org.junit.Test;

public class TestFibonacci {

	/*
	 * F0 F1 F2 F3 F4 F5 F6 F7 F8 F9 F10 F11 F12 F13 F14 F15 F16 F17 F18 F19 F20
	 * 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765
	 */
	@Test
	public void testFibonacci() {
		Fibonacci fibonacci = new Fibonacci();
		Assert.assertEquals(6765, fibonacci.fibonacci(20));
	}

	@Test
	public void testFibonacci2() {
		Fibonacci fibonacci = new Fibonacci();
		Assert.assertEquals(4181, fibonacci.fibonacci(19));
	}

	@Test
	public void testFibonacci3() {
		Fibonacci fibonacci = new Fibonacci();
		Assert.assertEquals(2584, fibonacci.fibonacci(18));
	}

	@Test
	public void testFibonacci4() {
		Fibonacci fibonacci = new Fibonacci();
		Assert.assertEquals(1597, fibonacci.fibonacci(17));
	}

}
