package com.endava.internship.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;


public class StudentMapTests{
    private StudentMap<Integer,String> map;
    private StudentMap<Integer,String> mapToAdd;

    @BeforeEach
    public void setUp() {
        map = new StudentMap<>();
        map.put(11, "a");
        map.put(5, "b");
        map.put(9, "c");
        map.put(8, "d");
        map.put(7, "e");
        map.put(6, "f");
        mapToAdd = new StudentMap<>();
        mapToAdd.put(4, "ff");
        mapToAdd.put(2, "fd");
        mapToAdd.put(15, "gd");
        mapToAdd.put(1, "fg");
    }

//    @Test
//    public void createAMap {
//
//    }
}
