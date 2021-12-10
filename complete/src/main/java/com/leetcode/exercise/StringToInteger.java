package com.leetcode.exercise;

import java.util.ArrayList;
import java.util.List;

public class StringToInteger {
    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;
        int i = 0;
        boolean isPositive = true;
        boolean isLead = true;
        boolean isSign = false;
        List<Integer> digits =  new ArrayList<>();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (isLead) {
                if (c == ' ' || c == '+') {
                    if (c == '+') {
                        if (isSign) return 0;
                        isSign = true;
                        isLead = false;
                    }
                } else if (c == '-') {
                    if (isSign) return 0;
                    isSign = true;
                    isLead = false;
                    isPositive = false;
                } else if (c >= '0' && c <= '9') {
                    isLead = pushDigit(digits, c);
                } else {
                    break;
                }
            } else {
                if (c >= '0' && c <= '9') {
                    isLead = pushDigit(digits, c);
                } else {
                    break;
                }
            }
            i++;
        }

        int val = 0;
        int base = 1;
        for (int j = digits.size() -1 ; j >= 0; j--) {
            try {
                int num = Math.multiplyExact(digits.get(j), base);
                val = Math.addExact(val, num);
                if (j > 0) {
                    base = Math.multiplyExact(base, 10);
                }
            } catch (Exception e) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }

        return val * (isPositive ? 1 : -1);
    }

    private static boolean pushDigit(List<Integer> digits, char c) {
        boolean isLead;
        if (!(digits.isEmpty() && c == '0')) digits.add(c - 48);
        isLead = false;
        return isLead;
    }
}
