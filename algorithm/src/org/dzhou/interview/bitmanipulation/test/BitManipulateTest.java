package org.dzhou.interview.bitmanipulation.test;

import org.dzhou.interview.bitmanipulation.BinaryToString;
import org.dzhou.interview.bitmanipulation.Conversion;
import org.dzhou.interview.bitmanipulation.Debugger;
import org.dzhou.interview.bitmanipulation.FlipBitToWin;
import org.dzhou.interview.bitmanipulation.PairwiseSwap;
import org.junit.Assert;
import org.junit.Test;

public class BitManipulateTest {

	@Test
	public void testFlip() {
		Assert.assertEquals(8, new FlipBitToWin().longestSequence(1775));
	}

	@Test
	public void testSwapOddEvenBits() {
		Assert.assertEquals(8, new PairwiseSwap().swapOddEvenBits(4));
		Assert.assertEquals(4, new PairwiseSwap().swapOddEvenBits(8));
		Assert.assertEquals(10, new PairwiseSwap().swapOddEvenBits(5));
	}

	@Test
	public void testConversion() {
		Assert.assertEquals(2, new Conversion().bitSwapRequired(15, 29));
		Assert.assertEquals(2, new Conversion().bitSwapRequired2(29, 15));
	}

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
