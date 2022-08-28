package org.roman.jalgorithms;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class JHashMapTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    JMap<Integer, Integer> map;

    @Before
    public void JHashMapTestInit() {
        map = new JHashMap<>(2000);
    }

    @After
    public void JHashMapTestClear() {
        map.clear();
    }


    @Test
    public void JHashMapTestGeneral() {

        map = new JHashMap<>(500);

        //thrown.expect(IOException.class);
        //Кот
        //thrown = ExpectedException.none();
    }

    @Test
    public void JHashMapPutTest() {
        JHashMapPutTest(new JHashMap<>());
        JHashMapPutTest(new JBinaryTreeMap<>());
    }
    public void JHashMapPutTest(JMap<Integer, Integer> testMap) {
        Assert.assertTrue(testMap.isEmpty());

        for (int i = 0; i < 2000; i++)
            testMap.put(i, i);
        for (int i = 0; i < 2000; i++)
            testMap.put(i, i * 2);
        Assert.assertEquals(2000, testMap.size());
        Assert.assertFalse(testMap.isEmpty());

        testMap.put(1000, 1917);
        Integer test = testMap.get(1000);
        Assert.assertNotNull(test);
        Assert.assertEquals((Integer) 1917, test);
    }



    @Test
    public void JHashMapTest1() {

        //Assert.assertTrue(map.isEmpty());

        //Сгенерировать 100 элементов и перемешать
        /*List<Integer> keyList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            keyList.add(i);
        }
        Collections.shuffle(keyList);
        for(Integer key: keyList){
            map.put(key, key.toString());
        }

        System.out.print(map.size());*/
    }



}