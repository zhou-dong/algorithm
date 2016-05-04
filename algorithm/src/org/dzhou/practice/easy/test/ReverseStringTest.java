package org.dzhou.practice.easy.test;

import org.dzhou.practice.easy.ReverseString;
import org.junit.Assert;
import org.junit.Test;

public class ReverseStringTest {

	String input = "hello";
	String expected = "olleh";

	@Test
	public void testReverseString() {
		String answer = ReverseString.reverseString(input);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testReverseStringFromBothSide() {
		String answer = ReverseString.reverseStringFromBothSide(input);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testReverseStringByStack() {
		String answer = ReverseString.reverseStringByStack(input);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testReverseStringByRecursionFrontEnd() {
		String answer = ReverseString.reverseStringByRecursionFrontEnd(input);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testReverseStringByRecursionEndFront() {
		String answer = ReverseString.reverseStringByRecursionEndFront(input);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testReverseStringByRecursionFromHalf() {
		String answer = ReverseString.reverseStringByRecursionFromHalf(input);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testReverseStringByStringBuilder() {
		String answer = ReverseString.reverseStringByStringBuilder(input);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testReverseStringByLinkedList() {
		String answer = ReverseString.reverseStringByLinkedList(input);
		Assert.assertEquals(expected, answer);
	}

}
