package org.dzhou.os.disk.scheduling.test;

import org.dzhou.os.disk.scheduling.Scheduling.FCFS;
import org.dzhou.os.disk.scheduling.Scheduling.SSTF;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestScheduling {

	int[] range = null;
	int[] cylinders = null;
	int header = 0;
	int previous = 0;

	@Before
	public void init() {
		range = new int[] { 0, 4999 };
		cylinders = new int[] { 86, 1470, 913, 1774, 948, 1509, 1022, 1750, 130 };
		header = 143;
		previous = 125;
	}

	@Test
	public void testFCFS() {
		int actual = new FCFS().execute(range, cylinders, header, previous);
		Assert.assertEquals(7081, actual);
	}

	@Test
	public void testSSTF() {
		int actual = new SSTF().execute(range, cylinders, header, previous);
		Assert.assertEquals(1745, actual);
	}
}
