# Example 9

The following simple code sums the value of all the nodes in a balanced binary search tree. What is its runtime?

```java
int sum(Node node) {
	if (node == null) {
		return 0;
	}
	return sum(node.left) + node.value + sum(node.right);
}
```

This runtime if this code is O(N), where N is the number of the nodes.

reference: Cracking the Coding Interview