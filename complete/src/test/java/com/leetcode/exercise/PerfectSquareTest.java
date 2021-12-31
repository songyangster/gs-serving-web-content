package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerfectSquareTest {
    @Test
    public void testPerfectSquare() {
        PerfectSquare perfectSquare = new PerfectSquare();

        assertTrue(perfectSquare.isPerfectSquare(1));
        assertTrue(perfectSquare.isPerfectSquare(16));
        assertFalse(perfectSquare.isPerfectSquare(14));
        assertFalse(perfectSquare.isPerfectSquare(2147483647));
        assertTrue(perfectSquare.isPerfectSquare(36));
        assertTrue(perfectSquare.isPerfectSquare(808201));
        assertTrue(perfectSquare.isPerfectSquare(104976));
    }
}
