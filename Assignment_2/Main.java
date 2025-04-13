import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.enterQueue(10);
        queue.enterQueue(20);
        queue.enterQueue(30);
        queue.enterQueue(40);
        // printQueue(queue);

        // System.out.println(queue.peek());

        // System.out.println(queue.deleteQueue());
        // printQueue(queue);

        // System.out.println(queue.size());

        System.out.println(queue.isEmpty());
    }



    // helper to print queue
    public static void printQueue(MyQueue<Integer> queue) {
        MyQueue<Integer> temp = new MyQueue<>();

        while (!queue.isEmpty()) {
            int val = queue.deleteQueue(); 
            System.out.print(val + " ");
            temp.enterQueue(val); 
        }

        System.out.println();

        while (!temp.isEmpty()) {
            queue.enterQueue(temp.deleteQueue()); 
        }
    }
        
        



    // helper to print linkedlist
    public static void printList(MyLinkedList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
