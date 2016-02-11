package org.dzhou.interview.math.test;

import org.dzhou.interview.math.PalindromeNumber;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPalindromeNumber {

	PalindromeNumber palindrome = null;

	@Before
	public void init() {
		palindrome = new PalindromeNumber();
	}

	@Test
	public void testTrue() {
		Assert.assertTrue(palindrome.isPalindrome(5115));
	}

	@Test
	public void testFlase() {
		Assert.assertFalse(palindrome.isPalindrome(51151));
	}

}
