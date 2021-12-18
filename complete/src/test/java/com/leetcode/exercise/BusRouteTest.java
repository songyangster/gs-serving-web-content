package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BusRouteTest {
    @Test
    public void testBusRoute() {
        BusRoute busRoute = new BusRoute();

        assertEquals(2, busRoute.numBusesToDestination(new int[][]{{1,2,7}, {3,6,7}}, 1, 6));
        assertEquals(-1, busRoute.numBusesToDestination(new int[][]{{7,12}, {4,5,15},{6},{15,19},{9,12,13}}, 15, 12));
        assertEquals(4, busRoute.numBusesToDestination(new int[][]{{7,12}, {4,5,15},{6},{15,19},{9,12,13}, {4,7}}, 15, 9));
        assertEquals(1, busRoute.numBusesToDestination(new int[][]{{2}, {2,8}}, 2, 8));
    }
}
