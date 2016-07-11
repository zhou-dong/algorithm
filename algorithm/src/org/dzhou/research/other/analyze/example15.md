# Example 15

The following code print all Fibonacci numbers from 0 to n. What is the complexity?

```java
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
```

At each call to fib(i), we have already computed and stored the values for fib(n-1) and fib(n-2). We just look up those values, sum them, store the new result, and return. This takes a constant amount of time.

We're doing a constant amount of work N times, so this is O(n) time.

reference: Cracking the Coding Interview
