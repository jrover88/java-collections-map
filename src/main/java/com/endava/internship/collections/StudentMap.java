package com.endava.internship.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class StudentMap<K extends Comparable<K>, V> implements Map<K,V> {

    private int size;
    Node<K, V> root;

    public StudentMap() {
        this.size = 0;
        this.root = null;
    }

    @Override
    public int size() {
        //TODO
        return size;
    }

    @Override
    public boolean isEmpty() {
        //TODO
        return size == 0;
    }

//

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        K keyObject;
        try {
            keyObject = (K) key;
        }
        catch (ClassCastException e) {
            return false;
        }

        return this.find(keyObject) != null;
    }

    private Node<K, V> find(K key) {
        Node<K,V> current = this.root;
        while (current != null) {
            int result = current.getKey().compareTo(key);
            if(result > 0) {
                current = current.getLeft();
            }
            else if (result < 0) {
                current = current.getRight();
            }
            else {
                return current;
            }
        }
        return current;
    }


    @Override
    public V get(Object o) {
        //TODO

        return null;
    }

    @Override
    public V put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        if(this.root == null) {
            root = newNode;
            size++;
            return null;
        }
        return this.put(this.root, newNode);
    }

    private V put(Node<K,V> currentNode, Node<K,V> newNode) {
        if(newNode.getKey().compareTo(currentNode.getKey()) > 0) {
            if(currentNode.getRight() == null) {
                currentNode.setRight(newNode);
            } else {
                this.put(currentNode.getRight(), newNode);
            }
        }

        if(newNode.getKey().compareTo(currentNode.getKey()) < 0) {
            if(currentNode.getLeft() == null) {
                currentNode.setLeft(newNode);
            } else {
                this.put(currentNode.getLeft(), newNode);
            }
        }

        if(newNode.getKey().compareTo(currentNode.getKey()) == 0) {
            V oldValue = currentNode.getValue();
            currentNode.setValue(newNode.getValue());
            return oldValue;
        }
        this.size++;
        return null;
    }



    @Override
    public V remove(Object o) {
        K keyObject = null; // ?
        try {
            keyObject = (K) o;
        }
        catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }

        if(this.root == null) {
            return null;
        }

        return this.remove(this.root, keyObject);
    }


    private V remove(Node<K, V> currentNode, K key) {

        if(currentNode.getKey().compareTo(key) == 0) {
            V value = currentNode.getValue();
            if(currentNode.getLeft() == null && currentNode.getRight() == null) {
                currentNode.clear(currentNode);
            }

            if(currentNode.getRight() == null) {

            }
            return value;
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }


    @Override
    public void clear() {
        //TODO
        this.root = null;
        this.size = 0;
    }

    @Override
    public Set<K> keySet() {
        //TODO
        return null;
    }

    @Override
    public Collection<V> values() {
        //TODO
        ArrayList<V> arr = new ArrayList<>();
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }


}

