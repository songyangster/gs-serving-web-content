package com.leetcode.exercise;

import com.leetcode.exercise.utilities.JSONConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockTest {
    @Test
    public void testStock() throws Exception {
        Stock stock = new Stock();

        assertEquals(35, stock.maxProfit(JSONConverter.convertJSONtoIntArray("\n" +
                "[7,6,4,3,1,4,7,8,9,12,24,1,36]")));
        assertEquals(90, stock.maxProfit(JSONConverter.convertJSONtoIntArray("\n" +
                "[10,100,4,3,1,4,7,8,9,12,24,1,36]")));
    }
}
