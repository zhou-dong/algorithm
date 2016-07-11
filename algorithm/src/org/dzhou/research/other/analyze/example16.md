# Example 16

The following function prints the powers of 2 from 1 through n (inclusive). For example, if n is 4, it would print 1, 2, and 4. What is its runtime?

```java
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
```

The runtime is O(log(n)).

reference: Cracking the Coding Interview
