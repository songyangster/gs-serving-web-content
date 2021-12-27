package com.leetcode.exercise;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextJustifyTest {
    @Disabled
    @Test
    public void testTextJustify() throws Exception {
        TextJustification textJustification = new TextJustification();

        assertEquals("[This is an , example of text , justification. ]", textJustification.fullJustify(JSONConverter.convertJSONtoStringArray("[\"This\", \"is\", \"an\", \"example\", \"of\", \"text\", \"justification.\"]"), 16).toString());
    }
}
