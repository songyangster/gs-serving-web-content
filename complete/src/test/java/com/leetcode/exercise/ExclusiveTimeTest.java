package com.leetcode.exercise;

import com.leetcode.exercise.utilities.JSONConverter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusiveTimeTest {
    @Disabled
    @Test
    public void testExcludiveTime() {
        ExclusiveTime exclusiveTime = new ExclusiveTime();

        assertEquals("", (new ArrayList(Arrays.asList(exclusiveTime.exclusiveTime(2, Arrays.asList(JSONConverter.convertJSONtoStringArray("[\"0:start:0\",\"1:start:2\",\"1:end:5\",\"0:end:6\"]")))))).toString());
    }
}
