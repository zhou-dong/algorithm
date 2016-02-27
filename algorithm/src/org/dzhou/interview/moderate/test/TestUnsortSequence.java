package org.dzhou.interview.moderate.test;

import org.dzhou.interview.moderate.FindUnsortedSequence;
import org.dzhou.interview.moderate.FindUnsortedSequence.Result;
import org.junit.Assert;
import org.junit.Test;

public class TestUnsortSequence {

	@Test
	public void test1() {
		int[] array = { 1, 4, 6, 5, 9, 10 };
		Result result = new FindUnsortedSequence().findUnsortedSequence(array);
		Assert.assertEquals(2, result.left);
		Assert.assertEquals(3, result.right);
	}

	@Test
	public void test2() {
		int[] array = { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
		Result result = new FindUnsortedSequence().findUnsortedSequence(array);
		Assert.assertEquals(3, result.left);
		Assert.assertEquals(9, result.right);
	}
}
