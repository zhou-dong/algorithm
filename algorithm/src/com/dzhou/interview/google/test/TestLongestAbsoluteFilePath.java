package com.dzhou.interview.google.test;

import org.junit.Test;

import com.dzhou.interview.google.LongestAbsoluteFilePath;

import junit.framework.Assert;

public class TestLongestAbsoluteFilePath {

	@Test
	public void test() {
		String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		Assert.assertEquals(20, new LongestAbsoluteFilePath().lengthLongestPath(input));
	}

}
