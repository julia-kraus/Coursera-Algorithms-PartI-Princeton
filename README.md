# Coursera-Algorithms-PartI-Princeton

My personal solutions to Coursera's [Algorithms Part I class](https://www.coursera.org/learn/algorithms-part1), programmed in Python instead of Java in the original course.

The schedule is the following:

* Week 1: Union Find, Analysis of Algorithms
* Week 2: Stack & Queues, Elementary Sorts
* Week 3: Mergesort & Quicksort
* Week 4: Priority Queues, Elementary Symbol Tables
* Week 5: Balanced Search Trees,
* Week 6: Hash Tables, Symbol Table Applications


Below, you find my lecture notes on the different subjects:

## Week 1

### Union Find

### Analysis of Algorithms

## Week 2

### Stacks

* Stack: Examine the item most recently added (LIFO) -> push, pop
* Queue: Examine the item least recently added (FIFO) -> enqueue, dequeue

### Stack API

`class StackOfStrings`
----------------------
* `StackOfStrings()` create an empty stack`
* `push(item: str) -> None`: insert a new string onto stack
* `pop() -> str`: remove and return the string most recently added
* `is_empty() -> bool`: is the stack empty?

### LinkedList implementation
maintain pointer to first node in a linked list; insert/remove from front.

```python
class Stack:
    class Node:
        def __init__(item=None):
            self.item = item
            self.next = None
          
    def pop(self):
        # save item to return
        item = self.first.item
        self.first = self.first.next
        return item

    def push(self):
        oldfirst = self.first
        self.first = Node()
        
        
```


### Array implementation




### Resiszing Arrays

### Week1 Assignment: 
Write a generic data type for a deque and a randomized queue. The goal of this assignment is to implement elementary data structures using arrays and linked lists, and to introduce you to generics and iterators.

__Deque__: 
A double-ended queue or deque is a generalization of a stack and a queue that supports adding and removing items from either the front or the back of the data structure.

*Corner cases*:
* Throw an IllegalArgumentException if the client calls either `addFirst` or `addLast` with a null argument
* Throw an Exception if the client calls either `removeFirst` or `removeLast()` when the deque is empty
* Throw an Exception if the client calls the `next()` method in the iterator when there are no more items to return
* Throw an UnsupportedOperationException if the client calls the `remove()` method in the iterator

* Unit testing*
Write unit tests for every constructor and method.

*Performance requirements


