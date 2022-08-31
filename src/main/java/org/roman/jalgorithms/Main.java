package org.roman.jalgorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {






        //Integer[] test = { 1, -3, 6, 8, 9, -4, 4, -2, 3, -9 };
        Integer[] test = { 1, 2, 3, 4, 5, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        //Integer[] test = { 4,2,6,1,8,2 };
        JArrays.mergeSort(test);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }




        //Проверка упорядоченности массива
        /*boolean sort = true;
        for (int i = 0; i < qwe.length - 1; i++) {
            if(qwe[i] > qwe[i + 1])
                sort = false;
        }
        System.out.println("\nsort - " + sort);*/











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
        //JBinaryTreeMap<Integer, Integer> test = new JBinaryTreeMap<>();
        //JHashMap<Integer, Integer> test = new JHashMap<>();
        /*JBinaryTreeMap<Integer, Integer> test = new JBinaryTreeMap<>();


        for (int i = 0; i < 40000; i++) {
            test.put(i, i * 2);
        }
        System.out.println(test.size());

        System.out.println(test.get(333));
        test.remove(333);
        System.out.println(test.get(333));

        test.remove(5);
        test.remove(6);*/
        //test.remove(7);



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
