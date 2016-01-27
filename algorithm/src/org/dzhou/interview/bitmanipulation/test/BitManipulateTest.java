package org.dzhou.interview.bitmanipulation.test;

import org.dzhou.interview.bitmanipulation.BinaryToString;
import org.dzhou.interview.bitmanipulation.Debugger;
import org.junit.Assert;
import org.junit.Test;

public class BitManipulateTest {

	@Test
	public void testIsPowerTo2() {
		Assert.assertTrue(new Debugger().isPowerTo2(4));
		Assert.assertTrue(new Debugger().isPowerTo2(8));
		Assert.assertTrue(new Debugger().isPowerTo2(16));
		Assert.assertFalse(new Debugger().isPowerTo2(15));
	}

	@Test
	public void testBinaryToString() {
		BinaryToString target = new BinaryToString();
		Assert.assertEquals(".01", target.printBinary(0.25));
		Assert.assertEquals(".1101", target.printBinary(0.8125));
	}

	@Test
	public void testBinaryToString2() {
		BinaryToString target = new BinaryToString();
		Assert.assertEquals(".01", target.printBinary2(0.25));
		Assert.assertEquals(".1101", target.printBinary2(0.8125));
	}

}
