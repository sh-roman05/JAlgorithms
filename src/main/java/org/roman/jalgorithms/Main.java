package org.roman.jalgorithms;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        JLinkedList<String> list = new JLinkedList<String>();
        list.add("qwe1");
        list.add("qwe2");
        list.add("qwe3");
        list.removeByIndex(2);
        System.out.println(list.contains("qwe3"));


    }
}
