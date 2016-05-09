package org.dzhou.practice.easy.test;

import java.util.Arrays;

import org.dzhou.practice.easy.MoveZeroes;
import org.junit.Assert;
import org.junit.Before;
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

	int[] nums = { 4, 2, 4, 0, 0, 3, 0, 5, 1, 0 };
	int[] expecteds = { 4, 2, 4, 3, 5, 1, 0, 0, 0, 0 };

	@Before
	public void before() {
		nums = Arrays.copyOf(nums, nums.length);
	}

	@Test
	public void test() {
		MoveZeroes.moveZeroes(nums);
		Assert.assertArrayEquals(expecteds, nums);
	}

	@Test
	public void test1() {
		MoveZeroes.moveZeroes1(nums);
		Assert.assertArrayEquals(expecteds, nums);
	}

}
