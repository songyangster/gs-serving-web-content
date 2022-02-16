package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseIntegerTest {
    @Test
    public void testReverseInteger() {
        ReverseInteger reverseInteger = new ReverseInteger();

        assertEquals (321, reverseInteger.reverse(123));
        assertEquals (-321, reverseInteger.reverse(-123));
        assertEquals (21, reverseInteger.reverse(120));
        assertEquals (0, reverseInteger.reverse(0));
    }
}
