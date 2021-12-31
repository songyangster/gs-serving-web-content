package com.leetcode.exercise;

import com.leetcode.exercise.utilities.JSONConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlowerBedTest {
    @Test
    public void testFlowerBed() throws Exception {
        FlowerBed flowerBed = new FlowerBed();

        assertTrue(flowerBed.canPlaceFlowers(JSONConverter.convertJSONtoIntArray("[1,0,0,0,1]"), 1));
        assertFalse(flowerBed.canPlaceFlowers(JSONConverter.convertJSONtoIntArray("[1,0,0,0,1]"), 2));
        assertTrue(flowerBed.canPlaceFlowers(JSONConverter.convertJSONtoIntArray("[1,0,0,0,0,0,1]"), 2));
        assertTrue(flowerBed.canPlaceFlowers(JSONConverter.convertJSONtoIntArray("[1,0,1,0,1,0,1]"), 0));
    }
}
