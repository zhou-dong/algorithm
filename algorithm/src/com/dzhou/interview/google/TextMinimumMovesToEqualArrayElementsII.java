package com.dzhou.interview.google;

import org.junit.Test;

import junit.framework.Assert;

public class TextMinimumMovesToEqualArrayElementsII {

	@Test
	public void test() {
		int actual = new MinimumMovesToEqualArrayElementsII().minMoves2(new int[] { 1, 2, 3 });
		Assert.assertEquals(2, actual);
	}

}
