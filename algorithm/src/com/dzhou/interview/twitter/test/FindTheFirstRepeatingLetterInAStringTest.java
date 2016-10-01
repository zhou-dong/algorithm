package com.dzhou.interview.twitter.test;

import org.junit.Test;

import com.dzhou.interview.twitter.FindTheFirstRepeatingLetterInAString;

import junit.framework.Assert;

public class FindTheFirstRepeatingLetterInAStringTest {

	@Test
	public void test() {
		int expected = new FindTheFirstRepeatingLetterInAString().firstRepeatingLetter("abcba");
		Assert.assertEquals(expected, 0);
	}

}
