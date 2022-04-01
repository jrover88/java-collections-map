package com.endava.internship.collections;

import java.util.Collection;
import java.util.Set;

public class Launcher {
    public static void main(String[] args) {
/*        StudentMap<Student, Integer> treeMap = new StudentMap<>();
        Student fedor = new Student("Fedor", LocalDate.of(1995, 11, 28), "none");
        Student boris = new Student("Boris", LocalDate.of(1998, 9, 15), "none");
        Student alex = new Student("alex", LocalDate.of(1995, 1, 5), "none");
        Student steven = new Student("Steven", LocalDate.of(1995, 4, 8), "none");

        System.out.println(treeMap.containsKey(alex));
        treeMap.put(alex, 700);
        System.out.println(treeMap.containsKey(alex));
        System.out.println(treeMap.get(alex));*/
        StudentMap<Integer, String> testTree = new StudentMap<>();
        testTree.put(11, "a");
        testTree.put(15, "aa");
        testTree.put(5, "b");
        testTree.put(9, "c");
        testTree.put(8, "d");
        testTree.put(7, "e");
        testTree.put(6, "f");
        testTree.showInOrder();
        System.out.println(testTree.containsValue("a"));
        System.out.println(testTree.containsValue("bFF"));
        System.out.println(testTree.containsValue("c"));
        System.out.println(testTree.getRoot());
        System.out.println(testTree.get(855));
        System.out.println(testTree.size());
        System.out.println(testTree.remove(11));
        System.out.println(testTree.remove(100));
        System.out.println("Size+++ "+testTree.size());
        testTree.showInOrder();
        System.out.println("contains key: " + testTree.containsKey(9));
        System.out.println("contains value: " + testTree.containsValue("c"));
        System.out.println(testTree.containsKey(6));
        Set set = testTree.keySet();
        System.out.println("Setttttttttttt size: " + set.size());
        System.out.println(set);
        Collection col =  testTree.values();
        System.out.println(col);
        StudentMap<Integer, String> mapToAdding = new StudentMap<>();
        mapToAdding.put(4, "ff");
        mapToAdding.put(2, "fd");
        mapToAdding.put(6, "gd");
        mapToAdding.put(1, "fg");
        testTree.putAll(mapToAdding);
        testTree.showInOrder();
        System.out.println(testTree.entrySet());
    }
}
