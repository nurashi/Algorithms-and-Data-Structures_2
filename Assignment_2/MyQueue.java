public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> list = new MyLinkedList<>();



    // adding element to end of the queue
    public void enterQueue(T item) {
        list.addLast(item);
    }


    // removing element from the beginning of the queue and returning it
    public T deleteQueue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    // retiruns the first element
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }

    // checks if the queue is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // size of queue
    public int size() {
        return list.size();
    }
}
