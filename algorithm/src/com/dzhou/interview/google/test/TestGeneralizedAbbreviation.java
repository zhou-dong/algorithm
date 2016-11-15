package com.dzhou.interview.google.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.dzhou.interview.google.GeneralizedAbbreviation;

import junit.framework.Assert;

public class TestGeneralizedAbbreviation {

	GeneralizedAbbreviation instance;

	@Before
	public void init() {
		instance = new GeneralizedAbbreviation();
	}

	@Test
	public void test() {
		List<String> result = instance.generateAbbreviations("word");
		System.out.println(result);
		Assert.assertEquals(16, result.size());
	}

}
