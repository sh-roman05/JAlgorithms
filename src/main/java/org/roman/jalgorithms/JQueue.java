package org.roman.jalgorithms;

import java.util.NoSuchElementException;

public class JQueue<Value extends Comparable<Value>> {

    private int size = 0;

    private Node<Value> head = null;


    private static class Node<T> {

        private T value = null;
        private Node<T> next = null;

        public Node(T value) {
            this.value = value;
        }
    }


    //Добавление в конец
    void add(){}




    /**
     * Возвращает первый элемент списка и не удаляет его
     * @throws NoSuchElementException если список пустой
     * @return первый элемент списка
     */
    //Value peek();

    /**
     * Возвращает первый элемент из списка и удаляет его
     * @throws NoSuchElementException если список пустой
     * @return первый элемент из связного списка
     */
    //Value poll();

    /**
     * Возвращает количество элементов в очереди
     * @return количество элементов в очереди
     */
    int size() {
        return size;
    }

    /**
     * Возвращает {@code true} если в коллекции отсутствуют элементы.
     * @return {@code true} if this collection contains no elements
     */
    boolean isEmpty() {
        return head == null;
    }



    /**
     * Проверяет присутствие элемента в очереди
     * @param value элемент, который требуется найти в очереди
     * @return {@code true} если элемент присутствует в очереди
     */
    public boolean contains(Value value) {
        Node<Value> search = head;
        while (search != null) {
            if(value.equals(search.value))
                return true;
            search = search.next;
        }
        return false;
    }


    /**
     * Очищает очередь
     */
    void clear() {
        head = null;
        size = 0;
    }




}
