package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClibStairsTest {
    @Test
    public void testClimbStairs() {
        ClimbStairs climbStairs = new ClimbStairs();

        assertEquals(0, climbStairs.climbStairs(0));
        assertEquals(1, climbStairs.climbStairs(1));
        assertEquals(2, climbStairs.climbStairs(2));
        assertEquals(3, climbStairs.climbStairs(3));
        assertEquals(5, climbStairs.climbStairs(4));
        assertEquals(8, climbStairs.climbStairs(5));
        assertEquals(121393, climbStairs.climbStairs(25));
        assertEquals(14930352, climbStairs.climbStairs(35));
        assertEquals(165580141, climbStairs.climbStairs(40));
        assertEquals(433494437, climbStairs.climbStairs(42));
        assertEquals(1836311903, climbStairs.climbStairs(45));
    }
}
