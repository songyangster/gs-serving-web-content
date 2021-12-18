package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberIslandTest {

    @Test
    public void testNumberIsland() throws Exception {
        NumberIsland numberIsland = new NumberIsland();

        String jsonString = "[\n" +
                "  [\"1\",\"1\",\"1\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"0\",\"0\",\"0\"]\n" +
                "]";
        char[][] arrayOfArrays = JSONConverter.convertJSONtoChar2DArray(jsonString);
        assertEquals (0, numberIsland.numIslands(arrayOfArrays));


    }

}
