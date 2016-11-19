package com.dzhou.interview.google;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class PartitionEqualSubsetSumTest {

	PartitionEqualSubsetSum instance = null;

	@Before
	public void init() {
		instance = new PartitionEqualSubsetSum();
	}

	@Test
	public void test() {
		Assert.assertEquals(false, instance.canPartition(new int[] { 2, 2, 3, 5 }));
	}

}
