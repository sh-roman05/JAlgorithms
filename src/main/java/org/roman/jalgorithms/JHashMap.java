package org.roman.jalgorithms;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class JHashMap<Key, Value> implements JMap<Key, Value>, Serializable {

    private static final long serialVersionUID = 1385402501830L;

    /*
    * Структура данных: Хэш-таблица
    * Механизм разрешения коллизий - метод цепочек
    * */

    //todo автоматическое изменение размера массива при перегрузке

    //Вместимость
    private final int initialCapacity;
    //Количество элементов
    private int size = 0;

    //Коэффициент заполнения хеш-таблицы.
    //double loadFactor = 0.75; //размер на количество элементов

    //Максимальная вместимость
    private static final int MAX_CAPACITY = Integer.MAX_VALUE >> 1;


    private List<Node<Key, Value>>[] table;

    JHashMap()
    {
        this(1024);
    }

    @SuppressWarnings("unchecked")
    JHashMap(int initialCapacity)
    {
        if(initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity + ". The number must be positive");

        this.initialCapacity = Math.min(initialCapacity, MAX_CAPACITY);


        table = (List<Node<Key, Value>>[]) new LinkedList[initialCapacity];
        Arrays.fill(table, new LinkedList<>());
    }


    private static class Node<K, V> implements Serializable
    {
        private final K key;
        private final V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<K, V> node = (Node<K, V>) o;
            //return key.equals(node.key) && value.equals(node.value);
            return key.equals(node.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

    //Этот код маскирует знаковый бит
    //Через остаток от деления получаем индекс в массиве
    private int hash(Key key)
    {
        return (key == null) ? 0 : ((key.hashCode() & 0x7fffffff) % initialCapacity);
    }

    @Override
    public void put(Key key, Value value) {
        //А если уже существует ключ???
        int hash = hash(key);
        Node<Key, Value> temp = new Node<>(key, value);
        if(table[hash].contains(temp)) {
            //Обновить значение
            for (Node<Key, Value> item : table[hash]) {
                if (key.equals(item.key)) {
                    int index = table[hash].indexOf(item);
                    table[hash].set(index, temp);
                }
            }
        } else {
            //Добавить в список
            table[hash].add(temp);
            size++;
        }
    }

    @Override
    public void remove(Key key) {
        int hash = hash(key);
        for (Node<Key, Value> item : table[hash]) {
            if (key.equals(item.key))  {
                table[hash].remove(item);
                size--;
                break;
            }
        }
    }

    @Override
    public Value get(Key key) {
        int hash = hash(key);
        Value temp = null;
        if(table != null && size > 0) {
            for (Node<Key, Value> item : table[hash]) {
                if (key.equals(item.key)) {
                    temp = item.value;
                    break;
                }
            }
        }
        return temp;
    }

    /*@SuppressWarnings("unchecked")
    void resize(){
        table = (List<Node<Key, Value>>[]) new LinkedList[20000];
    }*/


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(Key key) {
        return (get(key) != null) ? true : false;
    }

    @Override
    public boolean containsValue(Value value) {
        if (table != null && size > 0)
            for (List<Node<Key, Value>> chainList: table)
                for (Node<Key, Value> node: chainList)
                    if (value.equals(node.value))
                        return true;
        return false;
    }

    @Override
    public void clear() {
        if(table != null && size > 0) {
            Arrays.fill(table, new LinkedList<>());
            size = 0;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
