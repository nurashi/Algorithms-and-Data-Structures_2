public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap = new MyArrayList<>();

    // adding element to the heap
    public void insert(T item) {
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }

    // removing and returning the minimum element
    public T extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = heap.get(0);
        T lastItem = heap.get(heap.size() - 1);
        heap.set(0, lastItem);
        heap.removeLast();
        heapifyDown(0);
        return min;
    }

    // getting the minimum element without removing it
    public T getMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    // checking if the heap is empty
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    // size of the heap
    public int size() {
        return heap.size();
    }

    // checking if the heap contains an element
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }


    // heapifying down the element to maintain the heap property
    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else break;
        }
    }

    // swapping two elements in the heap
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
