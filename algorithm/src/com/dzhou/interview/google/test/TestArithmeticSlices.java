package com.dzhou.interview.google.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dzhou.interview.google.ArithmeticSlices;

public class TestArithmeticSlices {

	ArithmeticSlices instance;

	@Before
	public void init() {
		instance = new ArithmeticSlices();
	}

	@Test
	public void testNumber() {
		Assert.assertEquals(0, instance.count(0));
		Assert.assertEquals(0, instance.count(1));
		Assert.assertEquals(0, instance.count(2));
		Assert.assertEquals(1, instance.count(3));
		Assert.assertEquals(3, instance.count(4));
		Assert.assertEquals(6, instance.count(5));
	}

}
