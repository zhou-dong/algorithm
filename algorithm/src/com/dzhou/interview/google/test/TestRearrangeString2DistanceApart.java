package com.dzhou.interview.google.test;

import org.junit.Before;
import org.junit.Test;

import com.dzhou.interview.google.RearrangeString2DistanceApart;

public class TestRearrangeString2DistanceApart {

	RearrangeString2DistanceApart instance = null;

	@Before
	public void init() {
		instance = new RearrangeString2DistanceApart();
	}

	@Test
	public void test() {
		String str = "caat";
		String actual = instance.rearrangeString(str);
		System.out.println(actual);
	}
}
