package com.dzhou.interview.google.test;

import org.junit.Before;
import org.junit.Test;

import com.dzhou.interview.google.UniqueSubstringsInWraparoundString;

import junit.framework.Assert;

public class TestUniqueSubstringsInWraparoundString {

	UniqueSubstringsInWraparoundString instance = null;

	@Before
	public void init() {
		instance = new UniqueSubstringsInWraparoundString();
	}

	@Test
	public void test() {
		Assert.assertEquals(1, instance.findSubstringInWraproundString("a"));
		Assert.assertEquals(2, instance.findSubstringInWraproundString("cac"));
		Assert.assertEquals(6, instance.findSubstringInWraproundString("zab"));
	}

}
