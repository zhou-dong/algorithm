# Example 11

The following code computers n! (n factorial). What is its time complexity?

```java
int factorial(int n) {
	if (n < 0) {
		return -1;
	} else if (n == 0) {
		return 1;
	} else {
		return n * factorial(n - 1);
	}
}
```

This runtime is O(N)

reference: Cracking the Coding Interview