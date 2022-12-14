package org.roman.jalgorithms;

import java.util.NoSuchElementException;

public class JStack<Value extends Comparable<Value>> {

    private int size = 0;
    Node<Value> head = null;

    private static class Node<T> {
        private T value = null;
        private Node<T> next = null;

        public Node(T value) {
            this.value = value;
        }
    }


    /**
     * Добавляет элемент в стек
     * @param object элемент для добавления
     */
    public void push(Value object) {
        Node<Value> temp = new Node<>(object);
        if(head == null){
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }
        ++size;
    }

    /**
     * Возвращает первый элемент из стека и удаляет его
     * @throws NoSuchElementException если стек пустой
     * @return первый элемент из стека
     */
    Value pop() {
        if (head == null)
            throw new NoSuchElementException();
        else {
            Value temp = head.value;
            head = head.next;
            --size;
            return temp;
        }
    }

    /**
     * Возвращает первый элемент стека и не удаляет его
     * @throws NoSuchElementException если стек пустой
     * @return первый элемент списка
     */
    Value peek() {
        if (head == null)
            throw new NoSuchElementException();
        else
            return head.value;
    }

    /**
     * Возвращает количество элементов в стеке
     * @return количество элементов в стеке
     */
    int size() {
        return size;
    }

    /**
     * Проверяет, пустой ли стек
     * @return {@code true} если в стеке отсутствуют элементы
     */
    boolean isEmpty() {
        return head == null;
    }

    /**
     * Проверяет присутствие элемента в стеке
     * @param value элемент, который требуется найти в стеке
     * @return {@code true} если элемент присутствует в стеке
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
     * Очищает стек
     */
    void clear() {
        head = null;
        size = 0;
    }

}
