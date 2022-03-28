package com.endava.internship.collections;

import java.util.Map;
import java.util.Set;

public class MyEntry<K,V> implements Map.Entry<K, V>{
    private K key;
    private V value;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        return this.value = value;
    }

    @Override
    public String toString() {
        return "[" + key + ", "+ value+"]";
    }
}
