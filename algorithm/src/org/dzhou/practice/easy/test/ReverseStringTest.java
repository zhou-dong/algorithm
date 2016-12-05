package org.dzhou.practice.easy.test;

import org.dzhou.practice.easy.ReverseString;
import org.junit.Assert;
import org.junit.Test;

public class ReverseStringTest {

	String input = "hello";
	String expected = "olleh";

	@Test
	public void testReverseString() {
		String answer = new ReverseString.CopyFromBackToFrontSolution().reverseString(input);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testReverseStringFromBothSide() {
		String answer = new ReverseString.TwoPointerSolution().reverseString(input);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testReverseStringByStack() {
		String answer = new ReverseString.StackSolution().reverseString(input);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testReverseStringByRecursionFrontEnd() {
		String answer = new ReverseString.RecursionFrontToEndSolution().reverseString(input);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testReverseStringByRecursionEndFront() {
		String answer = new ReverseString.RecursionEndToFrontSolution().reverseString(input);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testReverseStringByRecursionFromHalf() {
		String answer = new ReverseString.RecursionFromMiddleSolution().reverseString(input);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testReverseStringByLinkedList() {
		String answer = new ReverseString.LinkedListAsStackSolution().reverseString(input);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testReverseStringByLinkedList2() {
		String answer = new ReverseString.LinkedListSolution().reverseString(input);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testReverseStringByStringBuilder() {
		String answer = new ReverseString.StringBuilderSolution().reverseString(input);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testReverseStringByRecursionFromHalf2() {
		String answer = new ReverseString.RecursionAndSwapSolution().reverseString(input);
		Assert.assertEquals(expected, answer);
	}

}
