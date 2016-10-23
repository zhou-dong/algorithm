package com.dzhou.interview.google.test;

import org.junit.Before;
import org.junit.Test;

import com.dzhou.interview.google.CountcharactersArrangedInAlphabeticalOrder;

import junit.framework.Assert;

public class TestCountcharactersArrangedInAlphabeticalOrder {

	CountcharactersArrangedInAlphabeticalOrder instance;

	@Before
	public void init() {
		instance = new CountcharactersArrangedInAlphabeticalOrder();
	}

	@Test
	public void test() {
		test("ransom", 1);
		test("google", 3);
		test("knotty", 6);
	}

	private void test(String str, int expected) {
		Assert.assertEquals(expected, instance.solution(str));
	}

}
