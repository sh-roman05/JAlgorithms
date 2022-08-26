package org.roman.jalgorithms;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class JLinkedList<Value> implements JStack<Value>, JQueue<Value>, Serializable {

    private int size = 0;
    private Node<Value> header = null;
    private Node<Value> tail = null;


    @Override
    public void pushLast(Value object) {
        addLast(object);
    }

    /**
     * Возвращает первый элемент списка и не удаляет его
     * @throws NoSuchElementException если список пустой
     * @return первый элемент списка
     */
    @Override
    public Value peek() {
        return getFirst();
    }

    /**
     * Возвращает первый элемент из списка и удаляет его
     * @throws NoSuchElementException если список пустой
     * @return первый элемент из связного списка
     */
    @Override
    public Value poll() {
        return getFirstAndRemove();
    }



    @Override
    public boolean contains(Object object) {
        Node<Value> pointer = header;
        while (pointer != null) {
            if(object.equals(pointer.value)) return true;
            pointer = pointer.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        Node<Value> pointer = header;
        while (pointer != null) {
            result[i++] = pointer.value;
            pointer = pointer.next;
        }
        return result;
    }

    @Override
    public void clear() {
        header = tail = null;
        size = 0;
    }

    @Override
    public int hashCode() {
        //Собераем хеш-коды со всего списка
        int hashCode = 1;
        Node<Value> pointer = header;
        while (pointer != null) {
            hashCode += pointer.hashCode();
            pointer = pointer.next;
        }
        return hashCode;
    }

    /**
     * Добавляет элемент в начало списка
     * @param object элемент для добавления
     */
    @Override
    public void push(Value object) {
        addFirst(object);
    }

    /**
     * Возвращает первый элемент из списка и удаляет его
     * @throws NoSuchElementException если список пустой
     * @return первый элемент из связного списка
     */
    @Override
    public Value pop() {
        return getFirstAndRemove();
    }

    private static class Node<V> implements Serializable {
        private V value;
        private Node<V> next;
        private Node<V> prev;

        public Node(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    /**
     * Возвращает количество элементов в списке
     * @return количество элементов в списке
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Возвращает {@code true} если список пустой
     * @return {@code true} если список пустой
     */
    @Override
    public boolean isEmpty() {
        return header == null;
    }

    /**
     * Добавляет элемент в начало списка
     * @param value элемент для добавления
     */
    public void addFirst(Value value) {
        Node<Value> newElement = new Node<>(value);
        newElement.next = header;
        if(header != null)
            header.prev = newElement;
        header = newElement;
        if(tail == null)
            tail = newElement;
        size++;
    }

    /**
     * Добавляет элемент в конец списка
     * @param value элемент для добавления
     */
    public void addLast(Value value) {
        Node<Value> newElement = new Node<>(value);
        newElement.prev = tail;
        if(tail != null)
            tail.next = newElement;
        tail = newElement;
        if(header == null)
            header = newElement;
        size++;
    }

    /**
     * Возвращает первый элемент списка и не удаляет его
     * @throws NoSuchElementException если список пустой
     * @return первый элемент списка
     */
    public Value getFirst() {
        if (header == null)
            throw new NoSuchElementException();
        return header.value;
    }

    /**
     * Возвращает последний элемент списка и не удаляет его
     * @throws NoSuchElementException если список пустой
     * @return последний элемент списка
     */
    public Value getLast() {
        if (tail == null)
            throw new NoSuchElementException();
        return tail.value;
    }


    /**
     * Возвращает первый элемент из списка и удаляет его
     * @throws NoSuchElementException если список пустой
     * @return первый элемент из связного списка
     */
    public Value getFirstAndRemove() {
        if (header == null)
            throw new NoSuchElementException();
        Value first = header.value;
        if(tail == header) {
            tail = header = null;
        }else {
            header = header.next;
            header.prev = null;
        }
        size--;
        return first;
    }

    /**
     * Возвращает последний элемент из списка и удаляет его
     * @throws NoSuchElementException если список пустой
     * @return последний элемент из связного списка
     */
    public Value getLastAndRemove() {
        if (tail == null)
            throw new NoSuchElementException();
        Value last = tail.value;
        if(tail == header) {
            header = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return last;
    }

}
