package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OriginalArrayTest {
    @Test
    public void testOriginalArray() {
        OriginalArray originalArray = new OriginalArray();

        assertEquals (arrayToSet(new int[0]), arrayToSet(originalArray.findOriginalArray(new int[]{0,4,3,0,0})));
        assertEquals (arrayToSet(new int[]{1,3,4}), arrayToSet(originalArray.findOriginalArray(new int[]{1,3,4,2,6,8})));
    }

    private Set<Integer> arrayToSet(int[] array) {
        Set<Integer> newSet = Arrays.stream(array).boxed().collect(Collectors.toSet());
        return newSet;
    }
}
