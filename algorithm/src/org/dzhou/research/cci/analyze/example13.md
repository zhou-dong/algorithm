# Example 13

The following code computers the Nth Fibonacci number.

```java
int fib(int n) {
	if (n <= 0)
		return 0;
	else if (n == 1)
		return 1;
	return fib(n - 1) + fib(n - 2);
}
```

There are 2 branches per cell, and we go as deep as N, therefore the runtime is O(2^N).

Generally speaking, when you see an algorithm with multiple recursive calls you are looking for exponential.

reference: Cracking the Coding Interview