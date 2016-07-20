package org.dzhou.research.cci.dynamicprogramming;

public class Fibonacci {

	public class Solution {
		int fibonacci(int i) {
			if (i == 0)
				return 0;
			if (i == 1)
				return 1;
			return fibonacci(i - 1) + fibonacci(i - 2);
		}
	}

	public class Solution1 {
		int fibonacci(int i) {
			return (i == 0) ? 0 : (i == 1) ? 1 : (fibonacci(i - 1) + fibonacci(i - 2));
		}
	}

	public class Solution2 {
		int fibonacci(int i) {
			switch (i) {
			case 0:
				return 0;
			case 1:
				return 1;
			default:
				return fibonacci(i - 1) + fibonacci(i - 2);
			}
		}
	}

	public class Solution3 {
		int fibonacci(int n) {
			if (n == 0 || n == 1)
				return n;
			int[] memo = new int[n + 1];
			memo[0] = 0;
			memo[1] = 1;
			return fibonacci(n, memo);
		}

		int fibonacci(int i, int[] memo) {
			if (memo[i] == 0)
				memo[i] = fibonacci(i - 1, memo) + fibonacci(i - 2, memo);
			return memo[i];
		}
	}

	public class Solution4 {
		int fibonacci(int n) {
			return fibonacci(n, new int[n + 1]);
		}

		int fibonacci(int i, int[] memo) {
			if (i == 0 || i == 1)
				return i;
			if (memo[i] == 0)
				memo[i] = fibonacci(i - 1, memo) + fibonacci(i - 2, memo);
			return memo[i];
		}
	}

	public class Solution5 {
		int fibonacci(int n) {
			if (n == 0 || n == 1)
				return n;
			int[] memo = new int[n + 1];
			memo[0] = 0;
			memo[1] = 1;
			for (int i = 2; i < n; i++) {
				memo[i] = memo[i - 2] + memo[i - 1];
			}
			return memo[n - 1] + memo[n - 2];
		}
	}

	public class Solution6 {
		int fibonacci(int n) {
			if (n == 0 || n == 1)
				return n;
			int a = 0, b = 1;
			for (int i = 2; i < n; i++) {
				int c = a + b;
				a = b;
				b = c;
			}
			return a + b;
		}
	}

}
