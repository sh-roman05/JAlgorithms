package org.roman.jalgorithms;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        JStack<Integer> list = new JStack<>();

        list.push(1);
        list.push(2);
        list.push(3);

        while (!list.isEmpty())
            System.out.println(list.pop());


    }
}
