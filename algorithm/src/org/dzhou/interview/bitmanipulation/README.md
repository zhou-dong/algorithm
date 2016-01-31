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

| DECIMAL | POSITIVE | BINARY | DECIMAL | NEGATIVE | BINARY |
|:-------:|:--------:|:------:|:-------:|:--------:|:------:|
|    7    |     0    |   111  |    -1   |     1    |   111  |
|    6    |     0    |   110  |    -2   |     1    |   110  |
|    5    |     0    |   101  |    -3   |     1    |   101  |
|    4    |     0    |   100  |    -4   |     1    |   100  |
|    3    |     0    |   011  |    -5   |     1    |   011  |
|    2    |     0    |   010  |    -6   |     1    |   010  |
|    1    |     0    |   001  |    -7   |     1    |   001  |
|    0    |     0    |   000  |         |          |        |

先来理解下8位二进制数表示原理。先来理解下8位二进制数表示原理。从而可以延伸到32位，64位以及任意其他位数。

8位二进制正数表示范围

```
0000 0000 ~ 1111 1111
（0 ~ 255）
```

这个不难理解，那么如何表示负数呢？设计计算机的人就想，把最高位作为符号位，0表示正数，1表示负数。这样，8位二进制数表示范围就发生了变化：

```
负数：1 111 1111 ~ 1 000 0000 
    （-127 ~  -0)
正数：0 000 0000 ~ 0 111 1111
    （0 ~ 127）
```

但是如果在计算机中这样表示负数，那么相加减就很不方便。试想 -1 + 1 = 0 ，换成二进制就是：

```
  1 000 0001
+ 0 000 0001
-------------
  1 000 0010
```

计算机计算出来结果就是1 000 0010，这个结果等于-2，不是等于0，如果要保证结果正确，就需要修改计算机做加法的方式，非常不方便。于是设计计算机的人员就想到一个好方法，采用补码形式来表示有符号数。简单的说-1不是用1 000 0001来表示，而是用补码1 111 1111来表示，我们再来看下采用补码形式的 -1 + 1 的结果

```
  1 111 1111
+ 0 000 0001
----------------
 10 000 0000
```

因为是8位二进制数，所以舍弃最高位1，看下结果，非常完美，就是0

其实在上面的例子中，1 000 0001就是-1的原码，而1 111 1111就是-1的补码。这下原码和补码的定义就都有了。

那么补码怎么计算出来的呢？

```
1、正数：原码和补码一致
2、负数：原码取反，然后加1
```

例如求-1的补码：-1原码是1 000 0001，符号位保持不变，取反就是 1 111 1110 ，然后加1，就得到补码1 111 1111了。

大家会发现，-1的补码还可以这么求：1取反（包括符号位），然后加1，其实也能得到-1的补码。在程序中，求一个数的相反数，如果看到这样的写法 ~num + 1，其实就是这个原理了。我个人还是更喜欢直接用 -1 * num，这样更通俗易懂。

come from: http://www.01happy.com/computer-true-code-complement-code/

### Arithmetic vs. Logical Right Shift

移位操作符（shift operators）
   
移位操作符同样是位的操作，有以下三种：

- <<    （往左移位）
- >>    （往右移位）
- >>>   （无符号右移位）

下面对以上的三种移位操作做简单的说明
   
- “<<”将目标数向左移位，在低位补“0”。
- “>>”将目标数向右移位，此时应注意，“>>”使用符号延伸（sign extension），
	+ 若目标数是正数（positive），在高位补“0”；
	+ 若目标数是负数（negative），在高位补“1”。
- “>>>”使用“0”延伸（zero extension）,不管目标数是正数还是负数，总是在高位补“0”。
	+ 注意：无符号右移位“>>>”在C/C++中是不存在的。

```java
int repeatedArithmeticShift(int x, int count) {
	for (int i = 0; i < count; i++) {
		x >>= 1;
	}
	return x;
}

int repeatedLogicalShift(int x, int count) {
	for (int i = 0; i < count; i++) {
		x >>>= 1;
	}
	return x;
}
```

### 十进制小数→→→→→二进制小数 方法：“乘2取整”

对十进制小数乘2得到的整数部分和小数部分,整数部分既是相应的二进制数码,再用2乘小数部分(之前乘后得到新的小数部分),又得到整数和小数部分.
如此不断重复,直到小数部分为0或达到精度要求为止.第一次所得到为最高位,最后一次得到为最低位

如:0.25的二进制
```Java
0.25*2=0.5  // 取整是0
0.5*2=1.0   // 取整是1
```
即0.25的二进制为 0.01 ( 第一次所得到为最高位,最后一次得到为最低位)

0.8125的二进制
```Java
0.8125*2=1.625   // 取整是1
0.625*2=1.25     // 取整是1
0.25*2=0.5       // 取整是0
0.5*2=1.0        // 取整是1
```
即0.8125的二进制是0.1101（第一次所得到为最高位,最后一次得到为最低位）

from http://www.cnblogs.com/qdlgx/archive/2008/09/10/1288500.html