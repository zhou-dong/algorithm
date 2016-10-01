package com.dzhou.interview.twitter.test;

import org.junit.Test;

import com.dzhou.interview.twitter.GameOfThrones.Bit_Solution;
import com.dzhou.interview.twitter.GameOfThrones.HashTable_Solution;

import junit.framework.Assert;

public class GameOfThronesTest {

	@Test
	public void bit_Solution() {
		Assert.assertEquals(new Bit_Solution().isPalindrome("aaabbbb"), true);
		Assert.assertEquals(new Bit_Solution().isPalindrome("cdcdcdcdeeeef"), true);
		Assert.assertEquals(new Bit_Solution().isPalindrome("cdefghmnopqrstuvw"), false);
	}

	@Test
	public void hashTable_Solution() {
		Assert.assertEquals(new HashTable_Solution().isPalindrome("aaabbbb"), true);
		Assert.assertEquals(new HashTable_Solution().isPalindrome("cdcdcdcdeeeef"), true);
		Assert.assertEquals(new HashTable_Solution().isPalindrome("cdefghmnopqrstuvw"), false);
	}

}
