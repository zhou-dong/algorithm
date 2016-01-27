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
