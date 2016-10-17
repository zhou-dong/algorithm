package com.dzhou.interview.google.test;

import org.junit.Test;

import com.dzhou.interview.google.EquilibriumIndexOfAnArray;

import junit.framework.Assert;

public class TestEquilibriumIndexOfAnArray {

	@Test
	public void test() {
		int[] array = { -7, 1, 5, 2, -4, 3, 0 };
		EquilibriumIndexOfAnArray instance = new EquilibriumIndexOfAnArray();
		Assert.assertEquals(3, instance.equilibrium(array));
	}

}
