# Arrays and Strings

Array questions and strings questions are often interchangeable. 

## Hash table

### Info

Hash table is a very important data structure to optimize the running time of algorithms.

### Implement

There are two ways to implement hash table, which are:

- linked list with hash code
- binary search tree.

We use linked list + hash code.

## Is Unique Characters

1. Intuition we could use every character to compare with others, it is like bubble sort which running time is O(n^2) ;
2. We can sort the array first then compare each neighbors, which running time is the sort time add compare neighbors time O(nlog(n) + n), which is O(nlog(n)).
3. If the string is ASCII code, which we know totally how many characters in the set, we can create an array with the size of the ASCII code, normal is 128 and extended is 256. We can use the code of character In ASCII as the index of array like (int)'a' = 97. Which running time is O(N), but the space time is O(P), P is the size of ASCII set. 
4. Use bit operation. Which running time also O(N), but only use one int space.

## Check Permutation

