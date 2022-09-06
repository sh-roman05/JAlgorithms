package org.roman.jalgorithms;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        JLinkedList<String> list = new JLinkedList<>();
        list.add("qwe1");
        list.add("qwe2");
        //list.add("qwe3");

        list.add(0, "ins");



        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }





    }
}
