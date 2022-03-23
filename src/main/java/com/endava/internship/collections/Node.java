package com.endava.internship.collections;

public class Node<K,V> {
    private Node<K,V> left = null;
    private Node<K,V> right = null;
    private K key;
    private V value;


    public Node(K key,V value){
        this.key = key;
        this.value = value;
    }

    public Node<K,V> getLeft() {
        return left;
    }

    public Node<K,V> getRight() {
        return right;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setLeft(Node<K, V> left) {
        this.left = left;
    }

    public void setRight(Node<K, V> right) {
        this.right = right;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
