# 算法总结

## Basic Algorithm

Search

Tree

Bit Opeartion

Grapph

Sort

array

string

## Machine Learning

REGRESSION

SVM

NEURAL NETWORK

DECISION TREE

BOOST

How would you find the kth smallest element in an array of integers?

1. Ask quesion
    - Is it an pre-ordered array
    - Is there dupilcate number
2. Solution:
    1. Selection sort (Find first or second)
        + base case: O(n)
        + worst case O(n^2)
    2. Use sort algorithm to sort it first 
        + O(log(n))
    3. Use Heap 
        + Create K-size max-heap
        + O(log(k))
        + can use PriorityQueue use heap in java
    4. Use kind of half of quick sort
        + Use Quick Sort algorithm to create new algorithm
        + expected O(n) time
