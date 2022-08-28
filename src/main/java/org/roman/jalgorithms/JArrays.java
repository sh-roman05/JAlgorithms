package org.roman.jalgorithms;

import java.util.Arrays;
import java.util.Random;

public class JArrays {



    //Сортировки
    //Сортировка слиянием
    //Пузырьковая сортировка

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



}
