import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        // System.out.println(stack.peek()); 

        // System.out.println(stack.pop()); 



        // System.out.println(stack.pop()); 


        // System.out.println(stack.isEmpty()); 


        // System.out.println(stack.pop()); 

        System.out.println(stack.isEmpty()); 

        
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
