package com.leetcode.exercise;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidParenhesesTest {
    ValidParentheses validParentheses = new ValidParentheses();

    @Test
    public void testValidParenthese () {

        assertTrue (validParentheses.isValid("{}"));
        assertTrue (validParentheses.isValid("()[]{}"));
        assertTrue (validParentheses.isValid("{[]}"));
        assertFalse (validParentheses.isValid("(]"));
        assertFalse (validParentheses.isValid("([)]"));
    }

    @Disabled
    @Test
    public void testCheckValidString() {
        assertTrue(validParentheses.checkValidString("()"));
        assertTrue(validParentheses.checkValidString("(*)"));
        assertTrue(validParentheses.checkValidString("(*))"));
        assertTrue(validParentheses.checkValidString("(((*)()(*()()()*))))"));
        assertTrue(validParentheses.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
        assertTrue(validParentheses.checkValidString("******************************************"));
        assertTrue(validParentheses.checkValidString("************************************************************"));
//        assertTrue(validParentheses.checkValidString("**************************************************))))))))))))))))))))))))))))))))))))))))))))))))))"));
    }
}
