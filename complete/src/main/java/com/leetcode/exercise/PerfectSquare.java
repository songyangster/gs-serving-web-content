package com.leetcode.exercise;

public class PerfectSquare {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num, x, guessSquared;
        while (left <= right) {
            x = left + (right - left) / 2;
            // OK to overflow
            guessSquared = x * x;
            if (guessSquared == num) {
                return true;
            }
            if (num / x < x) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;
    }

    public int mySqrt(int num) {
        int left = 1, right = num, x = 1, guessSquared;
        while (left <= right) {
            x = left + (right - left) / 2;
            // OK to overflow
            guessSquared = x * x;
            if (guessSquared == num) {
                return x;
            }
            if (num / x < x) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return right;
    }
}
