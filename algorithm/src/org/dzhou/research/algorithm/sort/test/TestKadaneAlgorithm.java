package org.dzhou.research.algorithm.sort.test;

import org.dzhou.research.algorithm.sort.KadaneAlgorithm;
import org.dzhou.research.algorithm.sort.KadaneAlgorithm.KadaneResult;
import org.junit.Assert;
import org.junit.Test;

public class TestKadaneAlgorithm {

	@Test
	public void test() {
		int[] array = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		KadaneResult result = KadaneAlgorithm.maxSubArray(array);
		Assert.assertEquals(result.left, 3);
		Assert.assertEquals(result.right, 6);
		Assert.assertEquals(result.max, 6);
	}

	@Test
	public void test1() {
		int[] array = { -2, -3, 4, -1, -2, 1, 5, -3 };
		KadaneResult result = KadaneAlgorithm.maxSubArray(array);
		Assert.assertEquals(result.left, 2);
		Assert.assertEquals(result.right, 6);
		Assert.assertEquals(result.max, 7);
	}

	@Test
	public void test2() {
		int[] array = { -1, 4, -2, 5, -5, 2, -20, 6 };
		KadaneResult result = KadaneAlgorithm.maxSubArray(array);
		Assert.assertEquals(result.left, 1);
		Assert.assertEquals(result.right, 3);
		Assert.assertEquals(result.max, 7);
	}

}
