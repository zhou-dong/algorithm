package com.dzhou.interview.google.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dzhou.interview.google.ReplaceAdjacentDigitsWithTheLargerOne;

public class TestReplaceAdjacentDigitsWithTheLargerOne {

	ReplaceAdjacentDigitsWithTheLargerOne instance = null;

	@Before
	public void init() {
		instance = new ReplaceAdjacentDigitsWithTheLargerOne();
	}

	@Test
	public void testIntegerToList() {
		List<Integer> list = instance.convertIntegerToList(233614);
		Assert.assertEquals("233614", list.toString());
	}

}
