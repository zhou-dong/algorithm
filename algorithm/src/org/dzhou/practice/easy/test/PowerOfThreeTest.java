package org.dzhou.practice.easy.test;

import org.dzhou.practice.easy.PowerOfThree;
import org.junit.Assert;
import org.junit.Test;

public class PowerOfThreeTest {

	int[] trues = { 1, 27, 9, 81 };
	int[] falses = { -1, 0, 15, 54 };

	@Test
	public void test() {
		for (int x : trues)
			Assert.assertTrue(PowerOfThree.isPowerOfThree(x));
		for (int x : falses)
			Assert.assertFalse(PowerOfThree.isPowerOfThree(x));
	}

	@Test
	public void test1() {
		for (int x : trues)
			Assert.assertTrue(PowerOfThree.isPowerOfThree1(x));
		for (int x : falses)
			Assert.assertFalse(PowerOfThree.isPowerOfThree1(x));
	}

	@Test
	public void test2() {
		for (int x : trues)
			Assert.assertTrue(PowerOfThree.isPowerOfThree2(x));
		for (int x : falses)
			Assert.assertFalse(PowerOfThree.isPowerOfThree2(x));
	}

	@Test
	public void test3() {
		for (int x : trues)
			Assert.assertTrue(PowerOfThree.isPowerOfThree3(x));
		for (int x : falses)
			Assert.assertFalse(PowerOfThree.isPowerOfThree3(x));
	}

	@Test
	public void test4() {
		for (int x : trues)
			Assert.assertTrue(PowerOfThree.isPowerOfThree4(x));
		for (int x : falses)
			Assert.assertFalse(PowerOfThree.isPowerOfThree4(x));
	}

	@Test
	public void test5() {
		for (int x : trues)
			Assert.assertTrue(PowerOfThree.isPowerOfThree5(x));
		for (int x : falses)
			Assert.assertFalse(PowerOfThree.isPowerOfThree5(x));
	}

}
