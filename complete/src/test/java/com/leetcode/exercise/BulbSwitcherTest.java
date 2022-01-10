package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BulbSwitcherTest {
    BulbSwitcher bulbSwitcher = new BulbSwitcher();

    @Test
    public void testBulbSwitcher() {
        assertEquals(1, bulbSwitcher.bulbSwitch(3));
    }
}
