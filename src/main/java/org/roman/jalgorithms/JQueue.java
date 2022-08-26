package org.roman.jalgorithms;

import java.util.NoSuchElementException;

public interface JQueue<Value> {



    void pushLast(Value object);



    /**
     * Возвращает первый элемент списка и не удаляет его
     * @throws NoSuchElementException если список пустой
     * @return первый элемент списка
     */
    Value peek();

    /**
     * Возвращает первый элемент из списка и удаляет его
     * @throws NoSuchElementException если список пустой
     * @return первый элемент из связного списка
     */
    Value poll();

    /**
     * Возвращает количество элементов в очереди
     * @return количество элементов в очереди
     */
    int size();

    /**
     * Возвращает {@code true} если в коллекции отсутствуют элементы.
     * @return {@code true} if this collection contains no elements
     */
    boolean isEmpty();

    /**
     * Возвращает хеш-код. Если объекты разные - то и их хеш-коды разные
     * @return хеш-код
     */
    int hashCode();

    /**
     * Проверяет присутствие элемента в очереди
     * @param object элемент, который требуется найти в очереди
     * @return {@code true} если элемент присутствует в очереди
     */
    boolean contains(Object object);


    /**
     * Создает массив из элементов очереди
     * @return массив из элементов очереди
     */
    Object[] toArray();

    /**
     * Очищает очередь
     */
    void clear();




}
