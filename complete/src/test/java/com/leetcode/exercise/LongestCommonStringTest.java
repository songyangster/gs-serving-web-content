package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonStringTest {
    @Test
    public void testLongestCommonString () {
        LongestCommonString longestCommonString = new LongestCommonString();

        assertEquals ("fl", longestCommonString.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
