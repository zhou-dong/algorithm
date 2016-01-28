# Object Oriented Design

### How to Approach

1. handle Ambiguity: 
	- six Ws: who, what, where, when, how, why
2. Define the Core Objects
3. Analyze Relationships
4. Investigate Actions
5. Design Patterns

```java
public class Singleton {

	private static Singleton instance = null;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null)
			instance = new Singleton();
		return instance;
	}

}
```


```java

```