package com.endava.internship.collections;

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
        return size > 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    public boolean containsKey(K key) {
        //TODO
        return false;
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
        //TODO
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }


    @Override
    public void clear() {
        //TODO
    }

    @Override
    public Set<K> keySet() {
        //TODO
        return null;
    }

    @Override
    public Collection<V> values() {
        //TODO
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }


}

