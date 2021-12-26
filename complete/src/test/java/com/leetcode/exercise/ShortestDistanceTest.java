package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestDistanceTest {
    @Test
    public void testShortest () throws Exception{
        ShortestDistance shortestDistance = new ShortestDistance();

        assertEquals(3, shortestDistance.shortestDistance(JSONConverter.convertJSONtoStringArray("[\"practice\", \"makes\", \"perfect\", \"coding\", \"makes\"]"), "coding", "practice"));
        assertEquals(1, shortestDistance.shortestDistance(JSONConverter.convertJSONtoStringArray("[\"practice\", \"makes\", \"perfect\", \"coding\", \"makes\"]"), "coding", "makes"));
    }
}
