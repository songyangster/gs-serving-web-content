package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalancedParentheseTest {
    BalanceParentheses balanceParentheses = new BalanceParentheses();

    @Test
    public void testBalancedParenthese () {

        assertEquals(1, balanceParentheses.minInsertions("(()))"));
        assertEquals(0, balanceParentheses.minInsertions("())"));
        assertEquals(3, balanceParentheses.minInsertions("))())("));
    }

    /*
Minimum number of swaps to make a string balanced

Given a 0-indexed string s of even length n. The string consists of exactly n/2 opening brackets '[', and n/2 closing brackets ']'.

A string is called balanced if and only if:
It is the empty string, or
It can be written as AB, where both A and B are balanced strings, or
It can be written as [C], where C is a balanced string.

Return the minimum number of swaps to make string s balanced.

Examples
Input: s = "][]["     Output: 1
Input: s = "]]][[["   Output: 2
Input: s = "[]"       Output: 0
Input: s = "]]][ [[]] [["   Output: 2

]]][[[]][[
->
[]][[[]][]
  **
->
[][][[]][]

diff = count([) - count(]) in range [0..i]
if diff >= 0
<=> the original string is balanced
*/



    @Test
    public void testMiniSwamp() {
        String s = "][][";
        assertEquals(1, balanceParentheses.minSwapBeforeBalance(s, 0, s.length()));
        s = "]]][[[";
        assertEquals(2, balanceParentheses.minSwapBeforeBalance(s, 0, s.length()));
        s = "[]";
        assertEquals(0, balanceParentheses.minSwapBeforeBalance(s, 0, s.length()));
        s = "]]][[[]][[";
        assertEquals(2, balanceParentheses.minSwapBeforeBalance(s, 0, s.length()));
    }

}
