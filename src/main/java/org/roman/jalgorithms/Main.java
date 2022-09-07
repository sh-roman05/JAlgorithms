package org.roman.jalgorithms;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Integer[] array = { 32, 95, 95, 16, 82, 24, 66, 35, 19, 19, 75, 54, 40, 42 };
        JArrays.shellSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
