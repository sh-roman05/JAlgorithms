package org.roman.jalgorithms;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class JLinkedList<Value extends Comparable<Value>> {

    private Node<Value> head = null;
    private Node<Value> tail = null;

    private int size = 0;

    private static class Node<T> {
        private T value = null;
        private Node<T> next = null;

        public Node(T value) {
            this.value = value;
        }
    }

    //Удаление по индексу
    //Вставка по индексу

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }


    //Удалить первое вхождение объекта
    public boolean remove(Value value) {
        Node<Value> search = head;
        Node<Value> previousNode = null;
        while (search != null) {
            //Элемент найден, произвести удаление
            if(value.equals(search.value)) {
                if (head == tail) {
                    head = tail = null;
                } else {
                    //Объектов 2 или больше
                    if (previousNode == null)
                        head = search.next;
                    else if(search.next == null) {
                        previousNode.next = null;
                        tail = previousNode;
                    }
                    else {
                        previousNode.next = search.next;
                    }
                }
                --size;
                return true;
            }
            //Сохраняем ссылку на предыдущую ноду
            previousNode = search;
            search = search.next;
        }
        return false;
    }

    public boolean contains(Value value) {
        Node<Value> search = head;
        while (search != null) {
            if(value.equals(search.value))
                return true;
            search = search.next;
        }
        return false;
    }

    public int indexOf(Value value) {
        Node<Value> search = head;
        int i = 0;
        while (search != null) {
            if(value.equals(search.value)) return i;
            search = search.next;
            ++i;
        }
        return -1;
    }

    public Value get(int index) {
        Node<Value> search = head;
        int i = 0;
        while (search != null) {
            if(index == i) return search.value;
            search = search.next;
            ++i;
        }
        return null;
    }



    //Добавить в конец
    public void add(Value value) {
        Node<Value> temp = new Node<>(value);
        //Если лист пустой, то начало и конец списка указываем на новый элемент
        if(head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public int size() {
        return size;
    }

}
