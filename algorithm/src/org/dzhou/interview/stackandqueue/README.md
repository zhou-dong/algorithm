# Stack and Queue

### Linked List

Linked List is same as Queue.

In Java Linked List can be used as Queue, and Linked List as all the Queue's function. Like:

- addLast
- poll
- peek

### Fixed Multiply Stack

Use one array to implement multiply stack and stack size is fixed, so it is easy to implement.

Steps:

- calculate offset for each of stacks.
- every time add element to one special stack, add the index of stack top.
- every time pop element from stack, subtract the index of stack top. 

### Multiply stack

Use one array to implement multiply stack and each stack have flexible size. In order to use space effective, connect head and tail of array, use it like a circle.

PreCalculate:

- StackInfo class
	1. start index of stack
	2. stack capacity
	3. stack size
- adjustIndex
	1. previousIndex
	2. nextIndex
- Shift stack
	+ shift one element of stack

Steps:

- Initial stacks
- when add element to specific stack
	+ If it is not full, add element to it's top and update size
	+ Else if all stacks are full, throw full stack exception
	+ Else shift other stack or stacks
	+ extend it's capacity
	+ Add element to it's top, update size  
	
### MyQueue

Use to stack to implement queue.

Two Stacks:

1. new stack
2. old stack

method:

- push: add element to newStack
- pop: pop element from oldStack
- transfer: is oldStack isEmpty, transfer all the elements from newStack to oldStack

attention: lazy method

#### Sort of Stack

