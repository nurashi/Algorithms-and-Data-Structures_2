public class MyStack<T extends Comparable<T>> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    // adds an item to the top of the stack
    public void push(T item) {
        list.addFirst(item); // O(1)
    }

    // deletes the top item of the stack and returns it
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = list.getFirst(); // upper element
        list.removeFirst();       // removes upper element
        return item;
    }

    // Returns the top element of the stack without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getFirst();
    }

    // checks if the stack is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // size
    public int size() {
        return list.size();
    }
}
