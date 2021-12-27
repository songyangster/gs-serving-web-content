package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsomophricTest {
    @Test
    public void testIsIsomorphic() {
        IsoMorphic isoMorphic = new IsoMorphic();

        assertTrue(isoMorphic.isIsomorphic("egg", "add"));
        assertFalse(isoMorphic.isIsomorphic("foo", "bar"));
        assertTrue(isoMorphic.isIsomorphic("paper", "title"));
    }
}
