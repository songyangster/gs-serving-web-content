package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomizedSetTest {
    @Test
    public void testRandomizedSet() {
        RandomizedSet randomizedSet = new RandomizedSet();
        assertTrue(randomizedSet.insert(0));
        assertTrue(randomizedSet.remove(0));
        assertTrue(randomizedSet.insert(-1));
        assertFalse(randomizedSet.remove(0));
        assertEquals(-1, randomizedSet.getRandom());
        assertEquals(-1, randomizedSet.getRandom());
        assertEquals(-1, randomizedSet.getRandom());
        assertEquals(-1, randomizedSet.getRandom());
        assertEquals(-1, randomizedSet.getRandom());
        assertEquals(-1, randomizedSet.getRandom());
        assertEquals(-1, randomizedSet.getRandom());
    }
}
