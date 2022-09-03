package org.roman.jalgorithms;

import java.util.NoSuchElementException;

public class JQueue<Value extends Comparable<Value>> {

    private int size = 0;

    private Node<Value> head = null;
    private Node<Value> tail = null;

    private static class Node<T> {
        private T value = null;
        private Node<T> next = null;

        public Node(T value) {
            this.value = value;
        }
    }

    /**
     * Добавляет значение в очередь
     * @param value элемент, который требуется добавить в очередь
     */
    public void add(Value value) {
        Node<Value> temp = new Node<>(value);
        if (head == null) {
            head = tail = temp;;
        } else {
            tail.next = temp;
            tail = temp;
        }
        ++size;
    }

    /**
     * Возвращает элемент из очереди и не удаляет его
     * @throws NoSuchElementException если очередь пустая
     * @return элемент очереди
     */
    public Value peek() {
        if(head == null)
            throw new NoSuchElementException();
        return head.value;
    }

    /**
     * Возвращает элемент из очереди и удаляет его
     * @throws NoSuchElementException если очередь пустая
     * @return элемент из очереди
     */
    public Value poll() {
        if (head == null)
            throw new NoSuchElementException();
        Value temp = head.value;
        //Удаление первого элемента
        if (head == tail)
            head = tail = null;
        else
            head = head.next;
        --size;
        return temp;
    }

    /**
     * Возвращает количество элементов в очереди
     * @return количество элементов в очереди
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет, пустая ли очередь
     * @return {@code true} если в очереди отсутствуют элементы.
     */
    public boolean isEmpty() {
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
    public void clear() {
        head = tail = null;
        size = 0;
    }

}
