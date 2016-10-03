# 刷题、面试（总结）

## 刷题

第一次刷完LeetCode：{'solved': 373, 'date': '09/01/2016'}

## 关于面试：

越好的公司越要放到最后面试。因为你每面试一次，尤其是On-Site，基本上会都有新的感悟，都会发现自己之前准备上的不足，而这个过程本身就是一种提高，所以说基本上是越面越强的。

 “When you see string problem that is about subsequence or matching, dynamic programming method should come to your mind naturally. ”
 
---

看到非常好的感言，来自：http://www.jianshu.com/p/3b7887f6a3c9

1. 碰到不会的题目，先好好想想，应该用什么数据结构，用最暴力的解法，该怎么做。
2. 然后把 brute force的解法说出来。讨论这个解法，为什么复杂度这么高。他这么慢，肯定有原因的。找出这个原因。
3. 然后，优化他。 dp, hashmap, 等等。
- 数据结构就是我的刀剑，我要用好他们。

Hacker Rank input

```java
Scanner myScan = new Scanner(System.in);
String inputString = myScan.nextLine();
		
String ans;
System.out.println(ans);
myScan.close();
```

```java
Scanner sc = new Scanner(System.in);
int[] nums = new int[sc.nextInt()];
for (int i = 0; i < nums.length; i++) {
	nums[i] = sc.nextInt();
}
for (int num : nums) {
	System.out.println(num);
}
sc.close();
```

reference:

https://www.quora.com/How-should-I-prepare-for-my-Google-interview-if-I-have-1-month-left

http://www.hiredintech.com/learn-algorithms

http://www.gainlo.co/#!/

http://www.jianshu.com/p/3b7887f6a3c9