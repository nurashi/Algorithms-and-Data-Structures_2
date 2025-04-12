import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private static final int BASIC_COP = 10;
    private Object[] elements; 
    private int size; 
    
    
    public MyArrayList() {
        this.elements = new Object[BASIC_COP]; // the array with a default size
        this.size = 0; // defualt the size to 0
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than 0.");
        }
        this.elements = new Object[initialCapacity]; // Initialize the array with the specified size
        this.size = 0; // Initialize the size to 0
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (T) elements[currentIndex++]; // returning the current element and incrementing the index
            }
        };
    } // this method comes from Iterable<T> interface, and it returns an iterator for the list


    // this method added to resize the array when it's full, and will be needed in the other methods
    private void resizeArray() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
    

    @Override
    public void add(T item) {
        if (size == elements.length) {
            resizeArray(); // calls resize
        }
        elements[size++] = item; // incremetns and adds
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index out of range");
        }
        elements[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    
        if (size == elements.length) {
            resizeArray(); // calls resize by condition
        }
    
        // O(N) to shift elements to the right
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
    
        elements[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item); // juts calling add which for 0-s index, because its first element
    }

    @Override
    public void addLast(T item) {
        add(item); // add already adds to the end of arr
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
        }
        return (T) elements[index]; // to does it security useing casting
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new IllegalStateException("empty");
        }
        return get(0); // just return first elemnt
    }

    @Override
    public T getLast() {
        if (size == 0) {
            throw new IllegalStateException("empty");
        }
        return get(size - 1);  // returns last element
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    
        // shift elements to the left O(N)
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
    
        elements[size - 1] = null; // remove last duplicate
        size--;
    }

    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("empty");
        }
        remove(0); // remove first element
    }

    @Override
    public void removeLast() {
        if (size == 0) {
            throw new IllegalStateException("empty");
        }
        elements[--size] = null; // remove last duplicate
    }



    // this method was hard to implement, so I used the Arrays.sort() method to sort the array
    @Override
    public void sort() {
        if (size == 0) {
            return; // if empty sort is not needed
        }
        Object[] toSort = new Object[size];
        System.arraycopy(elements, 0, toSort, 0, size);
        Arrays.sort(toSort); // useing natural ordering (Comparable)
        System.arraycopy(toSort, 0, elements, 0, size);
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        if (size == 0) {
            return; // No need to sort an empty list
        }
        Object[] toSort = new Object[size];
        System.arraycopy(elements, 0, toSort, 0, size);
        Arrays.sort(toSort, (Comparator) comparator); // Sort using the provided comparator
        System.arraycopy(toSort, 0, elements, 0, size);
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1; // return -1 if not found
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1; // same as in prev function, retur -1 if nothing in loop happend
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        System.arraycopy(elements, 0, array, 0, size);
        return array;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    } // also we can initialie the array as new array. 

    @Override
    public int size() {
        return size; // just size, which depending on functons changes
    }
}
