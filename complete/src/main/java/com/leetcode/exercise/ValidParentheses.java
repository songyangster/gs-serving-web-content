package com.leetcode.exercise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Integer> sym = new HashMap<Character, Integer>() {{
            put('(', 1);
            put(')', -1);
            put('{', 1);
            put('}', -1);
            put('[', 1);
            put(']', -1);
        }};
        Map<Character, Character> pairing = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (sym.get(c) > 0) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                Character cPop = stack.pop();
                if (cPop != pairing.get(c)) return false;
            }
        }

        return  stack.isEmpty();
    }

    public boolean checkValidString(String s) {
        return checkSubString(s, 0, null, 0);
    }

    private boolean checkSubString(String s, int index, Character cb, int leftCount) {
        boolean isCB = cb != null;
        while (index < s.length() || isCB) {
            Character c = isCB ? cb : s.charAt(index);
            if (c =='(') {
                leftCount++;
            } else if (c == ')'){
                if (leftCount == 0) return false;
                leftCount--;
            } else {
                // * - Check for all possibilities, with empty char first for efficiency
                return  checkSubString(s, index + 1,')', leftCount) ||
                        checkSubString(s, index + 1, null, leftCount) ||
                        checkSubString(s, index + 1, '(', leftCount);
            }
            if (isCB) {
                isCB = false;
            } else {
                index++;
            }
        }
        return leftCount == 0;
    }

    public String minRemoveToMakeValid(String s) {
        StringBuffer b = new StringBuffer();

        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c == ')' && n == 0)) {
                if (c == '(') {
                    n++;
                } else if (c == ')') {
                    n--;
                }
                b.insert(0, c);
            }
        }

        s = b.toString();
        b = new StringBuffer();
        n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c == '(' && n == 0)) {
                if (c == ')') {
                    n++;
                } else if (c == '(') {
                    n--;
                }
                b.insert(0, c);
            }
        }
        return b.toString();
    }
}
