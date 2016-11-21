package com.dzhou.interview.google.test;

import org.junit.Test;

import com.dzhou.interview.google.IslandPerimeter;

import junit.framework.Assert;

public class TestIslandPerimeter {

	@Test
	public void test() {
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		int count = new IslandPerimeter().islandPerimeter(grid);
		Assert.assertEquals(16, count);
	}

}
