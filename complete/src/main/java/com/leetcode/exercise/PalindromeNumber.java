package com.leetcode.exercise;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        List<Integer> digits = new ArrayList<>();
        while (x > 0) {
            int mod = x % 10;
            digits.add(mod);
            x = (int) x / 10;
        }

        for (int i = 0; i <=  digits.size()/2; i++){
            if (digits.get(i) != digits.get(digits.size() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
