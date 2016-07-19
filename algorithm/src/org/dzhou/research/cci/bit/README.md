# Bit Manipulation

### Bit Facts and Tricks

```java
x ^ 0s = x
x ^ 1s = ~x
x ^ x = 0
```

```java
x & 0s = 0
x & 1s = x
x & x = x
```

```java
x | 0s = x
x | 1s = 1s
x | x = x
```

#### Two's Complement and Negative Numbers
 
| V/I | 3 | 2 | 1 | 0 | V/I | 3 | 2 | 1 | 0 |
|:---:|:-:|:-:|:-:|:-:|:---:|:-:|:-:|:-:|:-:|
|  7  | 0 | 1 | 1 | 1 |  -1 | 1 | 1 | 1 | 1 |
|  6  | 0 | 1 | 1 | 0 |  -2 | 1 | 1 | 1 | 0 |
|  5  | 0 | 1 | 0 | 1 |  -3 | 1 | 1 | 0 | 1 |
|  4  | 0 | 1 | 0 | 0 |  -4 | 1 | 1 | 0 | 0 |
|  3  | 0 | 0 | 1 | 1 |  -5 | 1 | 0 | 1 | 1 |
|  2  | 0 | 0 | 1 | 0 |  -6 | 1 | 0 | 1 | 0 |
|  1  | 0 | 0 | 0 | 1 |  -7 | 1 | 0 | 0 | 1 |
|  0  | 0 | 0 | 0 | 0 |     |   |   |   |   |

#### Arithmetic VS. Logical Right Shift

- Arithmetic Right Shift: x >>= 1 ;
- Logical Right Shift: x >>>= 1 ;

#### Common Bit Tasks: Getting and Setting

```java
enum Bit {
	ZERO, ONE;
}
```

Get Bit

```java
public Bit getBit(int num, int i) {
	int mask = 1 << i;
	return (num & mask) == 0 ? Bit.ZERO : Bit.ONE;
}
```

Set Bit

```java
public int setBit(int num, int i) {
	int mask = 1 << i;
	return num | mask;
}
```

Clear Bit

```java
public int clearBit(int num, int i) {
	int mask = ~(1 << i);
	return num & mask;
}
```

Clear Bits

```java
public int clearBitsMSBThroughI(int num, int i) {
	int mask = (1 << i) - 1;
	return num & mask;
}

public int clearBitsIthrough0(int num, int i) {
	int mask = ~(-1 >>> (31 - i));
	return num & mask;
}
```

Update Bit
```java
public int updateBit(int num, int i, Bit bit) {
	return (bit == Bit.ZERO) ? clearBit(num, i) : setBit(num, i);
}
```

```java
public boolean isOnlyOneBitIsOne(int num) {
	return (num & (num - 1)) == 0 ? true : false;
}
```