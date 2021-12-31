package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalancedParentheseTest {
    @Test
    public void testBalancedParenthese () {
        BalanceParentheses balanceParentheses = new BalanceParentheses();

        assertEquals(1, balanceParentheses.minInsertions("(()))"));
        assertEquals(0, balanceParentheses.minInsertions("())"));
        assertEquals(3, balanceParentheses.minInsertions("))())("));
    }
}
