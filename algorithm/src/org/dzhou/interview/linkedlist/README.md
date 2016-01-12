# Linked List

- Singly Linked List
- Doubly Linked List

Remember recursive algorithm take at least O(n) space, where n is the depth of the recursive call. All recursive algorithm can be implemented iteratively, although they may be much more complex.

#### Use Node Implement Linked List

Two elements:

1. data in node.
2. reference of next node.

Method:

1. appendToTail
2. delete

#### Remove duplicates

1. use hash table
2. two iterators

#### kth to last

- recursive (mainly use recursive and can improve code).

#### Partition

- can improve in coding 

#### Palindrome

1. use recursive to create a reverse list, then compare.
2. use stack to store elements, then compare.
3. use recursive go the middle of the list, then compare two elements leave from the middle.

#### Intersection

1. use hash set to detect
2. If two lists intersection with each other, after the intersection node all node will be same.

#### Loop detection

In a loop, two pointer, slower with speed one, faster with speed two

1. If the go from the point, there will meet at the same point
2. If faster have k element beyond, they will meet at loopSize - k distance to start element.
3. from head to start element also k elements.
