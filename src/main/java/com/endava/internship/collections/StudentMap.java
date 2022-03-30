package com.endava.internship.collections;

import java.util.*;
import java.util.function.Consumer;

public class StudentMap<K extends Comparable<K>, V extends Comparable<V>> implements Map<K,V> {

    private int size;
    private Node<K, V> root;

    public Node<K, V> getRoot() {
        return root;
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


    @Override
    public boolean containsValue(Object value) {
        V valueObject;
        try {
            valueObject = (V) value;
        }
        catch (ClassCastException e) {
            return false;
        }

        return this.containsValue(this.root, valueObject) != null;
    }


    private Node<K,V> containsValue(Node<K,V> node, V value) {

        Stack<Node<K,V>> stack = new Stack<> ();
        while (node!=null || !stack.empty()) {
            if (!stack.empty()) {
                node = stack.pop();
                if (node.getValue().compareTo(value) == 0) {
                    return node;
                }
                if (node.getRight()!=null) {
                    node = node.getRight();
                }
                else {
                    node = null;
                }
            }
            while (node!=null) {
                stack.push(node);
                node=node.getLeft();
            }
        }
        return null;
    }

    public void showInOrder() {
        showInOrder(this.root);
    }

    private void showInOrder(Node<K,V> node) {
        if(node != null) {
            this.showInOrder(node.getLeft());
            System.out.println(node.getKey());
            this.showInOrder(node.getRight());
        }
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

    private Node<K, V> findParent(K key) {
        Node<K,V> current = this.root;
        Node<K,V> parent = null;
        while (current != null) {
            int result = current.getKey().compareTo(key);
            if(result > 0) {
                parent = current;
                current = current.getLeft();
            }
            else if (result < 0) {
                parent = current;
                current = current.getRight();
            }
            else {
                break;
            }
        }
        return parent;
    }


    @Override
    public V get(Object key) {
        //TODO
        K keyObject = null;
        try {
            keyObject = (K) key;
        }
        catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
        Node<K, V> node = this.find(keyObject);

        return node == null ? null : node.getValue();

    }

    @Override
    public V put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        if(this.root == null) {
            root = newNode;
            size++;
            return null;
        }
        this.size++;
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

        return null;
    }



    @Override
    public V remove(Object o) {
        K keyObject = null;
        try {
            keyObject = (K) o;
        }
        catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
        if(!containsKey(keyObject)) {
            return null;
        }
        Node<K, V> current, parent = null;
        current = this.find(keyObject);
        parent = this.findParent(keyObject);

        V value = current.getValue();
        if (current == null)
        {
            return null;
        }
        this.size--;

        if(current.getRight() == null) {
            if(parent == null) {
                this.root = current.getLeft();
            }
            else {
                int result = parent.getKey().compareTo(current.getKey());

                if(result > 0) {
                    parent.setLeft(current.getLeft());
                }else if (result < 0) {
                    parent.setRight(current.getLeft());
                }
            }
        } else if(current.getRight().getLeft() == null){
            current.getRight().setLeft(current.getLeft());
            if(parent == null) {
                this.root = current.getRight();
            } else {
                int result = parent.getKey().compareTo(current.getKey());
                if (result > 0) {
                    parent.setLeft(current.getRight());
                } else if (result < 0) {
                    parent.getRight().setRight(current.getRight());
                }
            }

        } else {
            Node<K,V> mostLeft = current.getRight().getLeft();
            Node<K,V> mostLeftParent = current.getRight();
            while(mostLeft.getLeft() != null) {
                mostLeftParent = mostLeft;
                mostLeft = mostLeft.getLeft();
            }
            mostLeftParent.setLeft(mostLeft.getRight());
            mostLeft.setLeft(current.getLeft());
            mostLeft.setRight(current.getRight());
            if(parent == null) {
                this.root = mostLeft;
            } else {
                int result = parent.getKey().compareTo(current.getKey());
                if(result > 0) {
                    parent.setLeft(mostLeft);
                } else if(result < 0) {
                    parent.setRight(mostLeft);
                }
            }

        }

        return value;
    }


    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
            put(e.getKey(), e.getValue());
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
        Set<K> set = new HashSet<>();

        return this.addToSet(set, this.root);
    }

    private Set<K> addToSet(Set<K> set, Node<K,V> node) {
        if(node != null) {
            this.addToSet(set, node.getLeft());
            set.add(node.getKey());
            this.addToSet(set, node.getRight());
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        List<V> list = new ArrayList<>();

        return this.addToList(list, this.root);
    }

    private Collection<V> addToList(Collection<V> list, Node<K,V> node) {
        if(node != null) {
            this.addToList(list, node.getLeft());
            list.add(node.getValue());
            this.addToList(list, node.getRight());
        }
        return list;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<>();
        return this.addToSet(this.root, entrySet);
    }

    private Set<Entry<K, V>> addToSet(Node<K, V> node, Set<Entry<K, V>> set) {
        if(node != null) {
            MyEntry<K, V> entry = new MyEntry<>(node.getKey(), node.getValue());
            set.add(entry);
            this.addToSet(node.getLeft(), set);
            this.addToSet(node.getRight(), set);
        }
        return set;
    }


}

