package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthElementArrayTest {
    @Test
    public void testKthElementArray() throws Exception {
        KthElementArray kthElementArray = new KthElementArray();

        assertEquals(5, kthElementArray.findKthLargest(JSONConverter.convertJSONtoIntArray("[3,2,1,5,6,4]"), 2));
        assertEquals(4, kthElementArray.findKthLargest(JSONConverter.convertJSONtoIntArray("[3,2,3,1,2,4,5,5,6]"), 4));
    }
}
