package org.roman.jalgorithms;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class JLinkedList<Value> {

    Node<Value> head = null;
    Node<Value> tail = null;


    int size = 0;


    private static class Node<T> {
        private T value;
        private Node<T> next;
    }






    //Добавить в конец
    public void add(Value value) {
        //

        Node<Value> temp = new Node<>();
        temp.value = value;

        if(head == null) {
            head = temp;
            return;
        }



        //

        size++;
    }


}
