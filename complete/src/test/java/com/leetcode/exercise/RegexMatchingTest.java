package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegexMatchingTest {
    @Test
    public void testRegexMatching() {
        RegexMatching regexMatching = new RegexMatching();

        assertTrue(regexMatching.isMatch("aabc", "aabc"));
        assertFalse(regexMatching.isMatch("aa", "a"));
        assertTrue(regexMatching.isMatch("aa", "a*"));
        assertTrue(regexMatching.isMatch("aab", "c*a*b"));
        assertFalse(regexMatching.isMatch("mississippi", "mis*is*p*."));
        assertTrue(regexMatching.isMatch("mississippi", "mis*is*ip*i"));
        assertTrue(regexMatching.isMatch("ab", ".*"));
//        assertTrue(regexMatching.isMatch("aaa", "ab*a*c*a"));
        assertTrue(regexMatching.isMatch("aaa", "a*a"));
    }
}
