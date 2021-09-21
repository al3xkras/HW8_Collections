package ua.alexkras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>(
                Arrays.asList(4,5,-6,4,5,3,4,2,4,5,7));

        System.out.println(arrayList);

        Counter counter = new Counter(arrayList);

        counter.printCounter();

        NoDeletionArrayList<Integer> list = new NoDeletionArrayList<>();

        list.add(1);
        list.addAll(Arrays.asList(2,3,4,5,6));
        list.add(-1);

        System.out.println(list);

        NoDeletionLinkedList<Integer> integers = new NoDeletionLinkedList<>(
                Arrays.asList(40,2,3,4,5,6));


        integers.addFirst(30);

        System.out.printf("size: %d first: %d last: %d\n",integers.size(),integers.getFirst(),integers.getLast());


        System.out.println(integers);

        integers.addLast(50);
        System.out.println(integers);

        System.out.printf("integers[%d] = %d\n",2,integers.get(2));
        integers.get(8); //IndexOutOfBoundsException

    }
}
