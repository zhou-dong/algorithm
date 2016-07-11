package org.dzhou.research.other.analyze;

public class Other {

	int powersOf2(int n) {
		if (n < 1) {
			return 0;
		} else if (n == 1) {
			System.out.println(1);
			return 1;
		} else {
			int prev = powersOf2(n / 2);
			int curr = prev * 2;
			System.out.println(curr);
			return curr;
		}
	}

	class Node {
		int value;
		Node left;
		Node right;
	}

	void permutation(String str) {
		permutation(str, "");
	}

	void permutation(String str, String prefix) {
		if (str.length() == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				String rem = str.substring(0, i) + str.substring(i + 1);
				permutation(rem, prefix + str.charAt(i));
			}
		}
	}

	void allFib(int n) {
		int[] memo = new int[n + 1];
		for (int i = 0; i < n; i++) {
			System.out.println("i" + ": " + fib(i, memo));
		}
	}

	int fib(int n, int[] memo) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (memo[n] > 0)
			return memo[n];
		memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
		return memo[n];
	}

	int factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static void main(String[] args) {
		Other instance = new Other();
		System.out.println(instance.factorial(4));
		instance.permutation("Dong");
	}

}
