package com.dzhou.interview.google;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestArithmeticSlicesII {

	ArithmeticSlicesII instance;

	@Before
	public void init() {
		instance = new ArithmeticSlicesII();
	}

	@Test
	public void test() {
		int actual = instance.numberOfArithmeticSlices(new int[] { 2, 4, 6, 8, 10 });
		Assert.assertEquals(7, actual);
	}

}
