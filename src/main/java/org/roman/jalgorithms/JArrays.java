package org.roman.jalgorithms;

import java.util.Arrays;
import java.util.Random;

public class JArrays {

    /* Сортировка пузырьком */
    public static <T extends Comparable<T>> void bubbleSort(T[] source) {
        var isSorted = false;
        while (!isSorted) {
            var done = true;
            for (int i = 0; i < source.length - 1; i++) {
                if(source[i].compareTo(source[i + 1]) > 0 ) {
                    var temp = source[i];
                    source[i] = source[i + 1];
                    source[i + 1] = temp;
                    done = false;
                }
            }
            if(done) isSorted = true;
        }
    }

    /* Сортировка перемешиванием (шейкерная сортировка) */
    public static <T extends Comparable<T>> void shakerSort(T[] source) {
        var left = 0;
        var right = source.length - 1;
        while (left < right) {
            //Едем вправо
            for (int i = left; i < right; i++) {
                if(source[i].compareTo(source[i + 1]) > 0) {
                    var temp = source[i];
                    source[i] = source[i + 1];
                    source[i + 1] = temp;
                }
            }
            right--;
            //Едем влево
            for (int i = right; i > left; i--) {
                if(source[i - 1].compareTo(source[i]) > 0) {
                    var temp = source[i];
                    source[i] = source[i - 1];
                    source[i - 1] = temp;
                }
            }
            left++;
        }
    }

    /* Сортировка вставками */
    public static <T extends Comparable<T>> void insertionSort(T[] source) {
        for (int i = 1; i < source.length; i++) {
            //Берем элемент, идем обратно и свапаем пока не дойдем до нужного места
            for (int j = i; j > 0 &&  (source[j - 1].compareTo(source[j]) > 0); j--) {
                var temp = source[j];
                source[j] = source[j - 1];
                source[j - 1] = temp;
            }
        }
    }


    /* Сортировка выбором */
    public static <T extends Comparable<T>> void selectionSort(T[] source) {
        var border = 0;
        for (int i = 0; i < source.length; i++) {
            //Находим минимальный элемент в массиве
            var indexMin = border;
            for (int j = border; j < source.length; j++) {
                if(source[j].compareTo(source[indexMin]) < 0)
                    indexMin = j;
            }
            //Вставляем в начало на границу border
            var temp = source[i];
            source[i] = source[indexMin];
            source[indexMin] = temp;
            //Уменьшаем границу неотсортированного массива
            border++;
        }
    }

    /* Быстрая сортировка */
    public static <T extends Comparable<T>> void quickSort(T[] source) {
        recursiveQuickSort(source, 0, source.length - 1);
    }

    //Выбираем опорный элемент, упорядочиваем массив, фиксируем новое место опорного элемента
    private static <T extends Comparable<T>> int getPivot(T[] source, int min, int max) {


        int pivot = (min + max) / 2;

        int left = min, right = max;

        while (left < right) {

            System.out.println(": " + left + " " + right);

            //Если элемент на месте, двигаем границу
            while (source[left].compareTo(source[pivot]) < 0) {
                left++;
            }



            while (source[right].compareTo(source[pivot]) > 0) {
                right--;
            }
            System.out.println(": " + left + " " + right);




            if(left == right) break;


            //Если мы присвоили значение, то след условие нельзя выполнять
            if(left == pivot)
                pivot = right;
            else if(right == pivot)
                pivot = left;

            swap(source, left, right);

            System.out.println("swap: " + left + " " + right);

            //break;
        }





        //Новый pivot ?


        

        return pivot;
    }

    private static <T extends Comparable<T>> void recursiveQuickSort(T[] source, int min, int max) {

        //Условие окончания работы рекурсии
        if(min >= max) return;

        //Опорный элемент
        int pivot = getPivot(source, min, max);

        //Проверка
        System.out.print("Массив (" + min + ", " + max + "): ");
        for (T t : source) {
            System.out.print(t + " ");
        }
        System.out.print("| pivot: " + pivot);

        //Алгоритм переупорядочения
        //Элементы рассматриваемого массива сравниваются с опорным элементом
        //Перетасовать массив
        //Опорный элемент сменит индекс после перестановки
        //recursiveQuickSort(source, min, pivot - 1);
        //recursiveQuickSort(source, pivot + 1, max);
    }


    private static <T extends Comparable<T>> void swap(T[] source, int index1, int index2) {
        var temp = source[index1];
        source[index1] = source[index2];
        source[index2] = temp;
    }





    /* Сортировка слиянием */
    public static <T extends Comparable<T>> void mergeSort(T[] source) {}

}
