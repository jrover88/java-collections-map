package com.endava.internship.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;


public class StudentMapTests{
    private Map<Integer,String> map;
    private Map<Integer,String> mapToAdd;

    @BeforeEach
    public void setUp() {
        map = new StudentMap<>();
        mapToAdd = new StudentMap<>();
    }


    @Test
    public void initialMapIsEmpty(){
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
    }

    @Test
    public void mapIsNotEmpty(){
        map.put(1, "a");

        assertFalse(map.isEmpty());
        assertEquals(1, map.size());
    }

    @Test
    public void creatingAMap() {
        StudentMap<Integer,String> mapCreated = new StudentMap<>();

        assertTrue(mapCreated.isEmpty());
        assertEquals(0, mapCreated.size());
    }

    @Test
    public void mapContainsAValue() {
        map.put(5, "test");

        assertTrue(map.containsValue("test"));
    }

    @Test
    public void mapDoesNotContainAValue() {
        map.put(5, "test");

        assertFalse(map.containsValue("a"));
    }

    @Test
    public void mapContainsAKey() {
        map.put(7, "r");

        assertTrue(map.containsKey(7));
    }

    @Test
    public void mapDoesNotContainAKey() {
        map.put(7, "r");

        assertThat
    }

//    @Test
//    public void findAKey() {
//        map.put(7, "r");
//    }

    @Test
    public void mapGettingAnObject_IfAnObjectExists() {
        map.put(3, "s");

        assertEquals("s", map.get(3));
    }

    @Test
    public void mapGettingAnObject_IfAnObjectDoesNotExist() {
        map.put(3, "s");

        assertNull(map.get(7));
    }

    @Test
    public void mapAddingAnObject() {
        map.put(3, "s");


        assertNull(map.get(7));
    }
}
