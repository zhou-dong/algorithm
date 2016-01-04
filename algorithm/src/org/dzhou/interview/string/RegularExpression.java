package org.dzhou.interview.string;

import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

/**
 * Practice of regular expression
 * 
 * @author DONG ZHOU
 *
 *         "+": repetition. like: "a+" match one or more 'a'
 * 
 *         "ABC": concatenation. two or more characters combine as one word;
 * 
 *         "()": like in code
 * 
 *         "*": zero or more
 * 
 *         "|": or
 * 
 *         "[]": one of
 * 
 *         "[-]": range
 * 
 *         "[^]" not any
 */
public class RegularExpression {

	@Test
	public void oneNotAny() {
		String input = "Welcome to the first module in the second course 2016 01 04.";
		testLength(input, "[^a-z0-9]", 13);
	}

	@Test
	public void oneRange() {
		String input = "Welcome to the first module in the second course 2016 01 04";
		testLength(input, "[0-9]", 8);
	}

	@Test
	public void oneOf() {
		String input = "Welcome to the first module in the second course 2016 01 04";
		testLength(input, "[012]", 6);
	}

	@Test
	public void testOr() {
		String input = "Welcome to the first module in the second course";
		testLength(input, "me|mo", 2);
	}

	@Test
	public void testZeroOrMore() {
		String input = "Welcome to the first module in the second course";
		testLength(input, "me*", 2);
	}

	@Test
	public void testConcatenation() {
		String input = "Welcome to the first module in the second course";
		testLength(input, "co", 3);
	}

	@Test
	public void testRepetition5() {
		testLength("Heeeello world", "e", 4);
	}

	@Test
	public void testRepetition4() {
		testLength("Heeeello world", "e+", 1);
	}

	@Test
	public void testRepetition3() {
		testLength("Hello      world", " +", 1);
	}

	@Test
	public void testRepetition2() {
		testLength("Hello  world", "  ", 1);
	}

	@Test
	public void testRepetition() {
		testLength("Hello  world", " ", 2);
	}

	@Test
	public void testRegex() {
		testLength("Hello world", " ", 1);
	}

	public void testLength(String input, String regex, int length) {
		List<String> result = StringUtil.findMatcher(input, regex);
		Assert.assertEquals(length, result.size());
	}

}
