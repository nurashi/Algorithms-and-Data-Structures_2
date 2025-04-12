import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // System.out.println("add");
        list.add(10);
        list.add(20);
        list.add(30);
        // printList(list);

        // System.out.println("addFirst");
        // list.addFirst(5);
        // printList(list);

        // System.out.println("addLast");
        // list.addLast(40);
        // printList(list);

        // System.out.println("add(index)");
        // list.add(2, 15);
        // printList(list);

        // System.out.println("get");
        // System.out.println(list.get(2));

        // System.out.println("getFirst");
        // System.out.println(list.getFirst());

        // System.out.println("getLast");
        // System.out.println(list.getLast());

        // System.out.println("set");
        // list.set(2, 16);
        // printList(list);

        // System.out.println("remove");
        // list.remove(2);
        // printList(list);

        // System.out.println("removeFirst");
        // list.removeFirst();
        // printList(list);

        // System.out.println("removeLast");
        // list.removeLast();
        // printList(list);

        // System.out.println("indexOf");
        // System.out.println(list.indexOf(20));

        // System.out.println("lastIndexOf");
        // list.add(10);
        // printList(list);
        // System.out.println(list.lastIndexOf(10));

        // System.out.println("exists");
        // System.out.println(list.exists(30));
        // System.out.println(list.exists(99));

        // System.out.println("toArray");
        // Object[] array = list.toArray();
        // for (Object o : array) {
        //     System.out.print(o + " ");
        // }
        // System.out.println();

        // System.out.println("size");
        // System.out.println(list.size());

        // System.out.println("sort");
        // list.sort();
        // printList(list);

        // System.out.println("clear");
        // list.clear();
        // printList(list);

        System.out.println("size");
        System.out.println(list.size());
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
