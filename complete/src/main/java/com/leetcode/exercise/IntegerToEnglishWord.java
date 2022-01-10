package com.leetcode.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerToEnglishWord {
    static {
        Map<Integer, Map<Integer, String>> numMap = new HashMap<>();
        Map<Integer, String> singleMap = new HashMap<Integer, String>(){{
            put(0, "");
            put(1, "One");
            put(2, "Two");
        }};
        Map<Integer, String> teenMap = new HashMap<Integer, String>(){{
            put(0, "Ten");
            put(1, "Eleven");
            put(2, "Twelve");
        }};
        Map<Integer, String> tendMap = new HashMap<Integer, String>(){{
            put(0, "");
            put(1, "");
            put(2, "Twenty");
        }};

    }
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuffer buffer = new StringBuffer();

        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num = num / 10;
        }

        for (int i = digits.size() - 1; i >= 0; i --) {
            buffer.append(Integer.MAX_VALUE);
        }
        return null;
    }
}
