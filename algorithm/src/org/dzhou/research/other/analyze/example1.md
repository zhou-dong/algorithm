# Example 1

What is the runtime of the below code?

```java
void printPairs(int[] array) {
	int sum = 0;
	int product = 1;
	for (int i = 0; i < array.length; i++) {
		sum += array[i];
	}
	for (int i = 0; i < array.length; i++) {
		product *= array[i];
	}
	System.out.println(sum + ", " + product);
}
```

This will take O(N) time.