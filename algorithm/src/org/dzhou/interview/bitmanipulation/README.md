# Bit Manipulation

### Bit Manipulation By Hand

- ^ XOR
- ~ NOT

```java
0110 + 0010 = 1000, 0011 * 0101 = 1111, 0110 + 0110 = 1100

0011 + 0010 = 0101, 0011 * 0011 = 1001, 0100 * 0011 = 1100

0110 - 0011 = 0011, 1101 >> 2 = 0011, 1101 ^ (~1101) = 1111

1000 - 0110 = 0010, 1101 ^ 0101 = 1000, 1011 & (~0 << 2 ) = 1000
```

### Bit Facts and Tricks

- 1s: a sequence of 1s
- 0s: a sequence of 0s

```java
x ^ 0s = x, x & 0s = 0, x | 0s = x

x ^ 1s = ~x, x & 1s = x, x | 1s = 1s

x ^ x = 0, x & x = x, x | x = x
```

### Two Complement and Negative Numbers

