package org.roman.jalgorithms;

import java.io.Serializable;
import java.util.*;

public class JBinaryTreeMap<Key extends Comparable<Key>, Value> implements JMap<Key, Value>, Serializable {

    private static final long serialVersionUID = 1362445678756L;

    private Node<Key, Value> root;

    private int size = 0;

    private static class Node<K, V> implements Serializable {
        private K key;
        private V value;

        Node<K, V> left;
        Node<K, V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public void remove(Key key) {
        if(root == null) return;
        Node<Key, Value> currentNode = root;
        Node<Key, Value> parent = null;
        boolean selectRightNode = false;
        boolean isFound = false;

        while (currentNode != null) {
            int compare = key.compareTo(currentNode.key);
            if (compare == 0) {
                isFound = true; //Найдено
                break;
            } else if (compare < 0) {
                parent = currentNode;
                selectRightNode = false;
                currentNode = currentNode.left;
            } else {
                parent = currentNode;
                selectRightNode = true;
                currentNode = currentNode.right;
            }
        }

        if(!isFound) return;

        //Потомков нет
        if(currentNode.left == null && currentNode.right == null) {
            if(parent != null) {
                if(selectRightNode)
                    parent.right = null;
                else
                    parent.left = null;
            } else {
                root = null;
            }
            size--;
        }

        //Один потомок
        if(currentNode.left == null ^ currentNode.right == null) {
            if(currentNode.left == null) {
                if(parent == null) {
                    root = currentNode.right;
                } else {
                    if(selectRightNode)
                        parent.right = currentNode.right;
                    else parent.left = currentNode.right;
                }
            } else {
                if(parent == null) {
                    root = currentNode.left;
                } else {
                    if(selectRightNode)
                        parent.right = currentNode.left;
                    else parent.left = currentNode.left;
                }
            }
            size--;
        }

        //Два потомка
        if(currentNode.left != null && currentNode.right != null) {
            Node<Key, Value> findLeftMin = currentNode.right; //Берем правый элемент
            Node<Key, Value> last = null;
            while (findLeftMin != null){
                last = findLeftMin;
                findLeftMin = findLeftMin.left;
            }

            //Меняем значение
            currentNode.key = last.key;
            currentNode.value = last.value;

            //Удалить найденный результат
            last.left = null;

            size--;
        }

    }

    @Override
    public void put(Key key, Value value) {

        Node<Key, Value> search = root;
        Node<Key, Value> lastNode = null;

        boolean isFound = false;

        while (search != null){
            int compare = key.compareTo(search.key);
            //Ключи совпали
            if(compare == 0) {
                isFound = true;
                break;
            } else {
                //Сохраняем последний узел
                lastNode = search;

                if(compare < 0) {
                    search = search.left;
                } else {
                    search = search.right;
                }
            }
        }
        if(isFound) {
            //Ключ найден, обновляем значение
            search.value = value;
        } else {
            Node<Key, Value> newNode = new Node<>(key, value);
            //Нет ноды, к которой можно прицепить элемент
            if (root == null) {
                root = newNode;
                size = 1;
            } else {
                if (key.compareTo(lastNode.key) < 0) {
                    lastNode.left = newNode;
                } else {
                    lastNode.right = newNode;
                }
                size++;
            }
        }
    }

    @Override
    public Value get(Key key) {
        var result = getNode(key);
        return (result != null) ? result.value : null;
    }

    private Node<Key, Value> getNode(Key key) {
        Node<Key, Value> search = root;
        Node<Key, Value> result = null;
        while (search != null) {
            int compare = key.compareTo(search.key);
            if(compare == 0) {
                //Ключ найден
                result = search;
                break;
            } else {
                if(compare < 0)
                    search = search.left;
                else
                    search = search.right;
            }
        }
        return result;
    }


    @Override
    public boolean containsKey(Key key) {
        return getNode(key) != null;
    }

    //Не работает, нужно дописать
    @Override
    public boolean containsValue(Value value) {
        Node<Key, Value> source = root;
        Stack<Node<Key, Value>> stack = new Stack<>();

        while (source != null || !stack.empty()) {
            if (!stack.empty())
                source = stack.pop();
            while (source != null) {
                if(source.value == value)
                    return true;
                if (source.right != null)
                    stack.push(source.right);
                source = source.left;
            }
        }
        return false;
    }

}
