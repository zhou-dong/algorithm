package org.dzhou.interview.string.test;

import org.dzhou.interview.string.StringUtil;
import org.junit.Assert;
import org.junit.Test;

public class TestString {

	@Test
	public void testIndexOf() {
		String str = "dong zhou 2016 01 04";
		Assert.assertEquals(5, StringUtil.indexOf(str, 'z'));
	}

	@Test
	public void testIndexOfTwoString() {
		String first = "dong zhou";
		String second = "zhou";
		Assert.assertEquals(5, StringUtil.indexOf(first, second));
	}

	@Test
	public void testEqual1() {
		String one = "first";
		String two = "first";
		Assert.assertTrue(one == two);
	}

	@Test
	public void testEqual2() {
		String one = "first";
		String two = one;
		Assert.assertTrue(one == two);
	}

	@Test
	public void testEqual3() {
		String one = new String("one");
		String two = one;
		Assert.assertTrue(one == two);
	}

	@Test
	public void testEqual4() {
		String one = new String("one");
		String two = "one";
		Assert.assertTrue(one != two);
	}

	@Test
	public void testEqual5() {
		String one = new String("one");
		String two = new String("one");
		Assert.assertTrue(one != two);
	}
}
