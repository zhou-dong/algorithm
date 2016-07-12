# Example 10

```java
boolean isPrime(int n) {
	for (int x = 2; x * x <= n; x++) {
		if (n % x == 0) {
			return false;
		}
	}
	return true;
}
```

This runtime is O(N^(1/2))

reference: Cracking the Coding Interview