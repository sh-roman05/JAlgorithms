package org.roman.jalgorithms;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class JLinkedList<Value extends Comparable<Value>> {

    private Node<Value> head = null;
    private Node<Value> tail = null;

    // if(true) throw new IndexOutOfBoundsException();
    //add(1, el)
    //index >= 0 && index <= this.size

    private int size = 0;

    private static class Node<T> {
        private T value = null;
        private Node<T> next = null;

        public Node(T value) {
            this.value = value;
        }
    }


    /**
     * Очищает список
     */
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * Удаляет объект по индексу
     * @param index индекс удаляемого элемента
     * @return {@code true} если элемент удален
     */
    public boolean removeByIndex(int index) {
        if(!(index >= 0 && index < this.size))
            throw new IndexOutOfBoundsException();
        Node<Value> search = head;
        Node<Value> previousNode = null;
        int count = 0;
        while (search != null) {
            if(count == index) {
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
            ++count;
        }
        return false;
    }


    /**
     * Удаляет первое вхождение объекта
     * @param value элемент для поиска
     * @return {@code true} если элемент удален
     */
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

    /**
     * Присутствует ли элемент в списке
     * @param value элемент для поиска
     * @return {@code true} если элемент найден
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
     * Поиск индекса элемента в списке
     * @param value элемент для поиска
     * @return индекс искомого элемента
     */
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

    /**
     * Поиск индекса последнего вхождения элемента в списке.
     * Поскольку это односвязный список, для поиска нужен полный обход
     * @param value элемент для поиска
     * @return индекс искомого элемента
     */
    public int lastIndexOf(Value value) {
        Node<Value> search = head;
        int i = 0, result = -1;
        while (search != null) {
            if(value.equals(search.value)) result = i;
            search = search.next;
            ++i;
        }
        return result;
    }

    /**
     * Поиск элемента по индексу
     * @param index индекс для поиска
     * @return найденное значение
     */
    public Value get(int index) {
        if(!(index >= 0 && index < this.size))
            throw new IndexOutOfBoundsException();
        Node<Value> search = head;
        int i = 0;
        while (search != null) {
            if(index == i) return search.value;
            search = search.next;
            ++i;
        }
        return null;
    }


    /**
     * Добавляет элемент в указанный индекс
     * @param value добавляемый элемент
     * @param index индекс
     */
    public void add(Integer index, Value value) {
        if(!(index >= 0 && index <= this.size))
            throw new IndexOutOfBoundsException();
        //Вставляем в индекс
        Node<Value> temp = new Node<>(value);
        //Список пустой
        if(head == null) {
            head = tail = temp;
            size++;
            return;
        }
        //В начало или между элементами
        Node<Value> search = head;
        Node<Value> previous = null;
        int i = 0;
        while (search != null) {
            if(i == index) {
                if(previous == null) {
                    temp.next = head;
                    head = temp;
                } else {
                    previous.next = temp;
                    temp.next = search;
                }
                size++;
                return;
            }
            else {
                previous = search;
                search = search.next;
                i++;
            }
        }
        //Добавление в конец
        tail.next = temp;
        tail = temp;
        size++;
    }


    /**
     * Добавляет элемент в конец списка
     * @param value добавляемый элемент
     */
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

    /**
     * Получить число элементов в списке
     * @return число элементов в списке
     */
    public int size() {
        return size;
    }

}
