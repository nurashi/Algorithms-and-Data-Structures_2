

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        // System.out.println("Size after additions: " + list.size()); 

        // System.out.println("get " + list.get(2)); 
        // System.out.println("getfirst " + list.getFirst());
        // System.out.println("getlast " + list.getLast()); 

        // list.add(2, 25);
        // System.out.println("get after add by index " + list.get(2)); 

        // list.remove(2);
        // System.out.println("get after remove " + list.get(2)); 

        // list.removeFirst();
        // list.removeLast();
        // System.out.println("size after removeFirst, removelats" + list.size()); 

        // list.sort();
        // for (int num : list) {
        //     System.out.print(num + " "); 
        // }
        // System.out.println();

        // list.add(15);
        // list.add(10);
        // list.sort((a, b) -> b - a); // it means sort in desc order
        // for (int num : list) {
        //     System.out.print(num + " ");
        // }
        // System.out.println();

        // System.out.println("indexof " + list.indexOf(30)); 

        // System.out.println("Last index of 30: " + list.lastIndexOf(30)); 

        // System.out.println("existance " + list.exists(30)); 

        Object[] array = list.toArray();
        for (Object obj : array) {
            System.out.print(obj + " "); 
        }
        System.out.println();

        list.clear();
        System.out.println("Size after clearing: " + list.size()); 

    }


}