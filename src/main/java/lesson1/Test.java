package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(new
                Integer[]{1,2,3,4,5,6}));
        Iterator it = list.iterator();
        it.hasNext();
        it.hasNext();
        it.hasNext();
        it.hasNext();
        System.out.println(it.next());
        System.out.println(it.next());
        list.remove(2);
        System.out.println(it.hasNext());
        System.out.println(it.next());

    }
}
