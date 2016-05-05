package org.dzhou.practice.easy.test;

import org.dzhou.practice.easy.PowerOfTwo;
import org.junit.Assert;
import org.junit.Test;

public class PowerOfTwoTest {

	int[] trues = { 1, 2, 8, 1024 };
	int[] falses = { -1, 0, 15, 54, 3072 };

	@Test
	public void test() {
		for (int x : trues)
			Assert.assertTrue(PowerOfTwo.isPowerOfTwo(x));
		for (int x : falses)
			Assert.assertFalse(PowerOfTwo.isPowerOfTwo(x));
	}

	@Test
	public void test1() {
		for (int x : trues)
			Assert.assertTrue(PowerOfTwo.isPowerOfTwo1(x));
		for (int x : falses)
			Assert.assertFalse(PowerOfTwo.isPowerOfTwo1(x));
	}

}
