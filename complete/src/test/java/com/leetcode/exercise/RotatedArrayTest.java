package com.leetcode.exercise;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotatedArrayTest {
    @Disabled
    @Test
    public void testRotatedArray() throws Exception {
        RotateSortArray rotateSortArray = new RotateSortArray();

        assertEquals(4, rotateSortArray.search(JSONConverter.convertJSONtoIntArray("[4,5,6,7,0,1,2]"), 0));
    }
}
