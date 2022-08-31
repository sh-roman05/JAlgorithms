package org.roman.jalgorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class JArrayTest {

    Random random = new Random();

    @Test
    public void JArraysTestBubbleSort() {
        for (int i = 0; i < 10; i++) {
            Integer[] randomArray = generateNewArray();
            JArrays.bubbleSort(randomArray);
            Assert.assertTrue(isSorted(randomArray));
        }
    }

    @Test
    public void JArraysTestShakerSort() {
        for (int i = 0; i < 10; i++) {
            Integer[] randomArray = generateNewArray();
            JArrays.shakerSort(randomArray);
            Assert.assertTrue(isSorted(randomArray));
        }
    }

    @Test
    public void JArraysTestInsertionSort() {
        for (int i = 0; i < 10; i++) {
            Integer[] randomArray = generateNewArray();
            JArrays.insertionSort(randomArray);
            Assert.assertTrue(isSorted(randomArray));
        }
    }

    @Test
    public void JArraysTestSelectionSort() {
        for (int i = 0; i < 10; i++) {
            Integer[] randomArray = generateNewArray();
            JArrays.selectionSort(randomArray);
            Assert.assertTrue(isSorted(randomArray));
        }
    }

    @Test
    public void JArraysTestQuickSort() {
        for (int i = 0; i < 10; i++) {
            Integer[] randomArray = generateNewArray();
            JArrays.quickSort(randomArray);
            Assert.assertTrue(isSorted(randomArray));
        }
    }

    @Test
    public void JArraysTestMergeSort() {
        for (int i = 0; i < 10; i++) {
            Integer[] randomArray = generateNewArray();
            JArrays.mergeSort(randomArray);
            Assert.assertTrue(isSorted(randomArray));
        }
    }

    //Сгенерировать случайный массив
    private Integer[] generateNewArray() {
        int maxCapacity = random.nextInt(1000);
        Integer[] randomArray = new Integer[maxCapacity];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(500);
        }
        return randomArray;
    }

    //Проверить корректность сортировки
    private boolean isSorted(Integer[] source) {
        boolean isSort = true;
        for (int i = 0; i < source.length - 1; i++) {
            if(source[i] > source[i + 1]) {
                isSort = false;
                break;
            }
        }
        return isSort;
    }


}
