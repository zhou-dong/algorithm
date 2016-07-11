# Big O

```java
int f(int n) {
	if (n <= 0) {
		return 1;
	}
	return f(n - 1) + f(n - 1);
}
```

Runtime Complexity: O(2^N)

The Space Complexity: O(N)

The space complexity of this algorithm will be O(N). Although we have O(2^N) nodes in the tree total, only O(N) exist at any given time. Therefore, we would only need to have O(N) memory available.

---

```java
int f(int n) {
	if (n <= 0) {
		return 1;
	}
	return f(n - 1) + f(n - 1) + f(n - 1);
}
```

Runtime Complexity: O(3^N)

The Space Complexity: O(N)

---

reference: Cracking the Coding Interview