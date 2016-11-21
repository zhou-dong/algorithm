package com.dzhou.interview.google;

import org.junit.Test;

import junit.framework.Assert;

public class TestOptimalAccountBalancing {

	@Test
	public void test() {
		int[][] transactions = { { 0, 1, 1 }, { 0, 2, 1 }, { 1, 3, 1 }, { 2, 3, 1 } };
		int actual = new OptimalAccountBalancing().minTransfers(transactions);
		Assert.assertEquals(1, actual);
	}

	@Test
	public void test1() {
		int[][] transactions = { { 0, 1, 2 }, { 1, 2, 1 }, { 1, 3, 1 } };
		int actual = new OptimalAccountBalancing().minTransfers(transactions);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void test2() {
		int[][] transactions = { { 0, 1, 10 }, { 2, 0, 5 } };
		int actual = new OptimalAccountBalancing().minTransfers(transactions);
		Assert.assertEquals(2, actual);
	}

}
