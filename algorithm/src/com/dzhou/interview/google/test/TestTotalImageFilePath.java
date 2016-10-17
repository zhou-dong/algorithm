package com.dzhou.interview.google.test;

import org.junit.Test;

import com.dzhou.interview.google.TotalImageFilePath;

import junit.framework.Assert;

public class TestTotalImageFilePath {

	@Test
	public void test() {
		TotalImageFilePath instance = new TotalImageFilePath();
		String input = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
		Assert.assertEquals(39, instance.solution(input));
	}

}
