package org.dzhou.research.algorithm.sort.test;

import org.dzhou.research.algorithm.sort.MaximumSumRectangularSubmatrixInMatrix;
import org.dzhou.research.algorithm.sort.MaximumSumRectangularSubmatrixInMatrix.Result;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMaximumSumRectangularSubmatrixInMatrix {

	MaximumSumRectangularSubmatrixInMatrix instance = null;
	int[][] matrix = null;

	@Before
	public void init() {
		int[] zero = { 2, 1, -3, -4, 5 };
		int[] first = { 0, 6, 3, 4, 1 };
		int[] second = { 2, -2, -1, 4, -5 };
		int[] third = { -3, 3, 1, 0, 3 };
		matrix = new int[][] { zero, first, second, third };
		instance = new MaximumSumRectangularSubmatrixInMatrix();
	}

	@Test
	public void test() {
		Result result = instance.maximumSumRectangular(matrix);
		Assert.assertEquals(18, result.sum);
		Assert.assertEquals(1, result.up);
		Assert.assertEquals(3, result.down);
		Assert.assertEquals(1, result.left);
		Assert.assertEquals(3, result.right);
	}

}
