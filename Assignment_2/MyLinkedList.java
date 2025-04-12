
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(T item) {
            this.item = item;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // by FAQ choice, sort was implemented, and to not use each of them, one method
    // calls other method
    @Override
    public void sort() {
        sort(Comparator.naturalOrder());
    }

    // just a helper functon to get the node at a specific index
    private Node<T> getNodeAt(int index) {
        // if index in the first half of the list, start from the head
        if (index < size / 2) {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }
        // if index is in the second half, start from the tail
        else {
            Node<T> current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current;
        }
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        // Use getNodeAt to access the node at the given index
        Node<T> current = getNodeAt(index);
        current.item = element; // Set the item to the new element
    }

    @Override
    public boolean exists(Object o) {
        Node<T> current = head;
        while (current != null) {
            if (current.item.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException("empty");
        }

        return head.item;
    }

    @Override
    public T getLast() {
        if (tail == null) {
            throw new NoSuchElementException("empty");
        }
        return tail.item;
    }

    @Override
    public void removeLast() {
        if (tail == null) {
            throw new IllegalStateException("empty");
        }

        if (tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
        } else {
            head = null;
            tail = null;
        }

        size--;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T item = currentNode.item;
                currentNode = currentNode.next;
                return item;
            }
        };
    }

    @Override
    public void removeFirst() {
        if (head == null) {
            throw new IllegalStateException("empty");
        }

        if (head.next != null) {
            head = head.next;
            head.prev = null;
        } else {
            head = null;
            tail = null;
        }

        size--;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.item;
            current = current.next;
        }
        return array;
    }

    @Override
    public void addLast(T element) {
        add(element); // add already add it at last
    }

    @Override
    public int indexOf(Object o) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.item.equals(o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // not found
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.item.equals(o)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1; // not found
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> current = getNodeAt(index);
        return current.item;
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        if (size <= 1) {
            return; // already sorted
        }

        Object[] array = toArray();
        @SuppressWarnings("unchecked")
        T[] typedArray = (T[]) array;
        java.util.Arrays.sort(typedArray, comparator);

        Node<T> current = head;
        for (T item : typedArray) {
            current.item = item;
            current = current.next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> toRemove = getNodeAt(index);

        if (toRemove.prev != null) {
            toRemove.prev.next = toRemove.next;
        } else {
            head = toRemove.next; // if it's the head
        }

        if (toRemove.next != null) {
            toRemove.next.prev = toRemove.prev;
        } else {
            tail = toRemove.prev; // if it's the tail
        }

        toRemove.next = null;
        toRemove.prev = null;
        size--;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Node<T> newNode = new Node<>(element);
            Node<T> current = getNodeAt(index);
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element); // its to create a new node
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

}