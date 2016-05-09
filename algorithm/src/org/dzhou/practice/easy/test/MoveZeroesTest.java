package org.dzhou.practice.easy.test;

import org.dzhou.practice.easy.MoveZeroes;
import org.junit.Assert;
import org.junit.Test;

/**
 * For example,
 * 
 * given nums = [0, 1, 0, 3, 12], after calling your function,
 * 
 * nums should be [1, 3, 12, 0, 0].
 * 
 * @author DONG ZHOU
 *
 */
public class MoveZeroesTest {

	int[] nums = { 0, 1, 0, 3, 12 };
	int[] expecteds = { 1, 3, 12, 0, 0 };

	@Test
	public void test() {
		MoveZeroes.moveZeroes(nums);
		Assert.assertArrayEquals(expecteds, nums);
	}

}
