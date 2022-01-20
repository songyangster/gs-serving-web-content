package com.leetcode.exercise;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringOpTest {
    StringOp stringOp = new StringOp();

    @Disabled
    @Test
    public void testInterLeave() {
        assertTrue(stringOp.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertFalse(stringOp.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        assertTrue(stringOp.isInterleave("", "", ""));
        assertFalse(stringOp.isInterleave("bbbcc", "bbaccbbbabcacc", "bbbbacbcccbcbabbacc"));
    }
}
