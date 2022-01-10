package com.leetcode.exercise;

import org.junit.jupiter.api.Disabled;
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

    @Disabled
    @Test
    public void testRandomCollections() {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        assertTrue(randomizedCollection.insert(1));
        assertFalse(randomizedCollection.insert(1));
        assertTrue(randomizedCollection.insert(2));
        assertTrue(randomizedCollection.getRandom() > 0);
        assertTrue(randomizedCollection.remove(1));
        assertTrue(randomizedCollection.getRandom() > 0);

        randomizedCollection = new RandomizedCollection();
        assertTrue(randomizedCollection.insert(1));
        assertTrue(randomizedCollection.remove(1));
        assertTrue(randomizedCollection.insert(1));

        randomizedCollection = new RandomizedCollection();
        assertTrue(randomizedCollection.insert(10));
        assertFalse(randomizedCollection.insert(10));
        assertTrue(randomizedCollection.insert(20));
        assertFalse(randomizedCollection.insert(20));
        assertTrue(randomizedCollection.insert(30));
        assertFalse(randomizedCollection.insert(30));
        assertTrue(randomizedCollection.remove(10));
        assertTrue(randomizedCollection.remove(20));
        assertTrue(randomizedCollection.remove(20));
        assertTrue(randomizedCollection.remove(30));
        assertTrue(randomizedCollection.insert(40));
        assertTrue(randomizedCollection.remove(30));
        assertFalse(randomizedCollection.remove(30));
        assertTrue(randomizedCollection.getRandom() > 0);
        assertTrue(randomizedCollection.getRandom() > 0);
        assertTrue(randomizedCollection.getRandom() > 0);
        assertTrue(randomizedCollection.getRandom() > 0);
        assertTrue(randomizedCollection.getRandom() > 0);
        assertTrue(randomizedCollection.getRandom() > 0);
        assertTrue(randomizedCollection.getRandom() > 0);
        assertTrue(randomizedCollection.getRandom() > 0);
        assertTrue(randomizedCollection.getRandom() > 0);
    }
}
