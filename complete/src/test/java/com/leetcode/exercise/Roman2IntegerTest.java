package com.leetcode.exercise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Roman2IntegerTest {
    Roman2Integer roman2Integer;

    @BeforeEach
    public void init() {
        this.roman2Integer = new Roman2Integer();
    }

    @Test
    public void testRoman2Integer() {
        assertEquals (3, roman2Integer.romanToInt("III"));
        assertEquals (4, roman2Integer.romanToInt("IV"));
        assertEquals (9, roman2Integer.romanToInt("IX"));
        assertEquals (58, roman2Integer.romanToInt("LVIII"));
    }

    @Test
    public void testIntegerToRoman () {
        assertEquals ("III", roman2Integer.intToRoman(3));
        assertEquals ("IV", roman2Integer.intToRoman(4));
        assertEquals ("IX", roman2Integer.intToRoman(9));
        assertEquals ("LVIII", roman2Integer.intToRoman(58));
        assertEquals ("MCMXCIV", roman2Integer.intToRoman(1994));
        assertEquals ("X", roman2Integer.intToRoman(10));
    }
}
