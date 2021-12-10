package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringToIntegerTest {
    @Test
    public void testStringToInteger() {
        assertEquals(123456, StringToInteger.myAtoi("123456"));
        assertEquals(-123456, StringToInteger.myAtoi("   -123456"));
        assertEquals(123456, StringToInteger.myAtoi("   123456ABC"));
        assertEquals(0, StringToInteger.myAtoi("words and 987"));
        assertEquals(4193, StringToInteger.myAtoi("4193 with words"));
        assertEquals(-2147483648, StringToInteger.myAtoi("-91283472332"));
        assertEquals(1, StringToInteger.myAtoi("+1"));
        assertEquals(0, StringToInteger.myAtoi("+-12"));
        assertEquals(12345678, StringToInteger.myAtoi("  0000000000012345678"));
        assertEquals(0, StringToInteger.myAtoi("  + 413"));
    }
}
