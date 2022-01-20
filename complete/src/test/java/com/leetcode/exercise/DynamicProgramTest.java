package com.leetcode.exercise;

import com.leetcode.exercise.utilities.JSONConverter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicProgramTest {
    DynamicProgram dynamicProgram = new DynamicProgram();

    @Test
    public void testFindLength () {
        assertEquals(3, dynamicProgram.findLength(JSONConverter.convertJSONtoIntArray("[1,2,3,2,1]"), JSONConverter.convertJSONtoIntArray("[3,2,1,4,7]")));
        assertEquals(5, dynamicProgram.findLength(JSONConverter.convertJSONtoIntArray("[0,0,0,0,0]"), JSONConverter.convertJSONtoIntArray("[0,0,0,0,0]")));
    }

    @Disabled
    @Test
    public void testDivide() {
        assertEquals(2, dynamicProgram.divide(10, 5));
//        assertEquals(3, dynamicProgram.divide(10, 3));
        assertEquals(-2, dynamicProgram.divide(7, -3));
    }
}
