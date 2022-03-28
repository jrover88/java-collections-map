package com.endava.internship.collections;

import java.time.LocalDate;

public class Student implements Comparable<Student>
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


}
