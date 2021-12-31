package com.leetcode.exercise;

import com.leetcode.exercise.utilities.JSONConverter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KSmallestPairsTest {
    @Disabled
    @Test
    public void testKSmallestPairs() throws Exception {
        KSmallestPairs kSmallestPairs = new KSmallestPairs();

        assertEquals("[[1, 1], [1, 1], [1, 2]]",
                kSmallestPairs.kSmallestPairs(JSONConverter.convertJSONtoIntArray("[1,1,2]"), JSONConverter.convertJSONtoIntArray("[1,2,3]"), 3).toString());
        assertEquals("[[1, 1], [1, 1], [1, 2], [1, 2]]]",
                kSmallestPairs.kSmallestPairs(JSONConverter.convertJSONtoIntArray("[1,1,2]"), JSONConverter.convertJSONtoIntArray("[1,2,3]"), 4).toString());
    }
}
