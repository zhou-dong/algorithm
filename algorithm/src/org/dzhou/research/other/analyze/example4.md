# Example 4

What is the runtime of the below code?

```java
void printUnorderedPairs(int[] arrayA, int[] arrayB) {
	for (int i = 0; i < arrayA.length; i++) {
		for (int j = 0; j < arrayB.length; j++) {
			if (arrayA[i] < arrayB[j]) {
				System.out.println(arrayA[i] + "," + arrayB[j]);
			}
		}
	}
}
```

Runtime will take O(AB) time.