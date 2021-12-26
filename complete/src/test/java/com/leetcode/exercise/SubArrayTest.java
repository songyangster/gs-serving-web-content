package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubArrayTest {
    SubArray subArray = new SubArray();

    @Test
    public void testSubArray() throws Exception {
        assertEquals(1, subArray.maxSubArray(JSONConverter.convertJSONtoIntArray("[1]")));
        assertEquals(1, subArray.maxSubArray(JSONConverter.convertJSONtoIntArray("[-2, 1]")));
        assertEquals(9, subArray.maxSubArray(JSONConverter.convertJSONtoIntArray("[5,4]")));
        assertEquals(9, subArray.maxSubArray(JSONConverter.convertJSONtoIntArray("[5,4,-1]")));
        assertEquals(15, subArray.maxSubArray(JSONConverter.convertJSONtoIntArray("[5,4,-1,7]")));
        assertEquals(23, subArray.maxSubArray(JSONConverter.convertJSONtoIntArray("[5,4,-1,7,8]")));
        assertEquals(6, subArray.maxSubArray(JSONConverter.convertJSONtoIntArray("[-2,1,-3,4,-1,2,1,-5,4]")));
        assertEquals(-1, subArray.maxSubArray(JSONConverter.convertJSONtoIntArray("[-2,-1]")));
    }

    @Test
    public void testSubArrayGreedy() throws Exception {
        assertEquals(23, subArray.maxSubArrayGreedy(JSONConverter.convertJSONtoIntArray("[5,4,-1,7,8]")));
        assertEquals(6, subArray.maxSubArrayGreedy(JSONConverter.convertJSONtoIntArray("[-2,1,-3,4,-1,2,1,-5,4]")));
        assertEquals(1, subArray.maxSubArrayGreedy(JSONConverter.convertJSONtoIntArray("[1]")));
        assertEquals(1, subArray.maxSubArrayGreedy(JSONConverter.convertJSONtoIntArray("[-2, 1]")));
    }

    @Test
    public void testSubArrayRecursion() throws Exception {
        assertEquals(23, subArray.maxSubArrayRecursion(JSONConverter.convertJSONtoIntArray("[5,4,-1,7,8]")));
        assertEquals(6, subArray.maxSubArrayRecursion(JSONConverter.convertJSONtoIntArray("[-2,1,-3,4,-1,2,1,-5,4]")));
        assertEquals(1, subArray.maxSubArrayRecursion(JSONConverter.convertJSONtoIntArray("[1]")));
        assertEquals(1, subArray.maxSubArrayRecursion(JSONConverter.convertJSONtoIntArray("[-2, 1]")));
    }
}
