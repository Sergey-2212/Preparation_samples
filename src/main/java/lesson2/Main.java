package lesson2;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        Iterator iterator = list.iterator();

        System.out.println(iterator.next());


        System.out.println(935 >> 1);

        MyLinkedList<String> myList = new MyLinkedList<>();
        myList.add("123");
        myList.add("456");

        for (Object s : myList) {
            System.out.println(s);
        }

        System.out.println(Arrays.toString(myList.toArray()));

        MyArrayList<String> array = new MyArrayList<>();
        array.add("1");
        array.add("2");

        System.out.println(array.get(1));
        

    }
}
