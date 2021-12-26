package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllOneTest {

    @Test
    public void testAllOne() {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        assertEquals("hello", allOne.getMaxKey()); // return "hello"
        assertEquals("hello", allOne.getMinKey()); // return "hello"
        allOne.inc("leet");
        assertEquals("hello", allOne.getMaxKey()); // return "hello"
        assertEquals("leet", allOne.getMinKey()); // return "leet"
    }
}
