# Example 3

What is the runtime of the below code?

```java
void printUnorderedPairs(int[] array) {
	for (int i = 0; i < array.length; i++) {
		for (int j = i + 1; j < array.length; j++) {
			System.out.println(array[i] + "," + array[j]);
		}
	}
}
```

The number of steps total is:

TOTAL STEPS:  
	= (N-1) + (N-2) + (N-3) + ... + 2 + 1;  
	= 1 + 2 + 3 + ... + (N-1) ;  
	= N(N-1) / 2;  

Runtime will take O(N^2) time.