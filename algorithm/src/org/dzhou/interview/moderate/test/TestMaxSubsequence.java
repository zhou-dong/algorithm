package org.dzhou.interview.moderate.test;

import org.dzhou.interview.moderate.MaxSubsequence;
import org.junit.Assert;
import org.junit.Test;

public class TestMaxSubsequence {

	@Test
	public void test() {
		int[] array = { 2, 3, -8, -1, 2, 4, -2, 3 };
		int result = MaxSubsequence.getMaxSum(array);
		Assert.assertEquals(7, result);
	}

}
