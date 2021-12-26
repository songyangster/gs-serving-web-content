package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {
    private Palindrome palindrome = new Palindrome();

    @Test
    public void testPalindromeString() {
        assertEquals("a", palindrome.longestPalindrome("a"));
        assertEquals("bb", palindrome.longestPalindrome("cbbd"));
        assertEquals("bab", palindrome.longestPalindrome("babad"));
        assertEquals("dfd", palindrome.longestPalindrome("dfd"));
        assertEquals("ccc", palindrome.longestPalindrome("ccc"));
    }

    @Test
    public void testPalindromeNumber() {
        assertTrue(palindrome.isPalindrome(121));
        assertTrue(palindrome.isPalindrome(-121));
        assertTrue(palindrome.isPalindrome(-123121321));
        assertFalse(palindrome.isPalindrome(10));
        assertTrue(palindrome.isPalindrome(0));
        assertTrue(palindrome.isPalindrome(3));
    }
}
