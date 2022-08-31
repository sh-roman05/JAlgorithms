package org.roman.jalgorithms;

import java.io.Serializable;
import java.util.Random;
import java.util.Stack;

public class JRandBinaryTreeMap<Key extends Comparable<Key>, Value> implements JMap<Key, Value>, Serializable {

    /*
    * Рандомизированное дерево поиска
    * Обеспечивают логарифмическую сложность выполнения основных операций
    *
    * */


    //https://habr.com/ru/post/145388/

    private Node<Key, Value> root = null;

    private static final long serialVersionUID = 8900289502567L;

    Random random = new Random();

    private static class Node<K, V> implements Serializable {
        private K key;
        private V value;
        Node<K, V> left;
        Node<K, V> right;
        //Количество узлов в поддереве с этим корнем
        int size;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            size = 1;
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node<Key, Value> root) {
        return (root != null) ? root.size : 0;
    }

    @Override
    public void clear() {
        root = null;
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
            return removeElement(root.left, root.right);
        }
        return root;
    }

    private Node<Key, Value> removeElement(Node<Key, Value> rl, Node<Key, Value> rr) {
        //Элемент найден. Выполнить удаление.
        //Если потомок только один, то слияние не требуется
        if(rl == null) return rr;
        if(rr == null) return rl;
        boolean left = (random.nextInt() % (size(root.left) + size(root.right)) < size(root.left)) ? true : false;
        if(left) {
            rl.right = removeElement(rl.right, rr);
            rl.size = size(rl.left) + size(rl.right) + 1;
            return rl;
        } else {
            rr.left = removeElement(rl, rr.left);
            rr.size = size(rr.left) + size(rr.right) + 1;
            return rr;
        }
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node<Key, Value> put(Node<Key, Value> root, Key key, Value value) {
        if (root == null) return new Node<>(key, value);
        //
        boolean insertAllowed = (random.nextInt() % (size(root) + 1) == 0) ? true : false;
        if(insertAllowed)
            return putInRoot(root, key, value);
        int compare = key.compareTo(root.key);
        if (compare < 0) {
            //меньше
            root.left = put(root.left, key, value);
        } else if (compare > 0) {
            //больше
            root.right = put(root.right, key, value);
        } else {
            //Узел уже есть, обновить значение
            root.value = value;
        }
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }

    private Node<Key, Value> putInRoot(Node<Key, Value> root, Key key, Value value) {
        if (root == null) return new Node<>(key, value);
        int compare = key.compareTo(root.key);
        if (compare < 0){
            root.left = putInRoot(root.left, key, value);
            root = rotateRight(root);
        } else if (compare > 0) {
            root.right = putInRoot(root.right, key, value);
            root = rotateLeft(root);
        } else {
            //Узел уже есть, обновить значение
            root.value = value;
        }
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }

    //Поворот дерева. Сохраняет правило сортировки.
    private Node<Key, Value> rotateLeft(Node<Key, Value> root) {
        Node<Key, Value> newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        newRoot.size = root.size;
        root.size = size(root.left) + size(root.right) + 1;
        return newRoot;
    }

    //Поворот дерева. Сохраняет правило сортировки.
    private Node<Key, Value> rotateRight(Node<Key, Value> root) {
        Node<Key, Value> newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        newRoot.size = root.size;
        root.size = size(root.left) + size(root.right) + 1;
        return newRoot;
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

    @Override
    public boolean containsValue(Value value) {
        Node<Key, Value> source = root;
        Stack<Node<Key, Value>> stack = new Stack<>();

        while (source != null || !stack.empty()) {
            if (!stack.empty())
                source = stack.pop();
            while (source != null) {
                if(source.value.equals(value))
                    return true;
                if (source.right != null)
                    stack.push(source.right);
                source = source.left;
            }
        }
        return false;
    }

}
