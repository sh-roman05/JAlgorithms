package org.roman.jalgorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        //JRandBinaryTreeMap<Integer, Integer> test = new JRandBinaryTreeMap<>(); //удаление
        //JBinaryTreeMap<Integer, Integer> test = new JBinaryTreeMap<>();
        //JHashMap<Integer, Integer> test = new JHashMap<>();
        JBinaryTreeMap<Integer, Integer> test = new JBinaryTreeMap<>();

        for (int i = 0; i < 4000; i++) {
            test.put(i, i * 2);
        }

        System.out.println(test.containsValue(2000));







    }
}
