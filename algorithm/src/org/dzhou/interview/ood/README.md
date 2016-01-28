# Object Oriented Design

### How to Approach

1. handle Ambiguity: 
	- six Ws: who, what, where, when, how, why
2. Define the Core Objects
3. Analyze Relationships
4. Investigate Actions
5. Design Patterns

#### Singleton

```java
public class Singleton {
	private Singleton() {}
	private static Singleton instance = null;
	public static Singleton getInstance() {
		if (instance == null)
			instance = new Singleton();
		return instance;
	}
}
```

```java
public class Singleton2 {
	private Singleton2() {}
	private static volatile Singleton2 instance = null;
	public static Singleton2 getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton2();
				}
			}
		}
		return instance;
	}
}
```

```java
public enum Singleton3 {
	INSTANCE;
}
```

```java
public enum Singleton4 {
	FIRST("first", 0), SECOND("second", 1), THIRD("third", 2);
	int value;
	String name;
	private Singleton4(String name, int value) {
		this.value = value;
		this.name = name;
		map.put(value, this);
	}
	Map<Integer, Singleton4> map = new HashMap<>();
	public Singleton4 getByValue(int value) {
		return map.get(value);
	}
	public static void printAll() {
		StringBuffer result = new StringBuffer();
		for (Singleton4 instance : Singleton4.values()) {
			result.append(instance.getName()).append(" ");
			result.append(instance.getValue());
			result.append(System.getProperty("line.separator"));
		}
		System.out.println(result.toString());
	}
	public int getValue() {
		return value;
	}
	public String getName() {
		return name;
	}
}
```
