package com.endava.internship.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

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




    /*
    TODO consider overriding any methods for this object to function properly within a collection:
        1. A student is considered unique by a combination of their name and dateOfBirth
        2. Student names are sorted alphabetically, if two students have the same name, then the older one is
        placed before the younger student in an ordered student list.
    */
}
