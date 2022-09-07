package org.roman.jalgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class JArrays {

    /**
     * Сортировка пузырьком
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] source) {
        if(source == null) return;
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

    /**
     * Сортировка перемешиванием (шейкерная сортировка)
     */
    public static <T extends Comparable<T>> void shakerSort(T[] source) {
        if(source == null) return;
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

    /**
     * Сортировка вставками
     */
    public static <T extends Comparable<T>> void insertionSort(T[] source) {
        if(source == null) return;
        for (int i = 1; i < source.length; i++) {
            //Берем элемент, идем обратно и свапаем пока не дойдем до нужного места
            for (int j = i; j > 0 &&  (source[j - 1].compareTo(source[j]) > 0); j--) {
                var temp = source[j];
                source[j] = source[j - 1];
                source[j - 1] = temp;
            }
        }
    }

    /**
     * Сортировка выбором
     */
    public static <T extends Comparable<T>> void selectionSort(T[] source) {
        if(source == null) return;
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

    /**
     * Быстрая сортировка
     */
    public static <T extends Comparable<T>> void quickSort(T[] source) {
        //assert source != null;
        recursiveQuickSort(source, 0, source.length - 1);
    }

    private static <T extends Comparable<T>> void recursiveQuickSort(T[] source, int min, int max) {
        if (min >= max) return;
        //Опорный элемент (берем по центру)
        int pivotIndex = (min + max) / 2;
        //Границы в массиве
        var left = min;
        var right = max;
        while (left < right) {
            //Если элемент слева меньше или равный опорному, то он на месте. Значит пропускаем его.
            while (source[left].compareTo(source[pivotIndex]) <= 0
                    && left < pivotIndex)
                left++;
            while (source[right].compareTo(source[pivotIndex]) >= 0
                    && right > pivotIndex)
                right--;
            if(left < right) {
                swap(source, left, right);
                //Если по свап попал опорный элемент, то у него новый индекс
                if(left == pivotIndex)
                    pivotIndex = right;
                else if(right == pivotIndex)
                    pivotIndex = left;
            }
        }
        recursiveQuickSort(source, min, pivotIndex);
        recursiveQuickSort(source, pivotIndex + 1, max);
    }

    private static <T extends Comparable<T>> void swap(T[] source, int index1, int index2) {
        var temp = source[index1];
        source[index1] = source[index2];
        source[index2] = temp;
    }

    /**
     * Сортировка слиянием
     */
    public static <T extends Comparable<T>> void mergeSort(T[] source) {
        if(source.length < 2) return;
        int center = source.length / 2;
        T[] leftArray = Arrays.copyOfRange(source, 0, center);
        T[] rightArray = Arrays.copyOfRange(source, center, source.length);
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(source, leftArray, rightArray);
    }

    private static <T extends Comparable<T>> void merge(T[] source, T[] leftArray, T[] rightArray) {
        int index = 0, left = 0, right = 0;
        //Сливаем 2 отсортированных массива в один
        while (left < leftArray.length && right < rightArray.length) {
            if(leftArray[left].compareTo(rightArray[right]) < 0)
                source[index++] = leftArray[left++];
            else
                source[index++] = rightArray[right++];
        }
        //Остался хвост у одного из массивов
        while (left < leftArray.length)
            source[index++] = leftArray[left++];
        while (right < rightArray.length)
            source[index++] = rightArray[right++];
    }


    /**
     * Сортировка Шелла
     */
    public static <T extends Comparable<T>> void shellSort(T[] source) {
        //Вычисление первичного шага. Оригинальный способ
        int step = (source.length) / 2;
        //Пока шаг еще больше 0. Идем этим шагом назад и меняем элементы.
        while (step > 0) {
            for (int i = step; i < source.length; i++) {
                //Делаем шаг назад
                int stepBack = i - step;
                int stepCurrent = i;
                while(stepBack >= 0 && source[stepBack].compareTo(source[stepCurrent]) > 0)
                {
                    var temp = source[stepCurrent];
                    source[stepCurrent] = source[stepBack];
                    source[stepBack] = temp;
                    //Раз обмен состоялся, то идем назад и делаем еще один обмен
                    stepCurrent = stepBack;
                    stepBack -= step;
                }
            }
            step /= 2;
        }
    }









}
