package com.endava.internship.collections;

import java.time.LocalDate;

/**
 * The class that defines the element that will be contained by your collection
 */
public class Student implements Comparable<Student>//TODO consider implementing any interfaces necessary for your collection
{
    private String name;
    private LocalDate dateOfBirth;
    private String details;

    public Student(String name, LocalDate dateOfBirth, String details) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.details = details;
    }

    @Override
    public int compareTo(Student o) {
        int compare = this.name.compareTo(o.getName());
        if (compare == 0) {
            return this.dateOfBirth.compareTo(o.getDateOfBirth());
        }
        return compare;
    }

    public String getName() { return name; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }

    public String getDetails() { return details; }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nDate of birth: " + this.dateOfBirth + "\nDetails: " + this.details;
    }

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
        testTree.put(5, "b");
        testTree.put(9, "c");
        testTree.put(8, "d");
        testTree.put(7, "e");
        testTree.put(6, "f");
        System.out.println(testTree.remove(5));
    }


    /*
    TODO consider overriding any methods for this object to function properly within a collection:
        1. A student is considered unique by a combination of their name and dateOfBirth
        2. Student names are sorted alphabetically, if two students have the same name, then the older one is
        placed before the younger student in an ordered student list.
    */
}
