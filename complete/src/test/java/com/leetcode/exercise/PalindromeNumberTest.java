package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeNumberTest {
    @Test
    public void testPalindromeNumber() {
        assertTrue(PalindromeNumber.isPalindrome(121));
        assertTrue(PalindromeNumber.isPalindrome(-121));
        assertFalse(PalindromeNumber.isPalindrome(10));
        assertTrue(PalindromeNumber.isPalindrome(0));
        assertTrue(PalindromeNumber.isPalindrome(3));


    }
}
