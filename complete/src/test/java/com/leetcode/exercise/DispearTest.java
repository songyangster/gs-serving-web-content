package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DispearTest {

    @Test
    public void testDispear() {
        Dispear dispear = new Dispear();
        int[][] grid1 = {{4, 4, 4, 4},
                {5, 5, 5, 4},
                {2, 5, 7, 5}};
        int[][] grid2 = {{0, 3, 3, 3, 3, 3, 3},
                {0, 1, 1, 1, 1, 1, 3},
                {0, 2, 2, 0, 2, 1, 4},
                {0, 1, 2, 2, 2, 1, 3},
                {0, 1, 1, 1, 1, 1, 3},
                {0, 0, 0, 0, 0, 0, 0}};
        int[][] grid3 = {{0}};
        int[][] grid4 = {{1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}};

        assertEquals(5, dispear.disappear(grid1, 0, 0));
        assertEquals(dispear.disappear(grid1, 1, 1), 4);
        assertEquals(dispear.disappear(grid1, 1, 0), 4);
        assertEquals(dispear.disappear(grid2, 0, 0), 12);
        assertEquals(dispear.disappear(grid2, 3, 0), 12);
        assertEquals(dispear.disappear(grid2, 1, 1), 13);
        assertEquals(dispear.disappear(grid2, 2, 2), 6);
        assertEquals(dispear.disappear(grid2, 0, 3), 7);
        assertEquals(dispear.disappear(grid3, 0, 0), 1);
        assertEquals(dispear.disappear(grid4, 0, 0), 9);
    }
}
