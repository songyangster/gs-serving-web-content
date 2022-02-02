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

    public int minSwapBeforeBalance(String input, int i, int j) {
        if (input == null || input.isEmpty()) return 0;

        int bCount = 0;
        int eCount = 0;
        while (i < j) {
            char cB = input.charAt(i);
            char cE = input.charAt(j - 1);
            i++;
            j--;
            // step1: find a new begin position that has to be swapped
            if (!(cB == '[' && cE == ']')) {
                // step2: find a new j position that has to be swapped
                // step3: swap i and j chars
                bCount = cB == '[' ? bCount + 1 : bCount - 1;
                eCount = cE == ']' ? eCount + 1 : eCount - 1;

                if (bCount == eCount) {
                    return Math.abs(bCount) + minSwapBeforeBalance(input, i, j);
                }
            }
        }

        return 0;
    }
}
