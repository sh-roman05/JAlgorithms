package org.roman.jalgorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /*JMap<Integer, String> map = new JHashMap<>();
        map.put(5, "test5");
        map.put(4, "test4");
        map.put(3, "test3");
        map.put(9, "test9");
        map.put(7, "test7");
        map.put(1, "test1");
        map.put(10, "test10");
        map.put(-3, "test-3");

        FileOutputStream fileOutputStream = new FileOutputStream("save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(map);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        @SuppressWarnings("unchecked")
        JHashMap<Integer, String> map = (JHashMap<Integer, String>) objectInputStream.readObject();
        System.out.println(map.size());
        objectInputStream.close();*/



        //Общий тест


        //Create
        //JRandBinaryTreeMap<Integer, Integer> test = new JRandBinaryTreeMap<>(); //удаление
        JBinaryTreeMap<Integer, Integer> test = new JBinaryTreeMap<>();
        //JHashMap<Integer, Integer> test = new JHashMap<>();
        //JAVLTree<Integer, Integer> test = new JAVLTree<>();


        test.put(100, null);
        System.out.println(test.containsKey(100));





        /*test.remove(5000);
        test.remove(1000);
        for (int i = 0; i < 40000; i++) {
            test.put(i, i * 2);
        }
        long time = System.nanoTime();

        System.out.println(test.get(10000));
        System.out.println(test.get(5000));
        System.out.println(test.get(1000));
        System.out.println(test.get(100));
        System.out.println(test.containsKey(1000));
        System.out.println(test.containsValue(2000));

        test.isEmpty();
        test.size();
        test.clear();

        System.out.println("Время " + (System.nanoTime() - time));*/


    }




}
