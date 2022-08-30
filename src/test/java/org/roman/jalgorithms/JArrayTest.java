package org.roman.jalgorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class JArrayTest {

    Random random = new Random();

    @Test
    public void JMapTestGeneral() {

        /*Integer[] array1 = { };
        Integer[] array2 = { 0 };
        Integer[] array3 = { 1, 6, 2, 8, 3, 0, -1 };
        Integer[] arrayNull = { null, null, null };*/

        //JArrays.bubbleSort(array1); JArrays.bubbleSort(array2); JArrays.bubbleSort(array3);
        //JArrays.shakerSort(array1);





        //Сгенерировать случайный массив
        int maxCapacity = random.nextInt(1000);
        Integer[] randomArray = new Integer[maxCapacity];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(500);
        }

        //Отсортировать
        JArrays.quickSort(randomArray);



        //Проверить корректность сортировки
        boolean isSort = true;
        for (int i = 0; i < randomArray.length - 1; i++) {
            if(randomArray[i] > randomArray[i + 1]) {
                isSort = false;
                break;
            }
        }

        Assert.assertTrue(isSort);



    }


}
