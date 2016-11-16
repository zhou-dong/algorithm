package com.dzhou.interview.google;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestRepeatedSubstringPattern {

	RepeatedSubstringPattern instance;

	@Before
	public void init() {
		instance = new RepeatedSubstringPattern();
	}

	@Test
	public void test() {
		Assert.assertEquals(true, instance.repeatedSubstringPattern("abab"));
	}

}
