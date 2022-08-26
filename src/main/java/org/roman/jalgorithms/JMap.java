package org.roman.jalgorithms;

import java.util.Set;


public interface JMap<Key, Value> {

    /**
     * Проверяет, если ли данные в ассоциативном массиве
     * @return {@code true} если элементы отсутсвуют
     */
    boolean isEmpty();

    /**
     * Возвращает количество ключей в ассоциативном массиве
     * @return количество ключей в ассоциативном массиве
     */
    int size();

    /**
     * Очищает ассоциативный массив
     */
    void clear();

    /**
     * Удаляет ключ и значение
     * @param key ключ для удаления
     */
    void remove(Key key);

    /**
     * Помещает ключ/значение в ассоциативный массив
     * @param key ключ, который нужно вставить
     * @param value значение, которое нужно вставить
     */
    void put(Key key, Value value);

    /**
     * Получает значение по ключу
     * @param key ключ, для которого нужно получить значение
     * @return значение соответствующее ключу
     */
    Value get(Key key);

    /**
     * Проверяет, есть ли ключ в ассоциативном массиве
     * @param key ключ для поиска
     * @return {@code true} если ключ найден
     */
    boolean containsKey(Key key);


    /**
     * Выполняет обход дерева и ищет значение
     * @param value значение для поиска
     * @return {@code true} если значение найдено
     */
    boolean containsValue(Value value);






}
