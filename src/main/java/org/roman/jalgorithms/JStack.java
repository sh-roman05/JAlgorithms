package org.roman.jalgorithms;

import java.util.NoSuchElementException;

public interface JStack<Value> {

    /**
     * Добавляет элемент в начало списка
     * @param object элемент для добавления
     */
    void push(Value object);

    /**
     * Возвращает первый элемент из списка и удаляет его
     * @throws NoSuchElementException если список пустой
     * @return первый элемент из связного списка
     */
    Value pop();

    /**
     * Возвращает количество элементов в стеке
     * @return количество элементов в стеке
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
     * Проверяет присутствие элемента в стеке
     * @param object элемент, который требуется найти в стеке
     * @return {@code true} если элемент присутствует в стеке
     */
    boolean contains(Object object);


    /**
     * Создает массив из элементов стека
     * @return массив из элементов стека
     */
    Object[] toArray();

    /**
     * Очищает стек
     */
    void clear();

}
