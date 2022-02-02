package com.leetcode.exercise;

import com.leetcode.exercise.utilities.JSONConverter;
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

    @Test
    public void testMaxProduct() {
        assertEquals(6, subArray.maxProduct(JSONConverter.convertJSONtoIntArray("[2,3,-2,4]")));
        assertEquals(12, subArray.maxProduct(JSONConverter.convertJSONtoIntArray("[-4,-3]")));
        assertEquals(1, subArray.maxProduct(JSONConverter.convertJSONtoIntArray("[-1,-1]")));
        assertEquals(24, subArray.maxProduct(JSONConverter.convertJSONtoIntArray("[-2,3,-4]")));
    }

    @Test
    public void testNumSubarray() {
        assertEquals(8, subArray.numSubarrayProductLessThanK(JSONConverter.convertJSONtoIntArray("[10,5,2,6]"), 100));
    }

    @Test
    public void testFindREpeat() {
        assertEquals("[AAAAAAAAAA]", subArray.findRepeatedDnaSequences("AAAAAAAAAAA").toString());
    }

    @Test
    public void testFindLeastNumOfUniqueInts() {
        assertEquals(1, subArray.findLeastNumOfUniqueInts(JSONConverter.convertJSONtoIntArray("[5,5,4]"), 1));
        assertEquals(3, subArray.findLeastNumOfUniqueInts(JSONConverter.convertJSONtoIntArray("[2,4,1,8,3,5,1,3]"), 3));
        assertEquals(2, subArray.findLeastNumOfUniqueInts(JSONConverter.convertJSONtoIntArray("[4,3,1,1,3,3,2]"), 3));
    }

    @Test
    public void testSubArraySum() {
        assertEquals(2, subArray.subarraySum(JSONConverter.convertJSONtoIntArray("[1,1,1]"), 2));
    }
}
