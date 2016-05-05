package org.dzhou.practice.easy.test;

import org.dzhou.practice.easy.PowerOfFour;
import org.junit.Assert;
import org.junit.Test;

public class PowerOfFourTest {

	@Test
	public void test() {
		Assert.assertTrue(PowerOfFour.isPowerOfFour(16));
		Assert.assertFalse(PowerOfFour.isPowerOfFour(24));
	}

	@Test
	public void test2() {
		Assert.assertTrue(PowerOfFour.isPowerOfFour2(16));
		Assert.assertFalse(PowerOfFour.isPowerOfFour2(24));
		Assert.assertFalse(PowerOfFour.isPowerOfFour2(17));
	}

}
