package com.leetcode.exercise;

import com.leetcode.exercise.utilities.JSONConverter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KSmallestPairsTest {
    KSmallestPairs kSmallestPairs = new KSmallestPairs();

    @Disabled
    @Test
    public void testKSmallestPairs() throws Exception {

        assertEquals("[[1, 1], [1, 1], [1, 2]]",
                kSmallestPairs.kSmallestPairs(JSONConverter.convertJSONtoIntArray("[1,1,2]"), JSONConverter.convertJSONtoIntArray("[1,2,3]"), 3).toString());
        assertEquals("[[1, 1], [1, 1], [1, 2], [1, 2]]]",
                kSmallestPairs.kSmallestPairs(JSONConverter.convertJSONtoIntArray("[1,1,2]"), JSONConverter.convertJSONtoIntArray("[1,2,3]"), 4).toString());
    }

    @Disabled
    @Test
    public void testKClosetPoints () {
        assertEquals("[[3,3],[-2,4]]", Arrays.asList(kSmallestPairs.kClosest(JSONConverter.convertJSONtoInt2DArray("[[3,3],[5,-1],[-2,4]]"), 2)));
    }
}
