package org.roman.jalgorithms;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        //
        //ArrayList<Integer> q;
        //q.get();



        JLinkedList<Integer> list = new JLinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list.size());

        //list.remove(0);
        //list.remove(9);

        System.out.println(list.size());
        for (int i = 0; i < 10; i++) {
            System.out.println(list.contains(i));
        }

        System.out.println(list.get(9));




    }
}
