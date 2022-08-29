package org.roman.jalgorithms;

import org.junit.Test;

public class JArrayTest {


    @Test
    public void JMapTestGeneral() {

        Integer[] array1 = { };
        Integer[] array2 = { 0 };
        Integer[] array3 = { 1, 6, 2, 8, 3, 0, -1 };
        Integer[] arrayNull = { null, null, null };

        JArrays.bubbleSort(array1); JArrays.bubbleSort(array2); JArrays.bubbleSort(array3);
        JArrays.shakerSort(array1);

    }


}
