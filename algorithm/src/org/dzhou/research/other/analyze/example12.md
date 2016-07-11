# Example 12

The following code computers n! (n factorial). What is its time complexity?

```java
void permutation(String str, String prefix) {
	if (str.length() == 0) {
		System.out.println(prefix);
	} else {
		for (int i = 0; i < str.length(); i++) {
			String rem = str.substring(0, i) + str.substring(i + 1);
			permutation(rem, prefix + str.charAt(i));
		}
	}
}
```

This runtime is O(N!)

注意：时间复杂度是O(N!)，而不是O(N^2)。

reference: Cracking the Coding Interview