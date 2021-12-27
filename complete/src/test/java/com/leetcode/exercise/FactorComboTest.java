package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorComboTest {

    @Test
    public void testFactorCombi () {
        FactorCombo factorCombo = new FactorCombo();
        assertEquals ("[]", factorCombo.getFactors(1).toString());
        assertEquals ("[]", factorCombo.getFactors(2).toString());
        assertEquals ("[]", factorCombo.getFactors(3).toString());
        assertEquals ("[[2, 2]]", factorCombo.getFactors(4).toString());
        assertEquals ("[[3, 2]]", factorCombo.getFactors(6).toString());
        assertEquals ("[[2, 2, 2], [4, 2]]", factorCombo.getFactors(8).toString());
        assertEquals ("[[2, 6], [2, 2, 3], [3, 4]]", factorCombo.getFactors(12).toString());
        assertEquals ("[[2, 2, 9], [2, 18], [2, 2, 3, 3], [3, 12], [3, 3, 4], [4, 9], [2, 3, 6], [6, 6]]", factorCombo.getFactors(36).toString());
        assertEquals ("[[2, 2, 12], [2, 24], [2, 2, 2, 2, 3], [2, 3, 8], [3, 16], [2, 2, 3, 4], [3, 4, 4], [4, 12], [2, 2, 2, 6], [2, 4, 6], [6, 8]]", factorCombo.getFactors(48).toString());
    }
}
