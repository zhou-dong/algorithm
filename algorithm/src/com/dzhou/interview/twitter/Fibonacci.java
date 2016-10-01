package com.dzhou.interview.twitter;

/**
 * fibonacci
 * 
 * 给你一个数字n，返回一个数组，里面包含前n项 fibonacci number。
 * 
 * 比如n = 4，返回 0 1 1 2
 * 
 * @author zhoudong
 *
 */
public class Fibonacci {

	public int[] numbers(int n) {
		if (n < 0)
			return new int[0];
		if (n == 1)
			return new int[] { 0 };
		int[] memo = new int[n];
		numbers(n - 1, memo);
		return memo;
	}

	private int[] numbers(int n, int[] memo) {
		memo[0] = 0;
		memo[1] = 1;
		fibonacci(n, memo);
		return memo;
	}

	private int fibonacci(int n, int[] memo) {
		if (n == 0 || n == 1)
			return n;
		if (memo[n] != 0)
			return memo[n];
		memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
		return memo[n];
	}

}
