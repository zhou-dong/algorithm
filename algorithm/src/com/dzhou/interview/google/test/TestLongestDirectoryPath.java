package com.dzhou.interview.google.test;

import org.junit.Test;

import com.dzhou.interview.google.LongestDirectoryPath;

import junit.framework.Assert;

public class TestLongestDirectoryPath {

	@Test
	public void test() {
		LongestDirectoryPath instance = new LongestDirectoryPath();
		String input = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
		Assert.assertEquals("/dir1/dir12/", instance.solution(input));
	}

}
