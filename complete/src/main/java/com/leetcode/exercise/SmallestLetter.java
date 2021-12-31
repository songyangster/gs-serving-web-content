package com.leetcode.exercise;

public class SmallestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        char val = letters[0];
        if (target == 'z') return val;
        for (char c : letters) {
            if (c > target) return c;
        }
        return val;
    }
}
