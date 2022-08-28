package org.roman.jalgorithms;

import java.io.Serializable;
import java.util.Stack;

public class JAVLTree<Key extends Comparable<Key>, Value> implements JMap<Key, Value>, Serializable {

    /*
    * АВЛ-дерево
    *
    *
    * */



    //Поскольку я реализовал работу через стек, на больших данных будет ошибка StackOverflow
    //Переделать на итеративный подход

    private Node<Key, Value> root = null;
    private int size = 0;

    private static final long serialVersionUID = 2488425698051L;

    static class Node<K, V> implements Serializable {
        K key;
        V value;
        Node<K, V> left = null;
        Node<K, V> right = null;
        int height = 1;

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
        root = remove(root, key);
    }

    private Node<Key, Value> remove(Node<Key, Value> root, Key key) {
        if (root == null) return null;
        int compare = key.compareTo(root.key);
        if(compare < 0) {
            root.left = remove(root.left, key);
        } else if(compare > 0) {
            root.right = remove(root.right, key);
        } else {
            Node<Key, Value> lt = root.left;
            Node<Key, Value> rt = root.right;
            if(rt == null) return lt;
            //Найти минимум и заменить им удаляемый элемент
            Node<Key, Value> min = findMin(rt);
            min.left = lt;
            min.right = removeMin(rt);
            size--;
            return balance(min);
        }
        return balance(root);
    }

    private Node<Key, Value> findMin(Node<Key, Value> root) {
        return (root.left != null) ? findMin(root.left) : root;
    }

    private Node<Key, Value> removeMin(Node<Key, Value> root) {
        if(root.left == null)
            return root.right;
        root.left = removeMin(root.left);
        return balance(root);
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node<Key, Value> put(Node<Key, Value> root, Key key, Value value) {
        if (root == null) {
            size++;
            return new Node<>(key, value);
        }
        int compare = key.compareTo(root.key);
        if (compare < 0) {
            root.left = put(root.left, key, value);
        } else if (compare > 0) {
            root.right = put(root.right, key, value);
        } else {
            //Узел уже есть, обновить значение
            root.value = value;
        }
        return balance(root);
    }



    @Override
    public Value get(Key key) {
        var el = getNode(root, key);
        return (el != null) ? el.value : null;
    }

    @Override
    public boolean containsKey(Key key) {
        var el = getNode(root, key);
        return el != null;
    }

    //исправить
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

    //Рекурсивно идем по дереву и отдаем искомый элемент либо null
    private Node<Key, Value> getNode(Node<Key, Value> root, Key key) {
        if (root == null) return null;
        int compare = key.compareTo(root.key);
        if (compare < 0) {
            return getNode(root.left, key);
        } else if (compare > 0) {
            return getNode(root.right, key);
        } else {
            return root;
        }
    }

    private Node<Key, Value> balance(Node<Key, Value> root) {
        setHeight(root);
        if (balanceFactor(root) == 2) {
            if(balanceFactor(root.right) < 0) {
                root.right = rotateRight(root.right);
            }
            return rotateLeft(root);
        }
        if (balanceFactor(root) == -2) {
            if(balanceFactor(root.left) < 0) {
                root.left = rotateLeft(root.left);
            }
            return rotateRight(root);
        }
        return root;
    }

    private Node<Key, Value> rotateLeft(Node<Key, Value> root) {
        //Поворот дерева влево с сохранением сортировки
        Node<Key, Value> newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private Node<Key, Value> rotateRight(Node<Key, Value> root) {
        //Поворот дерева вправо с сохранением сортировки
        Node<Key, Value> newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private int height(Node<Key, Value> root) {
        return (root != null) ? root.height : 0;
    }

    private int balanceFactor(Node<Key, Value> root) {
        return height(root.right) - height(root.left);
    }

    private void setHeight(Node<Key, Value> root) {
        if(root == null) return;
        int lh = height(root.left);
        int rh = height(root.right);
        root.height = ((lh > rh) ? lh : rh) + 1;
    }

}
