package org.roman.jalgorithms;

import java.util.Arrays;
import java.util.Random;

public class JArrays {

    //Примитивные типы
    //char, boolean, float, double, byte, short, int, long, Object


    //quickSort




    /**
     * Sorts the specified array into ascending numerical order.
     *
     *
     * @param source the array to be sorted
     */
    public static void mergeSort(int[] source) {
        //Массив рекурсивно разбивается пополам, пока не будет равным единице
        if(source.length <= 1) return;
        int center = source.length / 2;
        int[] leftArray = Arrays.copyOfRange(source, 0, center);
        int[] rightArray = Arrays.copyOfRange(source, center, source.length);
        mergeSort(leftArray);
        mergeSort(rightArray);
        //Слияние двух отсортированных массивов
        merge(source, leftArray, rightArray);
    }
    private static void merge(int[] source, int[] left, int[] right) {
        //У каждого подмассива должен быть счетчик
        int countLeft = 0, countRight = 0, countSource = 0;
        //Повторяем пока не заполним новый массив
        while (countSource < source.length) {
            //Прицепляем остаток
            if(countLeft == left.length) {
                for (int i = countRight; i < right.length; i++) {
                    source[countSource] = right[countRight];
                    countSource++;
                    countRight++;
                }
                break;
            }
            else if(countRight == right.length) {
                for (int i = countLeft; i < left.length; i++) {
                    source[countSource] = left[countLeft];
                    countSource++;
                    countLeft++;
                }
                break;
            }
            //берём меньший из двух первых элементов подмассивов
            if(left[countLeft] > right[countRight]) {
                //Сохраняем правый элемент
                source[countSource] = right[countRight];
                countSource++;
                countRight++;
            }
            else {
                //Сохраняем левый элемент
                source[countSource] = left[countLeft];
                countSource++;
                countLeft++;
            }
        }
    }

    public static void bubbleSort(int[] source)
    {
        boolean isSorted = false;
        while (!isSorted)
        {
            boolean isDone = true;
            for (int i = 0; i < source.length - 1; i++) {
                if(source[i] > source[i + 1])
                {
                    int swap = source[i];
                    source[i] = source[i + 1];
                    source[i + 1] = swap;
                    isDone = false;
                }
            }
            if(isDone) isSorted = true;
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] source)
    {
        boolean isSorted = false;
        while (!isSorted)
        {
            boolean isDone = true;
            for (int i = 0; i < source.length - 1; i++)
            {
                if(source[i].compareTo(source[i + 1]) > 0)
                {
                    T swap = source[i];
                    source[i] = source[i + 1];
                    source[i + 1] = swap;
                    isDone = false;
                }
            }
            if(isDone) isSorted = true;
        }
    }









    /* Тасование Фишера-Йетса */

    public static void shuffle(char[] array){
        int maxIndex = array.length - 1;
        Random random = new Random();
        for (int i = maxIndex; i > 0; i--) {
            int rnd = random.nextInt(maxIndex);
            char temp = array[rnd];
            array[rnd] = array[i];
            array[i] = temp;
        }
    }

    public static void shuffle(boolean[] array){
        int maxIndex = array.length - 1;
        Random random = new Random();
        for (int i = maxIndex; i > 0; i--) {
            int rnd = random.nextInt(maxIndex);
            boolean temp = array[rnd];
            array[rnd] = array[i];
            array[i] = temp;
        }
    }
    public static void shuffle(float[] array){
        int maxIndex = array.length - 1;
        Random random = new Random();
        for (int i = maxIndex; i > 0; i--) {
            int rnd = random.nextInt(maxIndex);
            float temp = array[rnd];
            array[rnd] = array[i];
            array[i] = temp;
        }
    }
    public static void shuffle(double[] array){
        int maxIndex = array.length - 1;
        Random random = new Random();
        for (int i = maxIndex; i > 0; i--) {
            int rnd = random.nextInt(maxIndex);
            double temp = array[rnd];
            array[rnd] = array[i];
            array[i] = temp;
        }
    }
    public static void shuffle(byte[] array){
        int maxIndex = array.length - 1;
        Random random = new Random();
        for (int i = maxIndex; i > 0; i--) {
            int rnd = random.nextInt(maxIndex);
            byte temp = array[rnd];
            array[rnd] = array[i];
            array[i] = temp;
        }
    }
    public static void shuffle(short[] array){
        int maxIndex = array.length - 1;
        Random random = new Random();
        for (int i = maxIndex; i > 0; i--) {
            int rnd = random.nextInt(maxIndex);
            short temp = array[rnd];
            array[rnd] = array[i];
            array[i] = temp;
        }
    }
    public static void shuffle(int[] array){
        int maxIndex = array.length - 1;
        Random random = new Random();
        for (int i = maxIndex; i > 0; i--) {
            int rnd = random.nextInt(maxIndex);
            int temp = array[rnd];
            array[rnd] = array[i];
            array[i] = temp;
        }
    }
    public static void shuffle(long[] array){
        int maxIndex = array.length - 1;
        Random random = new Random();
        for (int i = maxIndex; i > 0; i--) {
            int rnd = random.nextInt(maxIndex);
            long temp = array[rnd];
            array[rnd] = array[i];
            array[i] = temp;
        }
    }
    public static void shuffle(Object[] array){
        int maxIndex = array.length - 1;
        Random random = new Random();
        for (int i = maxIndex; i > 0; i--) {
            int rnd = random.nextInt(maxIndex);
            Object temp = array[rnd];
            array[rnd] = array[i];
            array[i] = temp;
        }
    }


}
