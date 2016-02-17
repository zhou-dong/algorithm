package org.dzhou.interview.moderate.test;

import org.dzhou.interview.moderate.Swap;
import org.junit.Assert;
import org.junit.Test;

public class TestSwap {

	public void testSwap() {
		Swap.swap(-1, 8);
		Swap.swap_opt(-1, 8);
		Swap.swap_opt(5, 8);
	}

	@Test
	public void testSwapArray() {
		int[] origin = { 1, 2 };
		int[] swaped = { 2, 1 };
		Swap.swap(origin, 0, 1);
		Assert.assertArrayEquals(swaped, origin);
	}

	@Test
	public void testSwapArray_opt() {
		int[] origin = { 1, 2 };
		int[] swaped = { 2, 1 };
		Swap.swap_opt(origin, 0, 1);
		Assert.assertArrayEquals(swaped, origin);
	}

}
