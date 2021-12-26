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
        assertEquals (1, numberIsland.numIslands(JSONConverter.convertJSONtoChar2DArray(jsonString)));

        jsonString = "[\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"1\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"0\",\"1\",\"1\"]\n" +
                "]";
        assertEquals (3, numberIsland.numIslands(JSONConverter.convertJSONtoChar2DArray(jsonString)));


    }

}
