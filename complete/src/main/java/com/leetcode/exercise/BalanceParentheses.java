package com.leetcode.exercise;

import java.util.Stack;

public class BalanceParentheses {
    public int minInsertions(String s) {
        StringBuffer buffer = new StringBuffer();
        Stack<Character> stack = new Stack<>();

        int count = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                stack.push('(');
                buffer.append('(');
                i++;
            } else {
                if (!stack.isEmpty()) {
                    buffer.append(stack.pop());
                    buffer.append(')');
                } else {
                    buffer.append('(').append(')');
                    count++;
                }
                i++;
                if (i == s.length() || s.charAt(i) != ')') {
                    count++;
                } else {
                    i++;
                }
                buffer.append(')');
            }
        }
        System.out.println(buffer);
        if (!stack.isEmpty()) count += stack.size() * 2;
        return count;
    }
}
