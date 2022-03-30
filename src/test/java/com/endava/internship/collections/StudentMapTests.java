package com.endava.internship.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;


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

//    @Test
//    public void creatingAMap() {
//        StudentMap<Integer,String> mapCreated = new StudentMap<>();
//
//        assertTrue(mapCreated.isEmpty());
//        assertEquals(0, mapCreated.size());
//    }

    @Test
    public void mapContainsAValue() {
        map.put(5, "test");
        map.put(7, "a");
        map.put(4, "r");

        assertTrue(map.containsValue("test"));
        assertTrue(map.containsValue("r"));
        assertTrue(map.containsValue("a"));
    }

    @Test
    public void mapDoesNotContainAValue() {
        map.put(5, "test");
        map.put(6, "dog");
        map.put(7, "cat");

        assertFalse(map.containsValue("a"));
        assertFalse(map.containsValue("monkey"));
        assertFalse(map.containsValue("tiger"));
    }

    @Test
    public void mapContainsAKey() {
        map.put(7, "r");
        map.put(5, "r");
        map.put(9, "r");

        assertTrue(map.containsKey(7));
        assertTrue(map.containsKey(5));
        assertTrue(map.containsKey(9));
    }

    @Test
    public void mapDoesNotContainAKey() {
        map.put(7, "r");
        map.put(5, "r");
        map.put(9, "r");

        assertFalse(map.containsKey(6));
        assertFalse(map.containsKey(11));
        assertFalse(map.containsKey(62));
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
        map.put(5, "s");
        map.put(7, "b");
        map.put(8, "e");
        map.put(4, "q");
        map.put(3, "w");

        assertEquals(5, map.size());
        assertEquals("s", map.put(5, "ss"));
    }

    @Test
    public void mapRemovingFirstElement() {
        map.put(11, "a");
        map.put(15, "aa");

        map.remove(11);

        assertEquals(1, map.size());
        assertFalse(map.containsKey(11));
        assertTrue(map.containsKey(15));
    }

    @Test
    public void mapDoesNotContainRemovingElement() {
        map.put(11, "a");
        map.put(15, "aa");

        assertNull(map.remove(1));
    }

    @Test
    public void mapRemovingAnElement_WhichDoesNotHaveRightChild() {
        map.put(15, "a");
        map.put(13, "b");
        map.put(11, "c");

        assertEquals("b", map.remove(13));
        assertFalse(map.containsKey(13));
    }

    @Test
    public void mapRemovingAnElement_WhichHasRightChild_WhichHasLeftChild() {
        map.put(11, "a");
        map.put(15, "aa");
        map.put(5, "b");
        map.put(9, "c");
        map.put(8, "d");
        map.put(7, "e");
        map.put(6, "f");

        assertEquals("b", map.remove(5));
        assertFalse(map.containsKey(5));
    }

    @Test
    public void mapPutAll() {
        mapToAdd.put(11, "a");
        mapToAdd.put(15, "aa");
        mapToAdd.put(5, "b");
        mapToAdd.put(9, "c");
        map.putAll(mapToAdd);

        assertEquals(4, map.size());
        assertTrue(map.containsKey(11));
        assertEquals("a", map.get(11));
    }

    @Test
    public void mapClearing() {
        map.put(11, "a");
        map.put(15, "aa");

        map.clear();

        assertEquals(0, map.size());
        assertFalse(map.containsKey(11));
        assertFalse(map.containsKey(15));
        assertTrue(map.isEmpty());
//        assertNull(map.getRoot()); // doesn't work ?
    }

    @Test
    public void mapKeySet() {
        map.put(11, "a");
        map.put(15, "aa");
        map.put(5, "b");
        map.put(9, "c");
        Set<Integer> set2 = map.keySet();
        Set<Integer> set = new HashSet<>();
        set.add(11);
        set.add(15);
        set.add(9);
        set.add(5);

        assertTrue(set.containsAll(set2));
        assertEquals(set.size(), set2.size());
    }

    @Test
    public void mapCollectionsValues() {
        map.put(11, "a");
        map.put(15, "aa");
        map.put(5, "b");
        map.put(9, "c");
        List<String> array = new ArrayList<String>();
        array.add("a");
        array.add("aa");
        array.add("b");
        array.add("c");
        Collection<String> array2 = map.values();

        assertEquals(array.size(), array2.size());
        assertTrue(array.containsAll(array2));
    }
}
