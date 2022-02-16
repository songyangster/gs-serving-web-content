package com.leetcode.exercise;

import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {
    public int reverse(int x) {
        List<Integer> digits = new ArrayList<>();
        boolean isPositive = true;
        int xAbs = x;
        if (x < 0) {
            isPositive = false;
            xAbs = -x;
        }
        while (xAbs > 0) {
            digits.add(xAbs % 10);
            xAbs /= 10;
        }
        int val = 0;
        int base = 1;
        for (int i = digits.size() - 1; i >= 0; i--) {
            try {
                int mult = Math.multiplyExact(base, digits.get(i));
                val = Math.addExact(val, mult);
            } catch (ArithmeticException e) {
                val = 0;
                break;
            }
            if (i > 0) {
                try {
                    base = Math.multiplyExact(base, 10);
                } catch (ArithmeticException e) {
                    val = 0;
                    break;
                }
            }
        }
        if (!isPositive) {
            try {
                val = Math.subtractExact(0, val);
            } catch (ArithmeticException e) {
                val = 0;
            }
        }
        return val;
    }
}
