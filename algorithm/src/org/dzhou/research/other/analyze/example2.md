# Example 2

What is the runtime of the below code?

```java
void printPairs(int[] array) {
	for (int i = 0; i < array.length; i++) {
		for (int j = 0; j < array.length; j++) {
			System.out.println(array[i] + "," + array[j]);
		}
	}
}
```

This will take O(N^2) time.

reference: Cracking the Coding Interview