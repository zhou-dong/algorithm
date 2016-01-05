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

use additional stack to sort one stack

```Java
public static Stack<Integer> sort(Stack<Integer> stack) {
	Stack<Integer> result = new Stack<>();
	while (!stack.isEmpty()) {
		Integer tmp = stack.pop();
		while (!result.isEmpty() && result.peek() < tmp) {
			stack.push(result.pop());
		}
		result.push(tmp);
	}
	return result;
}
```

#### Stack With minimum

every time pop from stack get the minimum element of this stack, two type:

1. use another stack to store the minimum element of stack in current stage
2. every element of stack hold the minimum element of itself.

### Set of stacks

add stacks into a list

- if one stack is full, add one more stack
- if one stack is empty, remove it from list

#### Animal Queue

Just normal implementation, use two queue to implement two types of animal which are dog and cat.

In this implementation, can practice how to use linked list as a queue. And practice design pattern.
