# Example 5

What is the runtime of the below code?

```java
void printUnorderedPairs(int[] arrayA, int[] arrayB) {
	for (int i = 0; i < arrayA.length; i++) {
		for (int j = 0; j < arrayB.length; j++) {
			for (int k = 0; k < 100000; k++) {
				System.out.println(arrayA[i] + "," + arrayB[j]);
			}
		}
	}
}
```

K = 100000 is constant, so the runtime will take O(AB) time.