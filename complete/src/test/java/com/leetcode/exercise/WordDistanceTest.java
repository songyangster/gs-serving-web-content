package com.leetcode.exercise;

import com.leetcode.exercise.utilities.JSONConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordDistanceTest {

    @Test
    public void testWordDistnace() throws Exception {
        WordDistance wordDistance = new WordDistance(JSONConverter.convertJSONtoStringArray("[\"WordDistance\"]"));

        assertEquals(0, wordDistance.shortest("shortest", "shortest"));

        wordDistance = new WordDistance(JSONConverter.convertJSONtoStringArray("[\"practice\", \"makes\", \"perfect\", \"coding\", \"makes\"]"));
        assertEquals(3, wordDistance.shortest("coding", "practice"));
        assertEquals(1, wordDistance.shortest("makes", "coding"));
    }
}
