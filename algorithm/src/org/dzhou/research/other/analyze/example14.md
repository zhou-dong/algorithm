# Example 14

The following code print all Fibonacci numbers from 0 to n. What is the complexity?

```java
void allFib(int n) {
	for (int i = 0; i < n; i++) {
		System.out.println("i" + ": " + fib(i));
	}
}

int fib(int n) {
	if (n <= 0)
		return 0;
	else if (n == 1)
		return 1;
	return fib(n - 1) + fib(n - 2);
}
```

total steps:  
= 2^1 + 2^2 + 2^3 + ... + 2^n = 2^(n+1)

The runtime is: O(2^N)

reference: Cracking the Coding Interview