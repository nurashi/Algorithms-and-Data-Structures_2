# Algorithms-and-Data-Structures_2 Assignment


##  MyArrayList<T>

Custom implementation of a dynamic array similar to Java's ArrayList.  
Implements the `MyList<T>` interface using a plain `Object[]` array (no `java.util.ArrayList` used).

---

### Key Features

- **Dynamic resizing**: Automatically resizes when capacity is full.
- **Index-based access**: Supports random access via `get(index)` and `set(index, value)`.
- **Add/remove support**:
  - `add(item)`, `add(index, item)`
  - `addFirst(item)`, `addLast(item)`
  - `remove(index)`, `removeFirst()`, `removeLast()`
- **Search methods**:
  - `indexOf(object)`, `lastIndexOf(object)`
  - `exists(object)`
- **Sorting**:
  - `sort()` — natural ordering via `Comparable`
  - `sort(Comparator)` — custom comparator
- **Utility methods**:
  - `toArray()`, `clear()`, `size()`, `iterator()`

---

##  MyLinkedList<T>

A custom implementation of a **doubly linked list**, similar to Java’s `LinkedList`.  
Implements the `MyList<T>` interface without using `java.util.LinkedList`.

---

###  Key Features

- **Doubly linked structure**: Each node stores references to both the next and previous nodes.
- **Bidirectional access**: Efficient navigation from both the head and the tail.
- **Add and remove operations**:
  - `add(item)`, `add(index, item)`
  - `addFirst(item)`, `addLast(item)`
  - `remove(index)`, `removeFirst()`, `removeLast()`
- **Search support**:
  - `indexOf(object)`, `lastIndexOf(object)`
  - `exists(object)`
- **Element access**:
  - `get(index)`, `set(index, value)`
  - `getFirst()`, `getLast()`
- **Sorting**:
  - `sort()` — natural order using `Comparable`
  - `sort(Comparator)` — custom comparator support
- **Utility methods**:
  - `toArray()`, `clear()`, `size()`, `iterator()`

---

##  MyStack<T>

Custom implementation of a **stack** (LIFO structure) using `MyLinkedList<T>` as the underlying data structure.  
Implements standard stack operations without using `java.util.Stack` or `Deque`.

---

###  Key Features

- **Push/Pop operations**:
  - `push(item)` — adds an item to the top of the stack
  - `pop()` — removes and returns the top item
  - `peek()` — returns the top item without removing it
- **Utility methods**:
  - `isEmpty()` — checks if the stack is empty
  - `size()` — returns the number of elements

---


##  MyQueue<T>

Custom implementation of a **queue** (FIFO structure) using `MyLinkedList<T>` as the underlying data structure.  
Does not use `java.util.Queue` or other built-in collection types.

---

###  Key Features

- **Enqueue/Dequeue operations**:
  - `enterQueue(item)` — adds an item to the end of the queue
  - `deleteQueue()` — removes and returns the item from the front
  - `peek()` — returns the front item without removing it
- **Utility methods**:
  - `isEmpty()` — checks if the queue is empty
  - `size()` — returns the number of elements

---

##  MyMinHeap<T>

Custom implementation of a **min-heap** (priority queue) using `MyArrayList<T>` as the underlying data structure.  
This heap ensures that the minimum element is always at the root (index 0).

---

###  Key Features

- **Insert**:
  - `insert(item)` — adds an item to the heap and ensures heap property is maintained.
- **Extract Min**:
  - `extractMin()` — removes and returns the minimum item from the heap.
- **Peek Min**:
  - `getMin()` — returns the minimum item without removing it.
- **Utility methods**:
  - `isEmpty()` — checks if the heap is empty.
  - `size()` — returns the number of elements in the heap.

---

