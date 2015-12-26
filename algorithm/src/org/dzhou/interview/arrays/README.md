# Arrays and Strings

Array questions and strings questions are often interchangeable. 

### Hash table

Hash table is a very important data structure to optimize the running time of algorithms.

There are two ways to implement hash table, which are:

- linked list with hash code
- binary search tree.

We use linked list + hash code.

### Is Unique Characters

1. Intuition we could use every character to compare with others, it is like bubble sort which running time is O(n^2) ;
2. We can sort the array first then compare each neighbors, which running time is the sort time add compare neighbors time O(nlog(n) + n), which is O(nlog(n)).
3. If the string is ASCII code, which we know totally how many characters in the set, we can create an array with the size of the ASCII code, normal is 128 and extended is 256. We can use the code of character In ASCII as the index of array like (int)'a' = 97. Which running time is O(n), but the space time is O(p), p is the size of ASCII set. 
4. Use bit operation. Which running time also O(n), but only use one int space.

### Check Permutation

1. We can sort each string, then test is stringOne is equals StringTwo. The running time is sort time plus compare time. O(nlog(n) + n) then O(nlog(n)).
2. We could use hash map to store character and count time, then compare to another one. The running time is O(n), but need extra space;
3. We also could use array. But remember every time we use array, we must define the array length first.

### URLify

1. use string buffer. Need extra space, but running time is O(n);
2. use array; iterator twice. First get array length; second URLify.

### Palindrome Permutation

In this algorithm, we only need count how many odd characters. If odd characters bigger than 1 return false, else return true;

1. use hash table
2. If ASCII use array
3. Use bit operation 
