package com.leetcode.exercise;

import com.leetcode.exercise.utilities.JSONConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RPNTest {
    @Test
    public void testRPN () throws Exception {
        RPN rpn = new RPN();

        assertEquals(9, rpn.evalRPN(JSONConverter.convertJSONtoStringArray("[\"2\",\"1\",\"+\",\"3\",\"*\"]")));
        assertEquals(6, rpn.evalRPN(JSONConverter.convertJSONtoStringArray("[\"4\",\"13\",\"5\",\"/\",\"+\"]")));
        assertEquals(22, rpn.evalRPN(JSONConverter.convertJSONtoStringArray("[\"10\",\"6\",\"9\",\"3\",\"+\",\"-11\",\"*\",\"/\",\"*\",\"17\",\"+\",\"5\",\"+\"]")));
    }

    @Test
    public void testRPNLambda () throws Exception {
        RPN rpn = new RPN();

        assertEquals(9, rpn.evalRPNLambda(JSONConverter.convertJSONtoStringArray("[\"2\",\"1\",\"+\",\"3\",\"*\"]")));
        assertEquals(6, rpn.evalRPNLambda(JSONConverter.convertJSONtoStringArray("[\"4\",\"13\",\"5\",\"/\",\"+\"]")));
        assertEquals(22, rpn.evalRPNLambda(JSONConverter.convertJSONtoStringArray("[\"10\",\"6\",\"9\",\"3\",\"+\",\"-11\",\"*\",\"/\",\"*\",\"17\",\"+\",\"5\",\"+\"]")));
    }
}
