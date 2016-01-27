package org.dzhou.interview.bitmanipulation.test;

import org.dzhou.interview.bitmanipulation.CommonBitTask;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommonBitTaskTest {

	CommonBitTask bitTask;

	@Before
	public void createBitTask() {
		bitTask = new CommonBitTask();
	}

	@Test
	public void testUpdateBit() {
		Assert.assertEquals(6, bitTask.updateBit(14, 3, false));
		Assert.assertEquals(30, bitTask.updateBit(14, 4, true));
	}

	@Test
	public void testSetBit() {
		Assert.assertEquals(6, bitTask.setBit(6, 2));
		Assert.assertEquals(14, bitTask.setBit(6, 3));
	}

	@Test
	public void testGetBit() {
		Assert.assertTrue(bitTask.getBit(2, 1));
		Assert.assertTrue(bitTask.getBit(4, 2));
	}

	@Test
	public void testRepeatedArithmeticShift() {
		Assert.assertEquals(2, bitTask.repeatedArithmeticShift(4, 1));
		Assert.assertEquals(1, bitTask.repeatedArithmeticShift(4, 2));
		Assert.assertEquals(-2, bitTask.repeatedArithmeticShift(-4, 1));
		Assert.assertEquals(-1, bitTask.repeatedArithmeticShift(-4, 2));
	}

	@Test
	public void testRepeatedLogicalShift() {
		Assert.assertTrue(bitTask.repeatedLogicalShift(-4, 1) > 0);
		Assert.assertTrue(bitTask.repeatedLogicalShift(-4, 2) > 0);
	}

}
