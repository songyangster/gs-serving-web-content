package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DecimalTest {
    @Test
    public void testDecimal() {
        Decimal decimal = new Decimal();

        assertFalse(decimal.isNumber("e"));
        assertFalse(decimal.isNumber("E"));
        assertFalse(decimal.isNumber("."));
        assertTrue(decimal.isNumber("0"));
        assertTrue(decimal.isNumber("-90E3"));
        assertTrue(decimal.isNumber("3e+7"));
        assertTrue(decimal.isNumber("-123.456e789"));
        assertTrue(decimal.isNumber("+3.14"));
        assertTrue(decimal.isNumber("0089"));
        assertFalse(decimal.isNumber("e9"));
        assertFalse(decimal.isNumber("0E"));
        assertFalse(decimal.isNumber(".e1"));
        assertFalse(decimal.isNumber("6+1"));
    }
}
