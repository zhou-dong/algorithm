package org.dzhou.interview.bitmanipulation.test;

import org.junit.Assert;
import org.junit.Test;

public class Practice {

	public static void main(String[] args) {
		print((1 << 2) - 1);
		print(3 << 1);
		print(Integer.BYTES);
		print(Integer.toBinaryString(29));
		print(Integer.toBinaryString(4));
		print(Integer.toBinaryString(5));
	}

	public static void print(String num) {
		System.out.println(num);
	}

	public static void print(int num) {
		System.out.println(num);
	}

	@Test
	public void testLeftShift() {
		Assert.assertEquals(3, (1 << 2) - 1);
		Assert.assertEquals(6, (3 << 1));
	}

}
